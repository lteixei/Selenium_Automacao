package core;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
/********* TextField e TextArea 
 * @throws InterruptedException ************/

	public void escrever(String name_campo, String texto) throws InterruptedException{
		Thread.sleep(5000);
		getDriver().switchTo().frame("iframe");
		getDriver().findElement(By.xpath(name_campo)).clear();
		getDriver().findElement(By.xpath(name_campo)).sendKeys(texto);
		getDriver().switchTo().defaultContent();
	}
	
	public void escreverComDoisIframes(String name_campo, String texto) throws InterruptedException{
		Thread.sleep(5000);
		getDriver().switchTo().frame(0);
		getDriver().switchTo().frame("iframe");
		getDriver().findElement(By.xpath(name_campo)).clear();
		getDriver().findElement(By.xpath(name_campo)).sendKeys(texto);
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().defaultContent();
	}
	
	//######## ESCREVER FORA DA FRAME
	public void escreverSemTroca(String name_campo, String texto) throws InterruptedException{
		getDriver().findElement(By.xpath(name_campo)).clear();
		getDriver().findElement(By.xpath(name_campo)).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	
	/********* Botao ************/
	
	public void clicarBotao(String id) {
		getDriver().switchTo().frame("iframe");
		getDriver().findElement(By.id(id)).click();
		getDriver().switchTo().defaultContent();
	}
	
	public void clicarBotaoIframe(String xpath) {
		getDriver().switchTo().frame(0);
		getDriver().switchTo().frame("iframe");
		getDriver().findElement(By.xpath(xpath)).click();
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().defaultContent();
	}
	
	public void clicarBotaoSemTroca(String id) throws InterruptedException {
		Thread.sleep(8000);
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clicarXpath(String element) throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath(element)).click();
	}	
	
	public void clicarCSS(String css) throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.cssSelector(css)).click();
	}
		
	/********* UPLOAD DE ARQUIV0 ************/
	
	//public void Upload() {
	//UPLOAD ARQUIVO
	//String filePath = "C:\\Users\\T3666975\\Id_Frente.PNG";
	//getDriver().findElement(By.xpath("//input[@type='file']")).setAttribute("value", "your value");
	//getDriver().findElement(By.xpath("//input[@value='Press']")).click();
	//}
	
	
	/********* Assert - Validar um Texto ************/
	
	public void Test_assert_equals() throws InterruptedException
    {
        String curr_window_title = getDriver().getTitle();
        /* Hard Assert */
        Assert.assertEquals(curr_window_title, curr_window_title);
        System.out.println("Elemento achado corretmente");
    }
	
	public void validarTexto() throws InterruptedException
    {
	    Assert.assertEquals("texto esperado", getDriver().findElement(By.xpath("//")));  
    }
	
	public String obterTextoXpath(String xpath) {
        return obterTexto(By.xpath(xpath));
    }
	
	public String obterTextoMSISDNXpath(String xpath) {
        return obterTexto(By.xpath(xpath));
    }
	
	/********* CONDIÇÃO SE USANDO - ASSERT ************/
	
	
	
	/********* Radio e Check ************/
	
	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}
	
	public boolean isRadioMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
	}
	
	/********* Link ************/
	
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	public String alertaObterTextoENega(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void sairFrame(){
		getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
	/************** JS *********************/
	
	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}
	
	/************** Tabela *********************/
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
	}
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
	
    public void encerra() throws InterruptedException {
        Thread.sleep(20000);
	    getDriver().quit();
	    	    
    }
}
