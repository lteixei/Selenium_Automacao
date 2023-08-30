package br.ce.wcaquino.tests;

import br.ce.wcaquino.pages.AmbienteAtendPage;
import br.ce.wcaquino.pages.LoginPage;

public class AmbienteAtendTest extends LoginPage {
	private AmbienteAtendPage ambienteatendPage = new AmbienteAtendPage();
	
	// ######## AMBIENTE DE ATENDIMENTO ########
		//@Test
		public void test3_alterarAmbAtendimento() throws InterruptedException{
			ambienteatendPage.setAmbienteAtend("MESA 03");
			ambienteatendPage.proximoAmbienteAtend();
		}
}
