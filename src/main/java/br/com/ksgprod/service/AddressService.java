package br.com.ksgprod.service;

import br.com.ksgprod.controller.response.AddressResponse;

public interface AddressService {
	
	AddressResponse findByZipCode(String zipCode);

}
