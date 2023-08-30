package br.ce.wcaquino.tests;

import br.ce.wcaquino.pages.EnderecoDoClientePage;
import br.ce.wcaquino.pages.LoginPage;

public class EnderecoDoClenteTest extends LoginPage {
	
	private EnderecoDoClientePage endcliPage = new EnderecoDoClientePage();

	// ######## ENDEREÇO DO CLIENTE ########
		//@Test
		public void test7_inserirEnderecoCliente() throws InterruptedException{
			endcliPage.setNumero("rb-101-0");
			endcliPage.proximoEnderecoClientes();
		}
}
