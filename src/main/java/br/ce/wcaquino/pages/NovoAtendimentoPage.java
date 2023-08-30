package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;

public class NovoAtendimentoPage extends BasePage {
	
	public void setCPF(String cpf) throws InterruptedException {
		Thread.sleep(25000);
		escrever("//input[@*]", cpf);
	}
	
	public void setTelefone(String telefone) throws InterruptedException {
		escrever("//input[@*]", telefone);
	}
	
	public void proximoNovoAtendimento(){
		clicarBotao("btn-login");
	}

	
	//##############################################
	}

