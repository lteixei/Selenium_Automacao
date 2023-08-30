package br.ce.wcaquino.tests;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.pages.AtendimentoPage;
import br.ce.wcaquino.pages.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AtendimentoTest extends LoginPage {
	
	private AtendimentoPage atendePage = new AtendimentoPage();
	
	// ######## ATENDIMENTO ########
		//@Test
		public void test5_escolherAtendimento() throws InterruptedException{
			atendePage.setDDD("rb-101-0");
			atendePage.clickOpcao("rb-101-0");
			atendePage.proximoAtendimento();
		}
}
