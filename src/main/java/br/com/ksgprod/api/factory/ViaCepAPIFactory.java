package br.com.ksgprod.api.factory;

import static java.lang.Boolean.TRUE;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import br.com.ksgprod.api.ViaCepAPI;
import br.com.ksgprod.api.error.CustomErrorDecoder;
import br.com.ksgprod.utils.Environments;
import feign.Feign;
import feign.Logger.Level;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;

@Configuration
public class ViaCepAPIFactory {
	
	@Bean
	public ViaCepAPI viaCepAPI(Environment environment) {
		
		String host = environment.getProperty(Environments.VIA_CEP_API_HOST);
		Integer connectionTimeout = environment.getProperty(Environments.VIA_CEP_API_CONNECTION_TIMEOUT, Integer.class);
		Integer readTimeout = environment.getProperty(Environments.VIA_CEP_API_READ_TIMEOUT, Integer.class);
		Request.Options options = new Request.Options(connectionTimeout, SECONDS, readTimeout, SECONDS, TRUE);
		
		return Feign.builder()
				.options(options)
				.encoder(new GsonEncoder())
				.decoder(new GsonDecoder())
				.logger(new Slf4jLogger())
				.logLevel(Level.FULL)
				.errorDecoder(new CustomErrorDecoder())
				.target(ViaCepAPI.class, host);
	}
	
}
