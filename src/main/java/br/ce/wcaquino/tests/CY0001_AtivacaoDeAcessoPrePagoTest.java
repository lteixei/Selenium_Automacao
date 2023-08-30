package br.ce.wcaquino.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ce.wcaquino.pages.AmbienteAtendPage;
import br.ce.wcaquino.pages.AtendimentoPage;
import br.ce.wcaquino.pages.CY0001_AtivacaoDeAcessoPrePagoPage;
import br.ce.wcaquino.pages.DadosComplementaresPage;
import br.ce.wcaquino.pages.DadosDoClientePage;
import br.ce.wcaquino.pages.EcolhaOfertaPage;
import br.ce.wcaquino.pages.EnderecoDoClientePage;
import br.ce.wcaquino.pages.EscolhaProdutoPage;
import br.ce.wcaquino.pages.EscolhaSegmentoPage;
import br.ce.wcaquino.pages.InserirChipPage;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.pages.NovoAtendimentoPage;
import br.ce.wcaquino.pages.PDVPage;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CY0001_AtivacaoDeAcessoPrePagoTest {
	
	private CY0001_AtivacaoDeAcessoPrePagoPage ativaprepagoPage = new CY0001_AtivacaoDeAcessoPrePagoPage();
	private PDVPage pdvPage = new PDVPage();
	private AmbienteAtendPage ambienteatendPage = new AmbienteAtendPage();
	private NovoAtendimentoPage novoatendePage = new NovoAtendimentoPage();
	private AtendimentoPage atendePage = new AtendimentoPage();
	private EscolhaProdutoPage escolherprodPage = new EscolhaProdutoPage();
	private DadosDoClientePage dadocliPage = new DadosDoClientePage();
	private EnderecoDoClientePage endcliPage = new EnderecoDoClientePage();
	private DadosComplementaresPage dadoscomplemPage = new DadosComplementaresPage();
	private EscolhaSegmentoPage escolhasegPage = new EscolhaSegmentoPage();
	private EcolhaOfertaPage escolhaofertaPage = new EcolhaOfertaPage();
	private InserirChipPage inserirCodBarra = new InserirChipPage();
	private static LoginPage page = new LoginPage();
	
	
	// ######## LOGAR NO SISTEMA ########
	@BeforeClass
	public static void inicializa() throws InterruptedException{
		//Abrindo Site/App
		page.acessarTelaInicial();
		//Logando com Matricula e Senha
		page.setEmail("T3313299");
		page.setSenha("Tim@12345");
		page.entrar();
	}
	
	
	// ######## IDENTIFICAÇÃO DE PDV ########
	@Test
	public void test1_identificarPDV() throws InterruptedException{
		ativaprepagoPage.setPDV("MAGAZINELUIZA_SP_GUA"); 
		ativaprepagoPage.entrarPDV();
		ativaprepagoPage.entrarpopupPDV();
	}
	
	
	// ######## ESCOLHA O PRODUTO ########
	//@Test
	public void test2_escolherProdutoTIMMovel() throws InterruptedException{
		escolherprodPage.escolherProduto();
	}
	
	
	// ######## AMBIENTE DE ATENDIMENTO ########
	//@Test
	public void test3_alterarAmbAtendimento() throws InterruptedException{
		ambienteatendPage.clickAmbienteAtend();
		ambienteatendPage.proximoAmbienteAtend();
	}
	
	
	// ######## NOVO ATENDIMENTO ########
	//@Test
	public void test4_inserirNovoAtend() throws InterruptedException{
		novoatendePage.setCPF("62212545584");
		novoatendePage.setTelefone("13964276985");
		novoatendePage.proximoNovoAtendimento();
	}
	
	
	// ######## ATENDIMENTO ########
	//@Test
	public void test5_escolherAtendimento() throws InterruptedException{
		atendePage.clickOpcao();
		atendePage.setDDD();
		atendePage.proximoAtendimento();
	}
	
	
	// ######## DADOS DO CLIENTE ########
	//@Test
	public void test6_inserirDadosCliente() throws InterruptedException{
		dadocliPage.setNome("teste");			
		dadocliPage.setEmail("teste@teste.com");
		dadocliPage.setDataNasc("12102000");
		dadocliPage.setNomeMae("maeteste");			
		dadocliPage.setCEP("rb-101-0");
		dadocliPage.buscarCEP();
		dadocliPage.proximoDadosClientes();
	}
	
	
	// ######## ENDEREÇO DO CLIENTE ########
	//@Test
	public void test7_inserirEnderecoCliente() throws InterruptedException{
		endcliPage.setNumero("rb-101-0");
		endcliPage.proximoEnderecoClientes();
	}
	
	
	// ######## DADOS COMPLEMENTARES ########
	//@Test
	public void test8_inserirDadosComplementares() throws InterruptedException{
		dadoscomplemPage.setSexo("rb-101-0");			
		dadoscomplemPage.setIdentidade("rb-101-0");
		dadoscomplemPage.setNumeroIdentidade("rb-101-0");
		dadoscomplemPage.setDataExpedicao("rb-101-0");			
		dadoscomplemPage.setOrgaoExp("rb-101-0");
		dadoscomplemPage.setUF("rb-101-0"); //COMBO
		dadoscomplemPage.setTelContato("rb-101-0");
		dadoscomplemPage.proximoDadosComplementares();
	}
	
	
	// ######## ESCOLHA O SEGMENTO ########
	//@Test
	public void test9_escolherSegmento_Plano() throws InterruptedException{
		escolhasegPage.clickPrepago();			
		escolhasegPage.clickControleExpress();
		escolhasegPage.clickControleFatura();
		escolhasegPage.clickControleFlex();			
		escolhasegPage.clickPosPagoFtura();
		escolhasegPage.clickPosPagoExpress();
		escolhasegPage.clickTimBlackMultiFatura();
		escolhasegPage.clickTimBlackMultiExpress();
	}
	
	
	// ######## ESCOLHA A OFERTA ########
	//@Test
	public void test10_escolherOfertas() throws InterruptedException{
		escolhaofertaPage.clickOferta();			
		escolhaofertaPage.proximoOferta();
	}
	
	
	// ######## INSERIR CHIP ########
	public void test8_inserirCodBarras() throws InterruptedException{
		inserirCodBarra.setCHIP("rb-101-0");			
		inserirCodBarra.proximoInserirCHIP();
	}	
}
