package br.ce.wcaquino.tests;

import static br.ce.wcaquino.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//INICIANDO NA P�GINA CRIAR MOVIMENTA��O
public class MovinentacaoTest extends BaseTest{
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
	
	
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("1000");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
	
		Assert.assertEquals("Movimenta��o adicionada com sucesso!",  movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		//OBTER ERROS EM UMA LISTA
		
		Assert.assertTrue(erros.containsAll(Arrays.asList(//"ContainsALL" � pq vai pegar todos os erros(6) 
				"Data da Movimenta��o � obrigat�rio", "Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio", "Interessado � obrigat�rio",
				"Valor � obrigat�rio", "Valor deve ser um n�mero")));//Textos de erros
		Assert.assertEquals(6,  erros.size());//Apresenta os 6 erros
	}
	
	
	//@Test
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));//Aqui ele ensinou a colocar a data atual
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("1000");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		//OBTER ERROS EM UMA LISTA
		Assert.assertTrue(
				erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		//Texto do erro
		Assert.assertEquals(1,  erros.size());
		//Apresenta somente 1 erro
			
	}
	
}
