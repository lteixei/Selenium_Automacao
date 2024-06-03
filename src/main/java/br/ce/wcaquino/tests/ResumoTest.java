package br.ce.wcaquino.tests;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebElement;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

//import java.util.List;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();

	@Test
	public void test1_ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
	
		resumoPage.excluirMovimentacao();
	
		Assert.assertEquals("Movimentação removida com sucesso!",
				resumoPage.obterMensagemSucesso());
	}
	
	
	//AQUI EU VOU NA PÁGINA "RESUMO MENSAL" E ME CERTIFICAR QUE ELA ESTÁ VAZIA
	@Test
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumo();
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
				
		try{
			DriverFactory.getDriver().findElement(By.xpath("//*[='tabelaExtrato']/tbody/tr"));
			Assert.fail();
		}catch (NoSuchElementException e) {
			
		}	
	}	
}		
			
	// EXISTEM TAMBÉM DUAS OPÇÕES DE FAZER, COMO MOSTRO ABAIXO
	
/*##### PRIMEIRA OPÇÃO #####*/

	//@Test
	//public void test2_ResumoMensal() {
		//menuPage.acessarTelaResumo();
		
		//Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		//List<WebElement> elementosEncontrados = 
				//DriverFactory.getDriver().findElements(By.xpath("//*[='tabelaExtrato']/tbody/tr"));
		//Assert.assertEquals(0,  elementosEncontrados.size());
	//}
	
/*##### FIM #####*/	
	


	
/*##### SEGUNDA OPÇÃO #####*/
	
	//@Test(expected=NoSuchElementexception.class)
		//public void test2_ResumoMensal() {
			//menuPage.acessarTelaResumo();
			
			//Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
			//DriverFactory.getDriver().findElement(By.xpath("//*[='tabelaExtrato']/tbody/tr"));

/*##### FIM #####*/
