package br.ce.wcaquino.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Logando_Google extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void acessarTelaInicial(){
		DriverFactory.getDriver().get("https://globo.com");
	}
	
	
	
}
