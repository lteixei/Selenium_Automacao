package br.ce.wcaquino.tests;

import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.pages.NovoAtendimentoPage;

public class NovoAtendimentoTest extends LoginPage {
	private NovoAtendimentoPage novoatendePage = new NovoAtendimentoPage();
	
	// ######## NOVO ATENDIMENTO ########
		//@Test
		public void test4_inserirNovoAtend() throws InterruptedException{
			novoatendePage.setCPF("62212545584");
			novoatendePage.setTelefone("13964276985");
			novoatendePage.proximoNovoAtendimento();
			//Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
		}
}
