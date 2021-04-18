package br.com.ksgprod.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.ksgprod.BaseTest;
import br.com.ksgprod.service.AddressService;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
@AutoConfigureMockMvc
public class AddressControllerTest extends BaseTest {
	
	private static final String PATH = "/api/address";
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private AddressService service;

	@Test
	public void testGetAddressByZipCode() throws Exception {

		mvc.perform(MockMvcRequestBuilders
				.get(PATH.concat("/").concat("12312312"))
				.accept(APPLICATION_JSON_VALUE)
				.contentType(APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isOk());
	
	}
	
	@Test
	public void testGetAddressByCepNotFound() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders
				.get(PATH.concat("/"))
				.accept(APPLICATION_JSON_VALUE)
				.contentType(APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isNotFound());
		
	}

}
