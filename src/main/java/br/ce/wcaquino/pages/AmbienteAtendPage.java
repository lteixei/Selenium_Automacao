package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class AmbienteAtendPage extends BasePage {
	
	public void clickAmbienteAtend() {
		clicarBotao("//span[contains(@class,'button-inner') and contains(text(),'MESA 03')]");
	}
	
	public void proximoAmbienteAtend(){
		clicarBotao("//span[contains(@class,'button-inner') and contains(text(),'Próximo')]");
	}
}
