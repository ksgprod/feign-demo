package br.com.ksgprod;

import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.Before;
import org.junit.BeforeClass;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class BaseTest {
	
	@Before
	public void before() {
		openMocks(this);
	}
	
	@BeforeClass
	public static void setUp() {
		FixtureFactoryLoader.loadTemplates("br.com.ksgprod.fixture");
	}

}
