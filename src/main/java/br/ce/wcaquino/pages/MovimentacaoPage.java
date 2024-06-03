package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		escrever("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	//####### INICIO COMBO #######
	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	//####### FIM COMBO #######
	
	//####### INICIO RADIO #######
	public void setStatusPago() {
		clicarRadio("status_pago");
	}
	//####### FIM RADIO #######
	
		
	//####### CLICAR NO BOTAO #######	
	public void salvar() {
		clicarBotaoPorTexto("Salvar"); //AQUI SEMPRE É O NOME DO BOTÃO (EXATAMENTE COMO ESTÁ NO SITE
	}
		
		
	//####### VERIFICAR MENSAGEM #######
		
	public String obterMensagemSucesso(){
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
		//aqui usou o xpath referenciando a CLASS
	}
	
	
	public List<String> obterErros(){
				
		List<WebElement>erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		//AQUI NO XPATH EU VOU PEGAR TODAS OS "LI"
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
}
