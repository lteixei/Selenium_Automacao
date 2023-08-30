package br.ce.wcaquino.tests;

import br.ce.wcaquino.pages.EcolhaOfertaPage;
import br.ce.wcaquino.pages.LoginPage;

public class EscolhaOfertaTest  extends LoginPage {
	
	AtendimentoTest ATendPage = new AtendimentoTest();
	private EcolhaOfertaPage escolhaofertaPage = new EcolhaOfertaPage();

	// ######## ESCOLHA A OFERTA ########
		//@Test
		public void test10_escolherOfertas() throws InterruptedException{
			escolhaofertaPage.clickOferta();			
			escolhaofertaPage.proximoOferta();
		}
}
