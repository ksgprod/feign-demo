package br.com.ksgprod.service;

import static br.com.ksgprod.fixture.AddressResponseFixture.ADDRESS_RESPONSE;
import static br.com.six2six.fixturefactory.Fixture.from;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.ksgprod.BaseTest;
import br.com.ksgprod.api.ViaCepAPI;
import br.com.ksgprod.controller.response.AddressResponse;

public class AddressServiceImplTest extends BaseTest {
	
	private static final Integer ONE = 1;

	@Mock
	private ViaCepAPI viaCepService;
	
	@InjectMocks
	private AddressServiceImpl service;
	
	@Test
	public void testFindByZipCode() {

		AddressResponse response = from(AddressResponse.class).gimme(ADDRESS_RESPONSE);
		
		when(service.findByZipCode(response.getZipCode())).thenReturn(response);
		
		AddressResponse responseReturn = this.service.findByZipCode(response.getZipCode());
		
		assertNotNull(responseReturn);
		verify(viaCepService, times(ONE)).findByCep(response.getZipCode());
	
	}

}
