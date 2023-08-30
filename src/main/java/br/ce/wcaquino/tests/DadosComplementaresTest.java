package br.ce.wcaquino.tests;

import br.ce.wcaquino.pages.DadosComplementaresPage;
import br.ce.wcaquino.suites.SuiteGeral;

public class DadosComplementaresTest extends SuiteGeral {
	
	private DadosComplementaresPage dadoscomplemPage = new DadosComplementaresPage();
	
	// ######## DADOS COMPLEMENTARES ########
		//@Test
		public void test8_inserirDadosComplementares() throws InterruptedException{
			dadoscomplemPage.setSexo("rb-101-0");			
			dadoscomplemPage.setIdentidade("rb-101-0");
			dadoscomplemPage.setNumeroIdentidade("rb-101-0");
			dadoscomplemPage.setDataExpedicao("rb-101-0");			
			dadoscomplemPage.setOrgaoExp("rb-101-0");
			dadoscomplemPage.setUF("rb-101-0"); //COMBO
			dadoscomplemPage.setTelContato("rb-101-0");
			dadoscomplemPage.proximoDadosComplementares();
		}
}
