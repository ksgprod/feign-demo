package br.com.ksgprod.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ksgprod.controller.response.AddressResponse;
import br.com.ksgprod.service.AddressService;

@RestController
@RequestMapping("/api/viacep/{cep}")
public class AddressController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
	
	private AddressService service;
	
	public AddressController(AddressService service) {
		this.service = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressResponse> getAddressByCep(@PathVariable(value = "cep") String cep) throws Exception {

		LOGGER.info("stage=init method=AddressController.getAddressByCep cep={}", cep);

		AddressResponse response = this.service.findByCep(cep);

		LOGGER.info("stage=end method=AddressController.getAddressByCep response={}", response);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
