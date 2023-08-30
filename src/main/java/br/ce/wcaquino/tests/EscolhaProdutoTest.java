package br.ce.wcaquino.tests;

import br.ce.wcaquino.pages.EscolhaProdutoPage;
import br.ce.wcaquino.suites.SuiteGeral;

public class EscolhaProdutoTest extends SuiteGeral{
	
	private EscolhaProdutoPage escolherprodPage = new EscolhaProdutoPage();
	
	//######## ESCOLHA O PRODUTO ########
		//@Test
		public void test2_escolherProdutoTIMMovel() throws InterruptedException{
			escolherprodPage.escolherProduto();
		}
}