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
	public AddressResponse findByZipCode(String zipCode) {
		
		LOGGER.info("stage=init method=AddressServiceImpl.findByZipCode zipCode={}", zipCode);
		
		AddressResponse response = this.viaCepService.findByZipCode(zipCode);
		
		LOGGER.info("stage=end method=AddressServiceImpl.findByZipCode response={}", response);
		
		return response;
	}

}
