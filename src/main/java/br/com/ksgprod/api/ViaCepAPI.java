package br.com.ksgprod.api;

import br.com.ksgprod.controller.response.AddressResponse;
import feign.Param;
import feign.RequestLine;

public interface ViaCepAPI {
	
	@RequestLine("GET /{zipCode}/json")
	AddressResponse findByZipCode(@Param("zipCode") String zipCode);

}
