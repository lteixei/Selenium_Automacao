package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class AtendimentoPage extends BasePage {
	
	public void setDDD() throws InterruptedException {
		// clicar no botão de seleção
		clicarRadio("rb-101-0");
	}
	
	public void clickOpcao() {
		clicarBotao("//button[id='rb-89-0']");
	}
	
	
	public void setDDD(String id) {
		clicarBotao("//button[id='select-90-0']");
	}
	
	
	public void proximoAtendimento() {
		clicarBotao("//span[contains(@class,'button-inner') and contains(text(),'Próximo')]");
	}
	
	//################################################################
	}
