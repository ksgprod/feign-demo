package br.com.ksgprod.api;

import br.com.ksgprod.controller.response.AddressResponse;
import feign.Param;
import feign.RequestLine;

public interface ViaCepAPI {
	
	@RequestLine("GET /{cep}/json")
	AddressResponse findByCep(@Param("cep") String cep);

}
