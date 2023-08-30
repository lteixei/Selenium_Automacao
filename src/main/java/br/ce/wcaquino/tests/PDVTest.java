package br.ce.wcaquino.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.pages.PDVPage;

public class PDVTest {
	private static LoginPage page = new LoginPage();
	private PDVPage pdvPage = new PDVPage();
	
	@BeforeClass
	public static void inicializa() throws InterruptedException{
		//Abrindo Site/App
		page.acessarTelaInicial();
		//Logando com Matricula e Senha
		page.setEmail("T3313299");
		page.setSenha("Tim@12345");
		page.entrar();
	}
	
	//##############################################################
	
	// ######## IDENTIFICAÇÃO DE PDV ########
	@Test
	public void test1_identificarPDV() throws InterruptedException{
		pdvPage.setPDV("MAGAZINELUIZA_SP_GUA"); 
		pdvPage.entrarPDV();
		pdvPage.entrarpopupPDV();
	}
	
}