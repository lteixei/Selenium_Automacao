package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;

public class PDVPage extends BasePage {
	
	public void acessarTelaInicial(){
		DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/28_0_22_UAT1/#/login");
	}
	
	public void setEmail(String matricula) throws InterruptedException {
		escrever("//label[@id='login-input1']/input[1]", matricula);
	}
	
	public void setSenha(String senha) throws InterruptedException {
		escrever("//input[@name='password']", senha);
	}
	
	public void entrar(){
		clicarBotao("btn-login");
	}
	
	public void logar(String email, String senha) throws InterruptedException {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
	//########################################################
	
	// ######## IDENTIFICAÇÃO DE PDV ########
	public void setPDV(String pdv) throws InterruptedException {
		Thread.sleep(3000);
		escrever("[placeholder=\"PDV\"]", pdv);
	}
	
	public void entrarPDV(){
		clicarBotao("//span[contains(@class,'button-inner') and contains(text(),'Próximo')]");
	}
	
	public void entrarpopupPDV(){
		clicarBotao("//div[@class='alert-button-group']");
	}
}
