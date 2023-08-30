package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;

public class DadosDoClientePage extends BasePage {
	
	public void setNome(String nome) throws InterruptedException {
		Thread.sleep(25000);
		escrever("//ion-input[@id='client-fullname']", nome);
	}

	public void setEmail(String email) throws InterruptedException {
		escrever("//ion-input[@id='client-email']", email);
	}
	
	//CONFIRMAR EMAIL - ion-input[@id='client-email-confirmation']/input

	public void setDataNasc(String dtnascimento) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(25000);
		escrever("//input[@*]", dtnascimento);
	}

	public void setNomeMae(String nomemae) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(25000);
		escrever("//input[@*]", nomemae);
	}

	public void setCEP(String cep) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(25000);
		escrever("//input[@*]", cep);
	}

	public void buscarCEP() {
		// TODO Auto-generated method stub
		clicarBotao("btn-login");
	}

	public void proximoDadosClientes() {
		// TODO Auto-generated method stub
		clicarBotao("btn-login");
	}

	
	//########################################################
		
}
