package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;

public class EnderecoDoClientePage extends BasePage {
	
	public void setNumero(String numero) throws InterruptedException {
		Thread.sleep(25000);
		escrever("//input[@*]", numero);
		
	}

	public void proximoEnderecoClientes() {
		clicarBotao("btn-login");
		
	}

	
	
	//########################################################
		
}
