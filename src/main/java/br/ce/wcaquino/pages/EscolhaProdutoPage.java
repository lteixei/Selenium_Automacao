package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class EscolhaProdutoPage extends BasePage {
	
	public void escolherProduto(){
		clicarBotao("//span[contains(@class,'button-inner') and contains(text(),'TIM MÓVEL')]");
	}
}
