package br.com.ksgprod.fixture;

import static br.com.six2six.fixturefactory.Fixture.of;

import br.com.ksgprod.controller.response.AddressResponse;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AddressResponseFixture implements TemplateLoader {

	public static final String ADDRESS_RESPONSE = "ADDRESS_RESPONSE";

	@Override
	public void load() {

		of(AddressResponse.class).addTemplate(ADDRESS_RESPONSE,
        new Rule() {{

            add("zipCode", "123012123");
            add("street", "Test");
            add("district", "District Test");
            add("city", "City Test");
            add("state", "State Test");

        }});
		
	}

}
