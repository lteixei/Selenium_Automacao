package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void salvar(){
		clicarBotaoPorTexto("Salvar");
		//aqui usou o xpath referenciando o ID
	}
	
	public String obterMensagemSucesso(){
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
		//aqui usou o xpath referenciando a CLASS
	}
	
	public String obterMensagemErro(){
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
		//aqui usou o xpath referenciando a CLASS
	}

	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
			// aqui usou o xpath referenciando a CLASS
	}
	
	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
			// aqui usou o xpath referenciando a CLASS
	}
}
