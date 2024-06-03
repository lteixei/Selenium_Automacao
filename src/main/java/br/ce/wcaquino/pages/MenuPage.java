package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta(){// ACESSANDO O MENU CONTAS
		clicarLink("Contas");// ACESSANDO O MENU CONTAS
		clicarLink("Adicionar");// ACESSANDO O SUBMENU ADICIONAR (CONTAS)
	}
	
	public void acessarTelaListarConta(){
		clicarLink("Contas");// ACESSANDO O MENU CONTAS
		clicarLink("Listar");// ACESSANDO O SUBMENU LISTAR (CONTAS)
	}
	
	public void acessarTelaInserirMovimentacao(){
		clicarLink("Criar Movimentação");// ACESSANDO O MENU Criar Movimentação
		
	}
	
	public void acessarTelaResumo(){
		clicarLink("Resumo Mensal");// ACESSANDO O MENU Resumo Mensal
		
	}
	
	public void acessarTelaPrincipal(){
		clicarLink("Home");// ACESSANDO O MENU Resumo Mensal
		
	}

	public void setDataMovimentacao(String string) {
		// TODO Auto-generated method stub
		
	}

}
