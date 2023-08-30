package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;

public class DadosComplementaresPage extends BasePage {
	
	public void setSexo(String sexo) throws InterruptedException {
		escrever("//input[@*]", sexo);
	}

	public void setIdentidade(String identidade) throws InterruptedException {
		escrever("//input[@*]", identidade);
	}

	public void setNumeroIdentidade(String numident) throws InterruptedException {
		escrever("//input[@*]", numident);
	}

	public void setDataExpedicao(String dtexp) throws InterruptedException {
		escrever("//input[@*]", dtexp);
	}

	public void setOrgaoExp(String orgexp) throws InterruptedException {
		escrever("//input[@*]", orgexp);
	}

	public void setUF(String string) {
		clicarBotao("btn-login");
		
	}

	public void setTelContato(String telcont) throws InterruptedException {
		Thread.sleep(25000);
		escrever("//input[@*]", telcont);
	}

	public void proximoDadosComplementares() {
		clicarBotao("btn-login");
		
	}

	
	//#####################################################
	
	}

