package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class InserirChipPage extends BasePage {

	//public void inserindochip() {
		//String meuchip = gerarChip();
	//}
	
	public void setCHIP(String chip) throws InterruptedException {
		escrever("//input[@*]", chip);
	}

	public void proximoInserirCHIP() {
		clicarBotao("btn-login");
	}
}
