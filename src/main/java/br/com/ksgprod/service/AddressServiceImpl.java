package br.com.ksgprod.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.ksgprod.api.ViaCepAPI;
import br.com.ksgprod.controller.AddressController;
import br.com.ksgprod.controller.response.AddressResponse;

@Service
public class AddressServiceImpl implements AddressService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
	
	private ViaCepAPI viaCepService;
	
	public AddressServiceImpl(ViaCepAPI viaCepService) {
		this.viaCepService = viaCepService;
	}

	@Override
	public AddressResponse findByCep(String cep) {
		
		LOGGER.info("stage=init method=AddressServiceImpl.findByCep cep={}", cep);
		
		AddressResponse response = this.viaCepService.findByCep(cep);
		
		LOGGER.info("stage=end method=AddressServiceImpl.findByCep response={}", response);
		
		return response;
	}

}
