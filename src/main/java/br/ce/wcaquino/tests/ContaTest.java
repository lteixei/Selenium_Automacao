package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_InserirConta(){
		menuPage.acessarTelaInserirConta();// ACESSANDO O MENU
		
		contasPage.setNome("Conta do Teste");// INSERINDO UMA CONTA COM O NOME "Conta do Teste"
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
		// CONFIRMANDO A MENSAGEM DE QUE FOI ADICIONADO UMA CONTA COM SUCESSO
	}
	
	@Test
	public void test2_AlterarConta(){
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do Teste");// "CONTA DO TESTE" É O NOME DA CONTA CRIADA
		
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);// "CONTA DO TESTE ALTERADA" É O NOME ALTERADO DA CONTA
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
		// CONFIRMANDO A MENSAGEM DE ALTERAÇÃO DA CONTA COM SUCESSO 
	}
	
	@Test
	public void test3_InserirContaMesmoNome(){
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);// INSERINDO UMA NOVA CONTA COM UM NOME JÁ EXISTENTE
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
		// CONFIRMANDO A MENSAGEM DE DE QUE JÁ EXISTE UMA CONTA COM ESSE NOME
	}

	
}
