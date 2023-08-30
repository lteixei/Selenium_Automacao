package br.ce.wcaquino.tests;

import br.ce.wcaquino.pages.DadosDoClientePage;
import br.ce.wcaquino.pages.LoginPage;

public class DadosDoClienteTest extends LoginPage {
	
	private DadosDoClientePage dadocliPage = new DadosDoClientePage();
	
	// ######## DADOS DO CLIENTE ########
		//@Test
		public void test6_inserirDadosCliente() throws InterruptedException{
			dadocliPage.setNome("rb-101-0");			
			dadocliPage.setEmail("rb-101-0");
			dadocliPage.setDataNasc("rb-101-0");
			dadocliPage.setNomeMae("rb-101-0");			
			dadocliPage.setCEP("rb-101-0");
			dadocliPage.buscarCEP();
			dadocliPage.proximoDadosClientes();
		}
}
