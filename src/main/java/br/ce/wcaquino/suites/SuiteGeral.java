package br.ce.wcaquino.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.tests.ContaTest;
import br.ce.wcaquino.tests.MovinentacaoTest;
import br.ce.wcaquino.tests.RemoverMovimentacaoContaTest;
import br.ce.wcaquino.tests.ResumoTest;
import br.ce.wcaquino.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovinentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/CT-01- Contatos/Drivers Navegador/chromedriver_win32/chromedriver.exe");
		
		page.acessarTelaInicial();
		
		page.setEmail("lteixei@hotmail.com");
		page.setSenha("123");
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
		//FECHAR O BROWSER NO FINAL DE TODOS OS TESTES
	}
}
