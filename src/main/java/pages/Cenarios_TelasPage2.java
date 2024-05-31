package pages;

import static core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;
import core.DriverFactory;

public class Cenarios_TelasPage2 extends BasePage {

    // ############################################################# //
    // ##################### ENDEREÇO E LOGIN ###################### //
    // ############################################################# //

    public void acessarTelaInicial() {
        DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/30_0_31_UAT1/#/login");
    }

    public void setEmail(String matricula) throws InterruptedException {
        escrever("//label[@id='login-input1']/input[1]", matricula);
    }

    public void setSenha(String senha) throws InterruptedException {
        escrever("//input[@name='password']", senha);
    }

    public void entrar() {
        clicarBotao("btn-login");
    }

    public void logar(String email, String senha) throws InterruptedException {
        setEmail(email);
        setSenha(senha);
        entrar();
    }

    // #################################################################################
    // //
    // ##################### LOGIN - ETAPAS - PASSOS NO SIEBEL POS
    // ###################### //
    // ##################################################################################
    // //

    public void usuario_entrar(String usuario) throws InterruptedException {
        Thread.sleep(2000);
        escreverSemTroca("/html/body/div/div[2]/div/form/div[3]/input", usuario);
    }

    public void senha_entrar(String senha1) throws InterruptedException {
        escreverSemTroca("/html/body/div/div[2]/div/form/div[5]/input", senha1);
    }

    public void botao_entrar() throws InterruptedException {
        clicarXpath("//*[@id=\"signOnButton\"]");
    }

    // ##########################33

    public void clica_Pesquisar_Cliente() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//a[contains(text(),'Pesquisa Cliente')]");
    }

    public void clica_PF_PJ() throws InterruptedException {
        clicarXpath("//input[@name='s_1_1_1_0']");
    }

    public void send_CPF(String cpf) throws InterruptedException {
        escreverSemTroca("//input[@name='s_1_1_0_0']", cpf);
    }

    public void botao_Pesquisar() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath(
                "/html/body/div[1]/div/div[6]/div/div[8]/div/div[1]/div/div/div[1]/div/div/form/div/div/span[2]/div[3]/div/div/table/tbody/tr[7]/td[4]/div/button");
    }

    // ##########################33

    public void botao_Seta_Baixo() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//select[@id='j_s_sctrl_tabScreen']");
    }

    public void clicar_Alcada() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//select[@id='j_s_sctrl_tabScreen']/option[@value='tabScreen24']");
    }

    public void clica_Minhas_Solic_Alcada() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//select[@title='Visibilidade']");
    }

    public void clica_Todas_Solic_Alcada() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//option[@rn='TIM Aprovar Alcada All View']");
    }

    public void clica_Menu_Pesquisar() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//span[text()='Pesquisar']");
    }

    public void clica_Campo_Protocolo() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("/html/body/div[1]/div/div[6]/div/div[8]/div/div[1]/div/div[1]/div/form/span/div/div[3]/div/div/div[3]/div[3]/div/div[2]/table/tbody/tr[2]/td[5]");
    }

    public void send_Protocolo(String protocolo) throws InterruptedException {
        Thread.sleep(5000);
        escreverSemTroca(
                "//input[@id='1_TIM_Protocolo']",
                protocolo);
    }

    public void clica_Menu_IR() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//button[@id='s_2_1_9_0_Ctrl']");
    
    }
    
 // Método para realizar o processo de verificação de existência do resultado do protocolo
    public void verifica_Carregamento_Alcada(String protocolo) throws InterruptedException {
        boolean resultadoProtocolo = false;
        long startTime = System.currentTimeMillis();
        long tempoLimite = 5 * 60 * 1000; // 5 minutos em milissegundos
 
        while (System.currentTimeMillis() - startTime < tempoLimite) {
            clica_Menu_Pesquisar();
            clica_Campo_Protocolo();
            send_Protocolo(protocolo);
            clica_Menu_IR();
            Thread.sleep(3000);
 
            // Verifica se o elemento Resultado_Protocolo está presente
            if (getDriver().findElements(By.xpath("//a[@class='drilldown' and @name='TIM Order Number']")).size() > 0) {
                resultadoProtocolo = true;
                // Se o elemento estiver presente, sair do loop
                System.out.println("Elemento encontrado. Continuando o código.");
                break;
            } else {
                // Se o elemento não estiver presente, esperar 30 segundos e tentar novamente
                System.out.println("Elemento não encontrado. Tentando novamente em 30 segundos.");
                TimeUnit.SECONDS.sleep(30); // 30 segundos
            }
        }
 
        if (!resultadoProtocolo) {
            System.out.println("Tempo limite de 5 minutos atingido ou elemento não encontrado. Encerrando o processo.");
        }
    }


    
      
    public void clica_Botao_Check() throws InterruptedException {
        Thread.sleep(3000);
        clicarXpath(
                "/html/body/div[1]/div/div[6]/div/div[8]/div/div[1]/div/div[1]/div/form/span/div/div[3]/div/div/div[3]/div[3]/div/div[2]/table/tbody/tr[2]/td[2]");
    }

    public void clica_Botao_Check2() throws InterruptedException {
        Thread.sleep(3000);
        clicarXpath(
                "//input[@class='customelement siebui-ctrl-checkbox siebui-align-center siebui-input-align-center s_2_2_29_0']");
    }
    
    
    
    
    
    public void clica_Atribuir_Manual() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//span[text()='Atribuir Manual']");
    }
    
    
    public void clica_Botao_Pesquisar() throws InterruptedException {
        Thread.sleep(3000);
        clicarXpath("/html/body/div[16]/div[2]/div/div/div/form/div/table/tbody/tr/td[1]/span[2]/button/span");
    }
    
    
    public void clica_Oteri() throws InterruptedException {
        Thread.sleep(3000);
        clicarXpath("//td[text()='Oteri']");
    }
    
    
    public void clica_Botao_Ok_Oteri() throws InterruptedException {
        Thread.sleep(3000);
        clicarXpath("//button[@id='s_3_1_54_0_Ctrl']");
    }
    
    
    public void clica_Aprovação_Alçada() throws InterruptedException {
        Thread.sleep(3000);
        clicarXpath("/html/body/div[1]/div/div[6]/div/div[8]/div/div[1]/div/div[2]/div/form/div/span/div[3]/div/div/table/tbody/tr[7]/td[5]/div/span");
        Thread.sleep(2000);
        clicarXpath("/html/body/div[1]/div/div[6]/div/div[8]/ul[3]/li[3]/div");
    }
    
 
    public void clica_Finalizar() throws InterruptedException {
        clicarXpath("//button[contains(@class, 'siebui-icon-timfinalizar') and contains(@title, 'Finalizar')]");
    }
    
    //#### RETORNANDO PARA A ABA DO APP TIM Vendas ####
    
    public void clica_Menu() throws InterruptedException {
        
        for (String handle : getDriver().getWindowHandles()) {
            // Troca para a primeira alça de janela
            getDriver().switchTo().window(handle);
            break; // Sai do loop após voltar para a primeira aba
        }
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);// 15000 milissegundos = 15 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='bar-buttons bar-buttons-md bar-button bar-button-md bar-button-default bar-button-default-md bar-button-menutoggle bar-button-menutoggle-md'][@ion-button][@menutoggle][@ng-reflect-menu-toggle]")));
        elemento.click();
        }
    
    //#### CONTINUANDO DENTRO DO APP
    public void clica_Acompanhar_Alcada() throws InterruptedException {
        Thread.sleep(3000);
        clicarXpath("/html/body/ion-app/ng-component/ion-menu/div/ion-content/div[2]/ion-item[10]/div[1]/div/ion-label/ion-row/ion-col[2]");
    }
    
    public void clica_Botao_SIM() throws InterruptedException {
        Thread.sleep(3000);
        clicarXpath("/html/body/ion-app/ion-alert/div/div[3]/button[2]");
    }
    
    public void clica_Botao_X() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath("//button[@class='button button-md button-clear button-clear-md'][@clear][@ion-button][@no-margin][@ng-reflect-clear]");
        Thread.sleep(12000);
    }
    
    public void send_CPF_Fim(String cpf_fim) throws InterruptedException {
        Thread.sleep(3000);
        escreverSemTroca("//input[@placeholder='CPF ou CNPJ do cliente']", cpf_fim);
    }
    
    public void send_CPF_Alcada_Fim(String cpf_fim) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);// 10 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='text-input text-input-md' and @type='tel' and @placeholder='CPF ou CNPJ do cliente']")));
        elemento.sendKeys(cpf_fim);
        Thread.sleep(12000);
    }
    
    public void clica_LUPA() throws InterruptedException {
        Thread.sleep(2000);
        clicarCSS(".item-button > .button-inner");
        
    }
    
    public void clica_SETA() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);// 15000 milissegundos = 15 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button//ion-icon[@name='arrow-forward'])[1]")));
        elemento.click();
        
    }
       


    // ########################################################
    // ######## ASSERT - VALIDAR NOME ########
    // ########################################################

    public void validarTexto() throws InterruptedException {
        Assert.assertEquals("NOVO ATENDIMENTO", getDriver()
                .findElement(By.xpath("/html/body/ion-app/ng-component/ion-header/ion-navbar/div[2]/ion-title/div")));
        System.out.println("NOVO ATENDIMENTO");
    }

    // ########################################################
    // ######## IDENTIFICAÇÃO DE PDV ########
    // ########################################################

    public void sendPDV(String pdv) throws InterruptedException {
        Thread.sleep(20000);
        escreverSemTroca("//ion-searchbar[@id='searchbar-pdv']/div/input", pdv);
        Thread.sleep(2000);
    }
    
    public void sendPDV_Alcada(String pdv) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);// 10 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ion-searchbar[@id='searchbar-pdv']/div/input")));
        elemento.sendKeys("E A DUTRA");
        //Thread.sleep(2000);
    }

    public void EscolhaPDVDutra() throws InterruptedException {
        Thread.sleep(1000);
        clicarXpath("//ion-label[contains(.,'E A DUTRA')]");
    }
    
    public void EscolhaPDVDutra_Alcada() throws InterruptedException {
        //Thread.sleep(1000);
        clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-pdv-identification/ion-content/div[2]/ion-card/ion-card-content/ion-list/ion-item/div[1]/div");
    }
    
    public void EscolhaPDVVarejo() throws InterruptedException {
        Thread.sleep(1000);
        clicarXpath("//ion-label[contains(.,'VAREJO_LASA_L229')]");
    }

    public void EscolhaPDVMagazineluiza() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath("//ion-label[contains(.,'MAGAZINELUIZA_SP_GUA')]");
    }

    public void EscolhaPDVMorumbi() throws InterruptedException {
        // Thread.sleep(2000);
        clicarXpath("//ion-label[contains(.,'LP LOJA MORUMBI SHOP')]");
    }

    public void EscolhaPDVTIM_REVENDAS() throws InterruptedException {
        clicarXpath("//ion-label[contains(.,'TIM REVENDAS')]");
    }

    public void confirmaPDV() throws InterruptedException {
        clicarXpath("//button[@id='button-back']/span");
        }

    public void fechapopupPDV() throws InterruptedException {
        clicarXpath("//*[contains(@class,'alert-button-group')]");
        }

    // ########################################################
    // ######## SELEÇÃO VENDEDOR ########
    // ########################################################

    public void send_Vendedor(String vendedor) throws InterruptedException {
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-seller-selection/ion-content/div[2]/ion-card/ion-card-content/ion-list/ion-item[1]/div[1]/div/ion-input/input",
                vendedor);
    }

    public void clicaBotao_Buscar() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-seller-selection/ion-content/div[2]/ion-card/ion-card-content/ion-list/ion-item[1]/div[1]/button/span");
        Thread.sleep(2000);
    }

    public void clicarBotaoProximo() throws InterruptedException {
        clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-seller-selection/ion-content/div[2]/button/span");
        Thread.sleep(2000);
    }

    public void clicar_Popup_Nao() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath("/html/body/ion-app/ion-alert/div/div[3]/button[1]");
    }

    public void sendCep(String cep) throws InterruptedException {
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-installation-address/ion-content/div[2]/ion-card/ion-card-content/ion-list/field-zipcode/ion-item[1]/div[1]/div/ion-input/input",
                cep);
    }

    public void sendNumero(String num) throws InterruptedException {
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-installation-address/ion-content/div[2]/ion-card/ion-card-content/ion-list/field-zipcode/ion-item[2]/div[1]/div[1]/ion-input/input",
                num);
    }

    public void clica_Buscar() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-installation-address/ion-content/div[2]/ion-card/ion-card-content/ion-list/field-zipcode/ion-item[1]/div[1]/button");
    }

    public void clicaBotao_Atencao() throws InterruptedException {
        clicarXpath("/html/body/ion-app/ion-alert/div/div[3]/button");
    }

    // ########################################################
    // ######## AMBIENTE DE ATENDIMENTO ########
    // ########################################################

    public void clickAntesAtendimento() throws InterruptedException {
        clicarXpath("//ion-select/button/span");
    }

    public void clickAtendimento() throws InterruptedException {
        clicarXpath("//span[contains(.,'MESA 03')]");
    }

    public void proximoAmbienteAtend() throws InterruptedException {
        clicarXpath("//div[2]/button/span");
        //Thread.sleep(5000);
    }

    // ########################################################
    // ######## ATENDIMENTO ########
    // ########################################################

    public void gerarNovoProtocolo() throws InterruptedException {
        //Thread.sleep(10000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-attendance/ion-content/div[2]/ion-card[4]/ion-card-content/ion-list/ion-item[1]/div[1]/div");
    }

    public void insertNovoTel(String newtel) throws InterruptedException {
        //Thread.sleep(10000);
        escreverSemTroca("//input[@type='tel']", newtel);
    }

    public void clickOpcaoDemorada() throws InterruptedException {
        clicarXpath("//ion-radio/button/span");
    }

    public void clickOpcao() throws InterruptedException {
        clicarXpath("//ion-radio/button/span");
    }

    public void clickCampoDDD() throws InterruptedException {
        clicarXpath("//ion-select/button/span");
    }

    public void clickDDD15() throws InterruptedException {
        Thread.sleep(1000);
        clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[5]");
    }

    public void clickDDD21() throws InterruptedException {
        clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[1]");
    }

    public void clickDDD11() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[1]");
    }

    public void clickDDD12() throws InterruptedException {
        //Thread.sleep(2000);
        clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[2]");
    }

    public void proximoAtendimento() throws InterruptedException {
        clicarXpath("//button[@id='button-next']/span");
        Thread.sleep(3000);
    }

    public void proximoAtendimento1() throws InterruptedException {
        clicarXpath("//button[@id='button-next']/span");
        //Thread.sleep(15000);
    }

    public void proximoAtendimento2() throws InterruptedException {
        clicarXpath("//button[@id='button-next']/span");
    }

    // ########################################################
    // ######## ATENDIMENTO DEPENDENTE ########
    // ########################################################

    public void setNome_Dep() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-depedent-service/ion-content/div[2]/ion-card/ion-card-content/ion-card/ion-card-content/ion-item/div[1]/div/ion-label");
        Thread.sleep(5000);
    }

    public void clickAtivacao() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-depedent-service/ion-content/div[2]/ion-card/ion-card-content/activation-card/ion-card/ion-card-content/ion-list/ion-item/div[1]/ion-radio/button/span");
        Thread.sleep(5000);
    }

    public void proximoDep() throws InterruptedException {
        clicarXpath("//*[@id=\"button-next\"]/span");
        Thread.sleep(5000);
    }

    // ########################################################
    // ######## NOVO PRTOCOLO ########
    // ########################################################

    public void inserirTelefone(String insertnewtel) throws InterruptedException {
        Thread.sleep(10000);
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-consult-client/ion-content/div[2]/ion-card/ion-card-content/ion-row/ion-col[1]/ion-input",
                insertnewtel);
    }

    public void btnPesquisar() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-consult-client/ion-content/div[2]/ion-card/ion-card-content/ion-row/ion-col[2]/button/span");
    }

    public void cadastrarNovoCiente() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-consult-client/ion-content/div[2]/ion-card[2]/ion-card-content/ion-row[2]/ion-col/button");
    }

    public void inserirNome(String insertnewname) throws InterruptedException {
        Thread.sleep(10000);
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-potential-client-pf/ion-content/div[2]/ion-card/ion-card-content/ion-list/ion-item[1]/div[1]/div/ion-input",
                insertnewname);
    }

    public void clicarOperadora() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("//*[@id=\"select-164-0\"]/span");
    }

    public void escolherOperadora() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[1]");
    }

    // ########################################################
    // ######## NO PÓS VENDA ########
    // ########################################################

    public void clickMigracao() throws InterruptedException {
        clicarXpath("//span[contains(.,'Migração')]");
        Thread.sleep(5000);
    }

    public void clickMigracaoTT() throws InterruptedException {
        clicarXpath("//span[contains(.,'Migração com TT')]");
        Thread.sleep(10000);
    }

    public void clickTrocaChip() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//span[contains(.,'Troca de Chip')]");
    }

    public void clickTrocaPlano() throws InterruptedException {
        clicarXpath("//span[contains(.,'Troca de Plano')]");
        Thread.sleep(12000);
    }

    public void clickFinalizar() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//span[contains(.,'Finalizar Atendimento')]");
        Thread.sleep(5000);
    }

    public void clickNovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Novo Protocolo')]");
        Thread.sleep(10000);
    }

    public void clickConsultarProtocolos() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//ion-label[contains(.,'Consultar Protocolos')]");
    }

    // ########################################################
    // ######## DADOS COMPLEMENTAARES ########
    // ########################################################

    public void clickSexoFeminino() throws InterruptedException {
        Thread.sleep(1000);
        clicarXpath("//ion-col[2]/ion-item/div/ion-radio/button/span");
    }

    public void clickSexoMasculino() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//ion-col[1]/ion-item/div/ion-radio/button/span");
    }

    public void ckickAntesEscolherDoc() throws InterruptedException {
        clicarXpath("//ion-select/button/span");
    }

    public void ckicEscolherDocID() throws InterruptedException {
        clicarXpath("//div/div/button[2]/span");
    }

    public void setNumeroIdentidade(String numId) throws InterruptedException {
        // escreverSemTroca("//input[@type='tel']", numId);
        escreverSemTroca("(//input[@type='tel'])[2]", numId);
        Thread.sleep(2000);
    }

    // #########CONTEUDO NOVO###############

    public void setDataExp(String dtExp) throws InterruptedException {
        escreverSemTroca("(//input[@type='tel'])[3]", dtExp);
    }

    public void setOrgEm(String orgemiss) throws InterruptedException {
        escreverSemTroca("//ion-item[4]/div/div/ion-input/input", orgemiss);
    }

    public void setTelContacto(String telcont) throws InterruptedException {
        escreverSemTroca("(//input[@type='tel'])[4]", telcont);
    }

    public void setCepEnd(String setcep) throws InterruptedException {
        escreverSemTroca("(//input[@type='tel'])[5]", setcep);
    }
    // #########FIM - CONTEUDO NOVO###############

    public void setNumeroIdentidade1(String numId) throws InterruptedException {
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-client-data/ion-content/div[2]/client-data-inputs/ion-card[1]/ion-card-content/ion-list[2]/ion-item[2]/div[1]/div/ion-input",
                numId);

    }

    public void setNumeroDocumento(String numId) throws InterruptedException {
        Thread.sleep(500);
        escreverSemTroca("//ion-input[@id='doc-number']/input", numId);
    }

    public void setDataEmissão(String dtemissao) throws InterruptedException {
        Thread.sleep(500);
        escreverSemTroca("//ion-input[@id='date']/input", dtemissao);
    }

    public void setOrgaoEmissor(String orgemissor) throws InterruptedException {
        Thread.sleep(500);
        escreverSemTroca("(//input[@type='text'])[2]", orgemissor);
    }

    public void setOrgaoEmissorSSP(String orgemissor) throws InterruptedException {
        Thread.sleep(500);
        escreverSemTroca("//*[@id=\"issuing-organ\"]/input", orgemissor);
    }

    public void clickAntesUF() throws InterruptedException {
        Thread.sleep(500);
        clicarXpath("//ion-item[5]/div/div/ion-select/button/span");
    }

    public void clickUF() throws InterruptedException {
        Thread.sleep(1000);
        clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[26]/span");
    }

    public void clickUF_RJ() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath("//button[19]/span");
    }

    public void setTelContato(String telcont) throws InterruptedException {
        Thread.sleep(1000);
        escreverSemTroca("(//input[@type='tel'])[3]", telcont);
    }

    public void setTelContato2(String telcont) throws InterruptedException {
        Thread.sleep(2000);
        escreverSemTroca("//ion-input[@id='tel-contact']/input", telcont);

    }

    public void AntesproximoDadosComplementares() throws InterruptedException {
        clicarXpath("//button[contains(.,'OK')]");
        Thread.sleep(5000);
    }

    public void proximoDadosComplementares() throws InterruptedException {
        clicarXpath("//div[2]/button[2]");
        Thread.sleep(15000);
    }

    public void proximoDadosCompDemorado() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//div[2]/button[2]");
    }

    public void proximoposvenda() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-after-sales/ion-content/div[2]/button[3]/span");
    }

    // ########################################################
    // ######## DADOS DO CLIENTE ########
    // ########################################################

    public void setNome(String nome) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);// 10 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        elemento.sendKeys("Teste");
    }

    public void setEmailCliente(String email) throws InterruptedException {
        Thread.sleep(1000);
        // escreverSemTroca("/html/body/ion-app/ng-component/ion-nav/page-client-data/ion-content/div[2]/ion-card[1]/ion-card-content/ion-list/ion-item[2]/div[1]/div/ion-input/input",
        // email);
        escreverSemTroca("//input[@type='email']", email);
        /// html/body/ion-app/ng-component/ion-nav/page-client-data/ion-content/div[2]/ion-card[1]/ion-card-content/ion-list/ion-item[2]/div[1]/div/ion-input
    }

    public void confirmaEmail(String confemail) throws InterruptedException {
        escreverSemTroca("(//input[@type='email'])[2]", confemail);
    }

    public void validaEmail() throws InterruptedException {
        clicarXpath("//span[contains(.,'Validar')]");
    }

    public void checkNotEmail() throws InterruptedException {
        clicarXpath("//ion-checkbox/button/span");
    }

    public void setDataNasc(String dtnascimento) throws InterruptedException {
        escreverSemTroca("//ion-input[@id='client-birthdate']/input", dtnascimento);
    }

    // ESSE AQUI FUNCIONA
    public void setData_Alteracao_Cadastro(String dataalteracao) throws InterruptedException {
        // ##### INDICA O CAMPO ONDE SERÁ APAGADO A INFORMAÇÃO
        WebElement elemento = getDriver().findElement(By.xpath(
                "/html/body/ion-app/ng-component/ion-nav/page-change-registration/ion-content/div[2]/ion-card[1]/ion-card-content/ion-list[2]/ion-item[3]/div[1]/div/ion-input/input"));

        // Seleciona texto do começo do campo até o fim, segurando SHIFT e depois,
        // aplica o Backspace
        elemento.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.BACK_SPACE);

        // Seleciona todo o texto dando o comando "CONTROL + A" e depois, aplica o
        // Backspace
        elemento.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);

        // Apaga qualquer texto no componente
        elemento.clear();

        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-change-registration/ion-content/div[2]/ion-card[1]/ion-card-content/ion-list[2]/ion-item[3]/div[1]/div/ion-input/input",
                dataalteracao);
    }

    public void setNomeMae(String nomemae) throws InterruptedException {
        Thread.sleep(1000);
        escreverSemTroca("(//input[@type='text'])[2]", nomemae);
    }

    public void setCEP(String cep) throws InterruptedException {
        escreverSemTroca("(//input[@type='tel'])[2]", cep);
    }

    // ##### APAGA O CONTEÚDO - LIMPA A CÉLULA
    public void setCEPTroca(String cep) throws InterruptedException {
        Thread.sleep(5000);
        // ##### INDICA O CAMPO ONDE SERÁ APAGADO A INFORMAÇÃO
        WebElement elemento = getDriver().findElement(By.xpath("(//input[@type='tel'])[2]"));

        // Seleciona texto do começo do campo até o fim, segurando SHIFT e depois,
        // aplica o Backspace
        elemento.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.BACK_SPACE);

        // Seleciona todo o texto dando o comando "CONTROL + A" e depois, aplica o
        // Backspace
        elemento.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);

        // Apaga qualquer texto no componente
        elemento.clear();

        escreverSemTroca("(//input[@type='tel'])[2]", cep);
    }

    public void buscarCEP() throws InterruptedException {
        clicarXpath("//button[@id='postcode-search']/span");
        Thread.sleep(2000);
    }

    public void proximoDadosClientes() throws InterruptedException {
        clicarXpath("//div[2]/button[2]");
        //Thread.sleep(5000);
    }

    // ########################################################
    // ######## ESCOLHA OFERTA ########
    // ########################################################

    public void clickOferta1Black() throws InterruptedException {
        Thread.sleep(12000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[1]/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
    }

    public void clickOferta1() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("//ion-item[@id='offer-PR00460']/div/div/ion-label/h1");
    }

    public void clickBlackDependente() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("//*[@id=\"plan-1-11VJH56\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]");
    }// *[@id="plan-1-1LB0OUK"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p

    public void clickOferta_Ativacao() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("//*[@id=\"offer-PR00460\"]/div[1]/div");
    }

    public void clickOferta2() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath(
                "//p[contains(.,'TIM PRÉ TOP MAIS 3.0 (WhatsApp + Deezer Go + Prime Video + Voz ilimitada + internet p/ usar como quiser)')]");
    }

    public void fechaPopup() throws InterruptedException {
        clicarXpath("//div[3]/button/span");
    }

    public void proximoOferta() throws InterruptedException {
        clicarXpath("//span[contains(.,'Próximo')]");
        Thread.sleep(1000);
    }

    // ########################################################
    // ######## ENDEREÇO DO CLIENTE ########
    // ########################################################

    public void clickAntesLogradouro() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("//ion-item[5]/div/div/ion-select/button/span");
    }

    public void clickTipoLogradouro() throws InterruptedException {
        clicarXpath("//span[contains(.,'RUA')]");
    }

    public void setNomeDaRua(String rua) throws InterruptedException {
        escreverSemTroca("(//input[@type='text'])[3]", rua);
    }

    public void setNumero(String numero) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);// 10 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='tel'])[2]")));
        elemento.sendKeys("5");
    }


    public void setNumeroNum(String numero) throws InterruptedException {
        Thread.sleep(15000);
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-client-address/ion-content/div[2]/ion-card/ion-card-content/ion-list/ion-item[8]/div[1]/div/ion-input/input",
                numero);
    }

    public void proximoEnderecoClientes() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(getDriver(), 15000);// 15000 milissegundos = 15 segundos
     
            WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/button[2]/span")));
            elemento.click();
        }
     
   public void clickPopup1234() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(getDriver(), 15000);// 15000 milissegundos = 15 segundos
     
            WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'OK')]")));
            elemento.click();
            
        }
    

    public void proximoEnderecoClientes2() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath("//div[2]/button[2]/span");
        Thread.sleep(10000);
    }

    // ########################################################
    // ######### NOVA ATUALIZAÇÃO - OPÇÃO NOVA
    // ########################################################

    public void clickVerificarTIMLIVE() throws InterruptedException {
        clicarCSS(".button-clear > .button-inner");
        Thread.sleep(5000);
    }

    public void clickTipoDeComplemento() throws InterruptedException {
        // Thread.sleep(1000);
        clicarXpath("//ion-card-content/ion-item/div/div/ion-select/button/span");
    }

    public void escolhaTipoDeComplemento() throws InterruptedException {
        clicarXpath("//span[contains(.,'Apartamento')]");
    }

    public void clickComplemento() throws InterruptedException {
        clicarXpath("//ion-item[2]/div/div/ion-input/input");
    }

    public void setComplemento(String complemento) throws InterruptedException {
        escreverSemTroca("//ion-item[2]/div/div/ion-input/input", complemento);
    }

    // ########################################################
    // ######## ESCOLHA NUMERO ########
    // ########################################################

    public void clickNumero() throws InterruptedException {
        Thread.sleep(5000);
        //clicarXpath("(//ion-label[contains(text(), '(')])[3]");
        clicarXpath("(//ion-list/ion-item/div/ion-radio/button/span)[3]");
        
    }
    
    
    
    public String getResgata_Num_Limp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        WebElement elementoNumero = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ion-label[contains(text(), '(')])[3]")));
        String Resgata_Num_Limp = elementoNumero.getText();
        return Resgata_Num_Limp;
    }

    
    public String ResgataNumero_limpeza() throws InterruptedException {
        return obterTextoXpath("//ion-list/ion-item/div/ion-radio/button/span");
    }

    

    public void proximoEscolhaNum() throws InterruptedException {
        Thread.sleep(500);
        clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-number-choice/ion-content/div[2]/button[2]");
        Thread.sleep(20000);
    }

    // ########################################################
    // ######## ESCOLHA NUMERO ########
    // ########################################################

    public void proximo_Alacada() throws InterruptedException {
        Thread.sleep(1500);
        clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-request-approval/ion-content/div[2]/button[2]");
        // Thread.sleep(8000);
    }

    // ########################################################
    // ######## INCLUIR DEPENDENTE ########
    // ########################################################

    public void click_CPF_Dependente() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-family-insert-member/ion-content/div[2]/ion-card/ion-card-content/ion-card[2]/ion-card-content/ion-list/ion-item/div[1]/div/ion-input");
        Thread.sleep(500);
    }

    public void setCPF_Dependente(String cpfdependente) throws InterruptedException {
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-family-insert-member/ion-content/div[2]/ion-card/ion-card-content/ion-card[2]/ion-card-content/ion-list/ion-item/div[1]/div/ion-input",
                cpfdependente);
    }

    public void click_Incluir() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-family-insert-member/ion-content/div[2]/div/button[1]");
        Thread.sleep(500);
    }

    public void click_Fin_Atend_Dep() throws InterruptedException {
        Thread.sleep(500);
        clicarXpath("//*[@id=\"button-next\"]/span");
        Thread.sleep(500);
    }
    // ########################################################
    // ######## ESCOLHA PRODUTO ########
    // ########################################################

    public void escolherProduto() throws InterruptedException {
        clicarXpath("(//button[@id='button-back']/span)[2]");
        // Thread.sleep(2000);

        // Esperar até que o elemento seja visível (neste caso, até que o elemento tenha
        // o ID "meu_elemento")
        WebDriverWait wait = new WebDriverWait(getDriver(), 35);
        WebElement element = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//ion-card-header[contains(@class, 'card-header-md')]")));

        // Uma vez que o elemento esteja visível, clique nele
        // element.click();
    }

    // ########################################################
    // ######## ESCOLHA SEGMENTO ########
    // ########################################################

    public void clickPrepago() throws InterruptedException {
        clicarXpath("//*[@id=\"activation-type-pre\"]");
        Thread.sleep(10000);
    }

    public void cond_PosPago_Erro_Generico() throws InterruptedException {
        Thread.sleep(10000);
        String Plano = "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[1]/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p";
        // String TIM_BLACK_A_6_0 =
        // "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[1]/ion-item/div[2]/div/ion-label/ion-row[1]/ion-col/h1";

        if (Plano == "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[1]/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p") {
            // Thread.sleep(5000);
            // clicarXpath("//*[@id=\"activation-type-pos-fatura\"]/span");
            Thread.sleep(10000);
            clicarXpath(
                    "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[1]/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
            return;
        }

        else {
            Thread.sleep(5000);
            clicarXpath("/html/body/ion-app/ion-alert/div/div[3]/button");
            clicarXpath("//span[contains(.,'Pós-Pago");
            return;
        }
    }

    public void clickPospago() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);// 5000 milissegundos = 5 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Pós-Pago')]")));
        elemento.click();
        Thread.sleep(2000);
    }

    public void clickControleExpress() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//span[contains(.,'Controle Express')]");
        Thread.sleep(15000);
    }

    public void clickControleFatura() throws InterruptedException {
        clicarXpath("//span[contains(.,'Controle Fatura')]");
        Thread.sleep(15000);
    }

    public void clickControleFlex() throws InterruptedException {
        clicarXpath("//span[contains(.,'Controle Flex')]");
        Thread.sleep(10000);
    }

    public void clickTim_Controle_Redes_Sociais_5_0() throws InterruptedException {
        clicarXpath("//*[@id=\"msisdn-11981197553\"]/div[1]/div[1]");
        Thread.sleep(10000);
    }

    public void clickPosPagoFatura() throws InterruptedException {
        clicarXpath("//span[contains(.,'Pós-Pago Fatura')]");
        Thread.sleep(10000);
    }

    public void clickPosPagoExpress() throws InterruptedException {
        clicarXpath("//span[contains(.,'Pós-Pago Express')]");
        Thread.sleep(15000);
    }

    public void clickTimBlackMultiFatura() throws InterruptedException {
        clicarXpath("//span[contains(.,'TIM Black Multi Fatura')]");
    }

    public void clickTimBlackMultiExpress() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//span[contains(.,'TIM Black Multi Express')]");
    }

    public void clickTimBlackMultiB3() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath(
                "//p[contains(.,'60GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais')];");
    }

    // ########################################################
    // ######## RG ########
    // ########################################################

    public void clickBTN_RG() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-rga/ion-content/div[2]/ion-card/ion-card-content/ion-card[1]/ion-card-content/ion-row/ion-col/ion-item[1]/ion-checkbox/button/span");
    }

    public void clickRG() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-rga/ion-content/div[2]/ion-card/ion-card-content/ion-card[1]/ion-card-content/ion-row/ion-col/ion-item[2]/div[1]/div");
    }

    public void setRG(String rg_numero) throws InterruptedException {
        Thread.sleep(500);
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-rga/ion-content/div[2]/ion-card/ion-card-content/ion-card[1]/ion-card-content/ion-row/ion-col/ion-item[2]/div[1]/div/ion-input",
                rg_numero);
    }

    public void clickBTN2_RG() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-rga/ion-content/div[2]/ion-card/ion-card-content/ion-card[2]/ion-card-content/ion-row/ion-col/ion-item[1]/ion-checkbox/button/span");
    }

    public void clickRG2() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-rga/ion-content/div[2]/ion-card/ion-card-content/ion-card[2]/ion-card-content/ion-row/ion-col/ion-item[2]/div[1]/div");
    }

    public void setRG2(String rg2) throws InterruptedException {
        Thread.sleep(500);
        escreverSemTroca(
                "/html/body/ion-app/ng-component/ion-nav/page-rga/ion-content/div[2]/ion-card/ion-card-content/ion-card[2]/ion-card-content/ion-row/ion-col/ion-item[2]/div[1]/div",
                rg2);
    }

    // ########################################################
    // ######## MIGRAÇÃO ########
    // ########################################################

    public void clickPre_ControleFatura() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//span[contains(.,'Pré para Controle Fatura')]");
        Thread.sleep(20000);
    }

    public void clickPre_ControleExpress() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//span[contains(.,'Pré para Express')]");
        Thread.sleep(5000);
    }

    public void clickPre_ControleFlex() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("/span[contains(.,'Pré para Controle Flex')]");
        Thread.sleep(5000);
    }

    // ########################################################
    // ######## IMEI DO APARELHO ########
    // ########################################################

    public void setIMEI(String imei) throws InterruptedException {
        Thread.sleep(5000);
        escreverSemTroca("//input[@type='text']", imei);
    }

    public void clickPopupIMEI() throws InterruptedException {
        clicarXpath("//span[contains(.,'OK')]");
    }

    public void validarIMEI() throws InterruptedException {
        clicarXpath("//span[contains(.,'Validar')]");
        Thread.sleep(5000);
    }

    public void clickBotaoFidelAparelho() throws InterruptedException {
        clicarXpath("//span[contains(.,'Próximo')]");
    }

    // ########################################################
    // ######## INFORMAÇÃO DA FATURA ########
    // ########################################################

    public void clickDataVencimento_P() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("(//button[@id='undefined']/span)");
    }

    public void clickDataVencimento() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//*[@id=\"dueDate-12\"]/ion-col[1]");
    }

    public void clickDataVencimento1() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-invoice-information/ion-content/div[2]/ion-card/ion-card[1]/ion-card-content/ion-row[2]/ion-col[1]/ion-radio/button/span");
    }

    public void clickDebitoAtutomatico() throws InterruptedException {
        clicarXpath("//ion-card[4]/ion-row/ion-col[2]");
    }

    public void clickBanco() throws InterruptedException {
        clicarXpath("//ion-select/button/span");
    }

    public void escolhaBanco() throws InterruptedException {
        clicarXpath("//span[contains(.,'BANCO DO BRASIL S.A.')]");
    }

    public void setAgencia(String agencia) throws InterruptedException {
        escreverSemTroca("//ion-list/ion-item[2]/div/div/ion-input/input", agencia);
    }

    public void setConta(String conta) throws InterruptedException {
        escreverSemTroca("//ion-item[3]/div/div/ion-input/input", conta);
    }

    public void clickBotaoInfFatura() throws InterruptedException {
        clicarXpath("//span[contains(.,'Próximo')]");
        Thread.sleep(15000);
    }

    // ########################################################
    // ######## INSERIR E TROCA DE CHIP ########
    // ########################################################

    public void setCHIP(String chip) throws InterruptedException {
        escreverSemTroca("//ion-input[@id='chip-barcode']/input", chip);
    }

    public void setTrocaCHIP(String chip) throws InterruptedException {
        Thread.sleep(15000);
        escreverSemTroca("//ion-input[@id='chip-barcode']/input", chip);
    }

    public void clickMotivoTrocaChip() throws InterruptedException {
        clicarXpath("//ion-select/button/span");
    }

    public void clickMotivoComGarantia_TrocaChip() throws InterruptedException {
        clicarXpath("//div/div/button[2]/span"); // COM GARANTIA
    }

    public void clickMotivoSemGarantia_TrocaChip() throws InterruptedException {
        Thread.sleep(1000);
        clicarXpath("//div/div/button[3]/span"); // SEM GARANTIA
    }

    public void clickMotivoPerda_TrocaChip() throws InterruptedException {
        clicarXpath("//div/div/button[5]/span"); // PERDA
    }

    public void proximoInserirCHIP() throws InterruptedException {
        clicarXpath("//span[contains(.,'Próximo')]");
        Thread.sleep(5000);
    }

    // ########################################################
    // ######## NOVO ATENDIMENTO ########
    // ########################################################

    public void setCPF(String cpf) throws InterruptedException {
        escreverSemTroca("//input[@type='tel']", cpf);
    }

    public void setTelefone(String telefone) throws InterruptedException {
        //Thread.sleep(1000);
        escreverSemTroca("//ion-input[@id='input-tel-protocol']/input", telefone);
    }

    public void proximoNovoAtendimento() throws InterruptedException {
        Thread.sleep(1000);
        clicarXpath("//div[2]/button/span");
        //Thread.sleep(30000);
    }

    // ############################################################# //
    // ################## PLANOS TIM PRÉ ########################### //
    // ############################################################# //

    public void clickTimPre() throws InterruptedException {
        Thread.sleep(13000);
        clicarXpath("//p[contains(.,'TIM PRÉ')]");
    }

    public void clickTimPreTop() throws InterruptedException {
        Thread.sleep(15000);
        // clicarXpath("//*[@id=\"msisdn-11983090021\"]/div[1]/div[1]");
        clicarXpath("//p[contains(.,'TIM PRÉ TOP')]");
    }

    public void clickPre_PosPago_Fatura() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//span[contains(.,'Pré para Pós-Pago Fatura')]");
        Thread.sleep(5000);
    }

    public void clickPre_PosPago_Express() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//span[contains(.,'Pré para Pós-Pago Express')]");
        Thread.sleep(20000);
    }

    // ############################################################# //
    // #################### PLANOS TIM CONTROLE #################### //
    // ############################################################# //

    public void clickPlanoTimControle_Fatura() throws InterruptedException {
        Thread.sleep(10000);
        // clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-select-plan/ion-content/div[2]/ion-card[2]/ion-card-header");
        clicarXpath("//span[contains(.,'Pré para Controle Fatura')]");
        Thread.sleep(5000);
    }

    // PLANO TIM CONTROLE SMART FLEX
    public void clickTimControleSmartFlex() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//p[contains(.,'TIM Controle Smart Flex')]");
    }

    // PLANO TIM CONTROLE FLEX
    public void clickPlanoTimControle_Flex() throws InterruptedException {
        Thread.sleep(10000);
        // clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-select-plan/ion-content/div[2]/ion-card[3]/ion-card-header");
        clicarXpath("/span[contains(.,'Pré para Controle Flex')]");
        Thread.sleep(5000);
    }

    // PLANO TIM CONTROLE EXPRESS
    public void clickPlanoTimControle_Express() throws InterruptedException {
        Thread.sleep(10000);
        // clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-select-plan/ion-content/div[2]/ion-card[4]/ion-card-header");
        clicarXpath("//span[contains(.,'Pré para Express')]");
        Thread.sleep(5000);
    }

    // PLANO TIM CONTROLE SMART 4 0
    public void clickPlanoTimControleSmart_4() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//ion-item[@id='plan-1-11L5P25']/div[2]/div/ion-label/ion-row/ion-col/h1");
    }

    // PLANO TIM CONTROLE SMART 5 0
    public void clickPlanoTimControle_Smart_5_0() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath(
                "//p[contains(.,'5GB, Ligações Ilimitadas, Roaming Nacional, Whatsapp, Messenger, Telegram, Aya Books, Reforça Reader Premium, Bancah Jornais II e TIM Segurança Digital Light.  Além de Facebook, Instagram e Twitter a vontade por 3 meses')]");
        Thread.sleep(5000);
    }

    // PLANO TIM CONTROLE SMART 5 0 - INICIAL
    public void click1PlanoTimControle_Smart_5_0() throws InterruptedException {
        Thread.sleep(15000);
        // clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-attendance/ion-content/div[2]/ion-card[2]/ion-card-content/ion-card[2]/ion-card-content/ion-list/ion-item/div[1]/div[1]");
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-attendance/ion-content/div[2]/ion-card[1]/ion-card-content/contract-card/ion-card/ion-card-content/ion-list/ion-item/div[1]/div[1]/ion-label/p");
    }

    // PLANO TIM CONTROLE REDES SOCIAIS
    public void clickTimControle_RedesSociais_5() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[2]/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
    }

    // PLANO TIM CONTROLE GIGA A PROMO EXPRESS 3 1
    public void clickTimControle_Giga_A_Promo_Express31() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//*[@id=\"msisdn-24981240945\"]/div[1]/div[1]");
    }

    // PLANO TIM CONTROLE GIGA B PROMO EXPRESS 3 1
    public void clickPlano2() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//*[@id=\"plan-1-1DT4BJP\"]/div[2]/div/ion-label/p");
    }

    // PLANO TIM CONTROLE GIGA C EXPRESS 3 1
    public void clickPlano4_A() throws InterruptedException {
        clicarXpath(
                "//p[contains(.,'6,6GB + Ligações Ilimitadas, Roaming Nacional, Facebook, Instagram, Twitter, Whatsapp, Messenger e Telegram,  Bancah Premium + Jornais e Aya Books')]");
    }

    // PLANO TIM CONTROLE A PLUS
    public void clickTimControle_A_Plus() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//p[contains(.,'TIM Controle A Plus 4 0')]");
    }

    // PLANO TIM CONTROLE A PLUS 5 0
    public void clickPlanoTimControleAPlus50() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[1]/ion-item/div[2]/div");
    }

    // PLANO TIM CONTROLE B EXPRESSION 5 1
    public void clickPlanoTimControle_B_EXP_5_1() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//*[@id=\"plan-1-1LB0OUK\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
        Thread.sleep(5000);
    }

    // PLANO TIM CONTROLE C EXPRESSION 5 1
    public void clickPlanoTimControle_C_EXP_5_1() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//*[@id=\"plan-1-1LB0R0W\"]/div[2]/div");
        Thread.sleep(5000);
    }

    // PLANO TIM CONTROLE J EXPRESSION 6
    public void clickPlanoTimControle_J_EXP6() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card/ion-card-content/div[1]/ion-item/div[2]/div");
        Thread.sleep(5000);
    }

    // PLANO TIM CONTROLE C EXPRESSION 6 1
    public void clickPlanoTimControle_C_EXP_6_1() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card/ion-card-content/div/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
        Thread.sleep(5000);
    }

    // PLANO TIM CONTROLE LIGHT PLUS 5 0
    public void clickPlanoTimControleRedes_Sociais() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[2]/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]");
    }

    // ############################################################# //
    // ####################### PLANOS TIM PÓS ###################### //
    // ############################################################# //

    // PLANO TIM PÓS PAGO FATURA
    public void clickPlanoTim_POS_PAGO_FATURA() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-select-plan/ion-content/div[2]/ion-card[5]/ion-card-header");
        Thread.sleep(5000);
    }

    // PLANO TIM PÓS PAGO EXPRESS
    public void clickPlanoTim_PÓS_PAGO_EXPRESS() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-select-plan/ion-content/div[2]/ion-card[6]/ion-card-header");
        Thread.sleep(5000);
    }

    // PLANO TIM PÓS
    public void clickPosTim() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//p[contains(.,'PÓS DA TIM')]");
    }

    // PLANO TIM PÓS PAGO MÓVEL
    public void clickBasicoPosPagoMovel() throws InterruptedException {
        Thread.sleep(12000);
        clicarXpath("//p[contains(.,'Básico Pós-Pago Móvel')]");
    }

    // ############################################################# //
    // ##################### PLANOS TIM BLACK ###################### //
    // ############################################################# //

    // ######## PLANO TIM BLACK MULTI FATURA ########
    public void clickPlanoBlackMult_Fatura() throws InterruptedException {
        Thread.sleep(8000);
        clicarXpath("//ion-card[8]/ion-card-header");
    }

    // ######## PLANO TIM BLACK MULTI TITULAR ########
    public void clickPlanoTimBlackMult_titular() throws InterruptedException {
        Thread.sleep(3000);
        clicarXpath("//ion-col/ion-item/div/div/ion-label/ion-row/ion-col");
    }

    // ######## PLANO TIM BLACK MULTI A ULTRA ########
    public void clickBlackMulti_A_Ultra() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-select-plan/ion-content/div[2]/ion-card[8]/ion-card-content/div/ion-item/div[2]/div/ion-label/p");
    }

    // ######## PLANO TIM BLACK MULTI A HERO 3 0 ########
    public void clickBlackMulti_A_Hero3_0() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//*[@id=\"plan-1-11VJ069\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
    }

    // ######## PLANO TIM BLACK MULTI A HERO 5 0 ########
    public void clickBlackMulti_A_Hero5_0() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[1]/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
    }

    // ######## PLANO TIM BLACK MULTI A 6 0 ########
    public void clickBlackMulti_A_6_0() throws InterruptedException {
        Thread.sleep(6000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-select-plan/ion-content/div[2]/ion-card[8]/ion-card-content/div[1]/ion-item/div[2]/div");
        Thread.sleep(3000);
    }

    // ######## BLACK DEPENDENTE ########
    public void clickBlack_Dep() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card/ion-card-content/div/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]");
    }

    // ######## PLANO TIM BLACK MULTI A 3 0 ########
    public void clickMultiA3_0() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-select-plan/ion-content/div[2]/ion-card[8]/ion-card-header");
    }

    public void clickTimBlackMultiFat() throws InterruptedException {
        clicarXpath(
                "//p[contains(.,'30GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 500GB, TIM Segurança Digital, Reforça, Band News, Band Sports e Apps de Redes Sociais.')]");
    }

    // ######## PLANO TIM BLACK MULTI B 3 0 ########
    public void clickMultiB3_0() throws InterruptedException {
        clicarXpath(
                "//p[contains(.,'60GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais')]");
    }

    // ######## PLANO TIM BLACK MULTI C 3 0 ########
    public void clickMultiC3_0() throws InterruptedException {
        clicarXpath(
                "//p[contains(.,'100GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais.')]");
    }

    // ######## PLANO TIM BLACK MULTI D 3 0 ########
    public void clickMultiD3_0() throws InterruptedException {
        clicarXpath(
                "//p[contains(.,'180GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais.')]");
    }

    // ######## PLANO TIM BLACK A 3 ########
    public void clickPlanoTimBlack_A3() throws InterruptedException {
        clicarXpath(
                "//p[contains(.,'15GB, Ligações e SMS ilimitados, Audiobook By Ubook Premium, Bancah Premium + Jornais, TIM Segurança Digital Premium, TIM Music by Deezer, Reforça e Apps de Redes Sociais.')]");
    }

    // ######## PLANO TIM BLACK B 3 ########
    public void clickPlanoTimBlackB3() throws InterruptedException {
        Thread.sleep(10000);
        // clicarXpath("//*[@id=\"plan-1-15YAXJW\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
        clicarXpath("//p[contains(.,'TIM Black A 3 0')]");
        Thread.sleep(5000);
    }

    public void clickPre_TimBlackMultiExpress() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//span[contains(.,'Pré para TIM Black Multi Express')]");
        Thread.sleep(5000);
    }

    public void clickPre_TimBlackMultiFatura() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//span[contains(.,'Pré para TIM Black Multi Fatura')]");
        Thread.sleep(5000);
    }

    // ######## PLANO TIM BLACK B 5 0 ########
    public void clickPlanoTimBlackB5_0() throws InterruptedException {
        Thread.sleep(15000);
        // clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-attendance/ion-content/div[2]/ion-card[2]/ion-card-content/ion-card[2]/ion-card-content/ion-list/ion-item/div[1]/div[1]/ion-label/p");
        clicarXpath("//p[contains(.,'TIM Black B 5 0')]");
    }

    // ######## PLANO TIM BLACK C ULTRA ########
    public void clickTimBlack_C_Ultra() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//p[contains(.,'TIM Black C Ultra')]");
    }

    // ######## PLANO TIM BLACK C HERO 3 ########
    public void clickPlanoTimBlack_HERO_C3() throws InterruptedException {
        clicarXpath("//");
    }

    // ######## PLANO TIM BLACK D 3 0 ########
    public void clickPlanoTimBlackMult_D30() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath(
                "//p[contains(.,'180GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais.')]");
    }

    // ######## PLANO TIM BLACK A EXPRESS 2 ########
    public void clickPlanoBlack_A_Express_2() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card/ion-card-content/div[1]/ion-item/div[2]/div");
    }

    // ######## PLANO TIM BLACK A EXPRESS 5_1 ########
    public void clickPlanoBlack_A_Express_5_1() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//*[@id=\"plan-1-1LDH794\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
    }

    // ######## PLANO TIM BLACK B EXPRESS 2 ########
    public void clickPlanoBlack_B_Express_2() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//*[@id=\"msisdn-12981118605\"]/div[1]/div[1]");
        // p[contains(.,'22GB, Ligações e SMS ilimitados, Aya Books, Bancah Premium
        // Jornais, TIM Segurança Digital, TIM Music by Deezer e Apps de Redes
        // Sociais.')]");
    }

    // ######## PLANO TIM BLACK C EXPRESS 2 ########
    public void clickPlanoBlack_C_Express_2() throws InterruptedException {
        clicarXpath(
                "//p[contains(.,'27GB, Ligações e SMS ilimitados, Aya Books Premium, Bancah Premium Jornais, TIM Segurança Digital, TIM Music by Deezer e Apps de Redes Sociais.')]");
    }

    // ######## PLANO TIM BLACK A 6 0 ########
    public void clickPlanoTimBlackA_6_0() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[1]/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
    }

    // ############################################################# //
    // ####################### FIDELIZAÇÕES ######################## //
    // ############################################################# //

    // ######## SEM FIDELIZAÇÃO ########
    public void clickPlanoSemFidelizacao() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15000);// 15000 milissegundos = 15 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ion-item/ion-radio/button/span")));
        elemento.click();
    }

    // ######## SEM FIDELIZAÇÃO_Multi Fatura ########
    public void clickPlanoSemFidelizacaoMF() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-select-plan/ion-content/div[2]/ion-card[8]/ion-card-content/div[1]/ion-row[1]/ion-col/ion-row[1]/ion-col[2]/ion-radio/button");
    }

    // ######## FIDELIZAÇÃO DO PLANO ########
    public void clickFidelizacaoPlano() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15000);// 15000 milissegundos = 15 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ion-item[2]/ion-radio/button/span")));
        elemento.click();
        }

    // ######## FIDELIZAÇÃO DO APARELHO ########
    public void clickFidelApar() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card[2]/ion-card-content/div[1]/ion-list/ion-item[3]/ion-radio/button/span");
        Thread.sleep(2000);
    }

    // ######## FIDELIZAÇÃO PLANO + APARELHO NÃO FIDELIZADO ########
    public void clickOpacao4() throws InterruptedException {
        clicarXpath("//ion-item[4]/ion-radio/button/span");
    }

    // ######## FIDELIZAÇÃO DO PLANO + APARELHO ########
    public void clickFidelPlano_Apar() throws InterruptedException {
        clicarXpath("//ion-item[5]/ion-radio/button/span");
        Thread.sleep(5000);
    }

    // ######## APARELHOS NÃO FIDELIZADOS ########
    public void clickOpacao6() throws InterruptedException {
        clicarXpath("//ion-item[6]/ion-radio/button/span");
    }

    // ############################################################# //
    // ##################### PLANO DEPENDENTE ###################### //
    // ############################################################# //

    // ########PLANO TITULAR ########
    public void escolhaTitular() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//ion-col[contains(.,'Titular')]");
    }

    // ########PLANO DEPENDENTE ########
    public void escolhaDependente() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath("//ion-col[contains(.,'Dependente')]");
        //// *[@id="plan-1-11VJH56"]/div[2]/div
    }

    public void numeroTitular(String numtitular) throws InterruptedException {
        escreverSemTroca("//input[@type='tel']", numtitular);
    }

    public void clickMotivo1() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//ion-label[contains(.,'Motivo 1')]");
    }

    // ########################################################
    // ######## POPUP E BOTÃO PROXIMO ########
    // ########################################################

    public void clickPopup() throws InterruptedException {
WebDriverWait wait = new WebDriverWait(getDriver(), 15000);// 15000 milissegundos = 15 segundos
        
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'OK')]")));
        elemento.click();
    }

    public void clickPopup123() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15000);// 15000 milissegundos = 15 segundos
        
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'OK')]")));
        elemento.click();
        Thread.sleep(2000);
    }
        

    public void clickPopupFim() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15000);// 15000 milissegundos = 15 segundos
        
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'FIM')]")));
        elemento.click();
        Thread.sleep(18000);
    }
        

    public void clickPopupSim() throws InterruptedException {
WebDriverWait wait = new WebDriverWait(getDriver(), 15000);// 15000 milissegundos = 15 segundos
        
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Sim')]")));
        elemento.click();
        
    }

    public void clickPopupNao() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15000);// 15000 milissegundos = 15 segundos
        
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'OK')]")));
        elemento.click();
        //Thread.sleep(18000);
    }
        

    public void clickBotaoProx() throws InterruptedException {
        Thread.sleep(5000);//span[contains(.,'Não')]
        clicarXpath("//span[contains(.,'Próximo')]");
    }

    public void poupupEstouCiente() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);// 15000 milissegundos = 15 segundos
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Estou Ciente')]")));
        elemento.click();
        //Thread.sleep(10000);
    }

    public void poupupEndereco() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("/html/body/ion-app/ion-alert/div/div[3]/button");
    }

    public void poupupAntesTrocaPlano() throws InterruptedException {
        clicarXpath("/html/body/ion-app/ion-alert/div/div[3]/button");
        Thread.sleep(10000);
    }

    public void clickBotaoProsseguir() throws InterruptedException {
        clicarXpath("//span[contains(.,'Próximo')]");
        Thread.sleep(5000);
    }

    public void clickBotaoProsseguirPlano1() throws InterruptedException {
        clicarXpath("//span[contains(.,'Próximo')]");
        Thread.sleep(20000);
    }

    // ########################################################
    // ######## PLANO TIM BLACK DEPENDENTE ########
    // ########################################################

    // ########PLANO DEPENDENTE ########
    public void clickPlanoDependente() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-plans/ion-content/div[2]/ion-card/ion-card-content/div/ion-item/div[2]/div/ion-label/ion-row[1]/ion-col");
    }

    // ######## PLANO SEM FIDELIZACAO ########
    public void clickPlanoSemFidel() throws InterruptedException {
        clicarXpath("//ion-radio/button/span");
    }

    public void clickBotaoBlackDep() throws InterruptedException {
        clicarXpath("//span[contains(.,'Próximo')]");
    }

    // ############################################################

    // ########################################################
    // ######## RESUMO DA OPERAÇÃO ########
    // ########################################################

    public void checkCiente() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ion-card[2]/ion-card-content/ion-item/ion-checkbox/button/span")));
        elemento.click();
   }

    public void clickCriarPedido() throws InterruptedException {
        clicarXpath("//span[contains(.,'Criar Pedido')]");
        Thread.sleep(35000);
    }

    public void clickClienteCienteMapa() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-operation-summary/ion-content/div[2]/family-summary/div/ion-card[2]/ion-card-content/ion-row/ion-col[1]/ion-checkbox/button/span");
        // clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-operation-summary/ion-content/div[2]/div/ion-card[2]/ion-card-content/ion-item/ion-checkbox/button/span");
    }

    public void clickCriarPedidoComDoc() throws InterruptedException {
        clicarXpath("//span[contains(.,'Criar Pedido com Documentação')]");
        Thread.sleep(35000);

    }

    public void clickEnviarSolicitacaoAlçada() throws InterruptedException {
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-operation-summary/ion-content/div[2]/div/button[1]/span");
        Thread.sleep(40000);
    }

    // ########################################################
    // ######## SERVIÇO ########
    // ########################################################

    public void clickBotaoNetflix() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//ion-item[@id='service-Netflix Padrão']/div/div/ion-label/h1");
    }

    public void clickBotaoHBO() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//*[@id=\"service-HBO Max\"]/div[1]/div");
    }

    public void clickBotaoYoutube() throws InterruptedException {
        clicarXpath("//ion-item[@id='service-YouTube Premium']/div/div/ion-label");
    }

    // ########################################################
    // ######## CARTÃO DE CRÉDITO ########
    // ########################################################

    public void setNumeroCartao(String numcartao) throws InterruptedException {
        escreverComDoisIframes("//input", numcartao);
    }

    public void clickMesValidade() throws InterruptedException {
        clicarBotaoIframe("//select");
        Thread.sleep(1000);
    }

    public void escolhaMesValidade() throws InterruptedException {
        clicarBotaoIframe("//option[contains(.,'06')]");
    }

    public void clickAnoValidade() throws InterruptedException {
        clicarBotaoIframe("//div[2]/select");
        Thread.sleep(1000);
    }

    public void escolhaAnoValidade() throws InterruptedException {
        clicarBotaoIframe("//div[2]/select/option[4]");
    }

    public void setCodSeguranca(String codseg) throws InterruptedException {
        escreverComDoisIframes("//input[@id='cardCvv']", codseg);
        Thread.sleep(5000);
    }

    public void clickConfPagamento() throws InterruptedException {
        clicarBotaoIframe("//buton[contains(.,'Confirmar pagamento')]");
        Thread.sleep(30000);
    }

    // ########################################################
    // ######## GERAÇÃO DE PROTOCOLO ########
    // ########################################################

    public void escolhaTimControleSmartFlex_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-col[contains(.,'Titular')]");
    }

    public void clickMotivo1_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-select/button/span");
    }

    public void escolhaMotivo1_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Não Informado')]");
    }

    public void clickMotivo2_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-item[2]/div/div/ion-select/button/span");
    }

    public void escolhaMotivo2_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Não Informado')]");
    }

    public void clickMotivo3_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-item[3]/div/div/ion-select/button/span");
    }

    public void escolhaMotivo3_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Não Informado')]");
    }

    public void clickMotivo4_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-item[4]/div/div/ion-select/button/span");
    }

    public void escolhaMotivo4_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Não Informado')]");
    }

    public void clickResultado_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-card[2]/ion-card-content/ion-item/div/div/ion-select/button/span");
    }

    public void escolhaResultado_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Chamado aberto')]");
    }

    public void clickMeioDeContato_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-card[2]/ion-card-content/ion-item[2]/div/div/ion-select/button/span");
    }

    public void escolhaMeioDeContato_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'E-mail')]");
    }

    public void clickObservacao_NovoProtocolo() throws InterruptedException {
        clicarCSS(".text-input");
    }

    public void setObservacao_NovoProtocolo(String protocolo) throws InterruptedException {
        escreverSemTroca("//textarea", protocolo);
    }

    public void proximo_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Próximo')]");
    }

    public void clickFinalizarTarefa() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-family-insert-member/ion-content/div[2]/div/button[2]/span");
    }

    // ########################################################
    // ######## BUSCA PROTOCOLO - GET ########
    // ########################################################

    public String ResgataProtocolo() throws InterruptedException {
        return obterTextoXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-protocol-generated/ion-content/div[2]/ion-card[1]/ion-card-content/ion-item/div[1]/div");
    }

    // Aqui eu pego um "valor/numero" para ser usado

    public String ResgataMSISDN() throws InterruptedException {
        return obterTextoMSISDNXpath(
                "/html/body/ion-app/ng-component/ion-nav/page-protocol-generated/ion-content/div[2]/ion-card[2]/ion-card-content/ion-item/div[1]/div");

    }
    
    public String Resgata_Numero_MSISDN() throws InterruptedException {
        return obterNumeroMSISDN_Xpath(
                "//ion-list/ion-item/div/ion-radio/button/span");
    }

    // ########################################################
    // ######## ALTERNANDO ENTRE ABAS ########
    // ########################################################

// #####################################################################
// ######## DEU ERRO - TENTA 3X ATÉ IR - SENÃO ABORTA COM MSG ########
// ########################################################

    
    public static void verificarElementoScore(String elementoScore, String elementoPlano, String elementoAnterior) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5); // Até 5 segundos
        int tentativas = 5;
        for (int i = 0; i < tentativas; i++) {
            try {
                WebElement scoreElements = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementoScore)));
                if (scoreElements.isDisplayed()) {
                    WebElement planoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementoPlano)));
                    planoElement.click();
                    return;
                }
            } catch (Exception e) {
                // Ações de tratamento de exceção
                System.out.println("O elemento Score não foi encontrado. Tentativa " + (i + 1));
                WebElement alarmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='alert-button alert-button-md alert-button-default alert-button-default-md']")));
                alarmButton.click();
                WebElement elementoAnteriorButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementoAnterior)));
                elementoAnteriorButton.click();
                Thread.sleep(3000);
            }
        }
    }

  //#####################################################################
  //######## ACESSANDO O JENKINS - EFETUANDO LIMPEZA - CPF E MSISDN ########
  //########################################################
    
    public void login_Jenkins(String login) throws InterruptedException {
        escreverSemTroca("//input[@name='j_username']", login);
    }
    
    public void senha_Jenkins(String senha) throws InterruptedException {
        escreverSemTroca("//input[@name='j_password']", senha);
    }
    
    public void botao_Jenkins() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and @name='Submit']")));
        elemento.click();
    }
    
    public void construir_Parametro() throws InterruptedException {
        clicarXpath(
                "//span[@class='task-link-text' and text()='Build with Parameters']");
    }
    
    public void send_CPF_Jenkins(String cpf) throws InterruptedException {
        escreverSemTroca(
                "(//textarea[@name='value'])[1]",cpf);
    }
    
    public void send_MSISDN_Jenkins(String msisdn) throws InterruptedException {
        escreverSemTroca(
                "(//textarea[@name='value'])[2]", msisdn);
    }
    
    public void botao_build() throws InterruptedException {
        clicarXpath(
                "//button[@type='submit' and @id='yui-gen1-button']");
    }
    
    
    
    
    
    
    
//#####################################################################
//######## ESPERANDO O OBJETO APARECER PARA CLICAR ########
//########################################################

    public void espera_elemento() throws InterruptedException {
        // Esperar até que o elemento seja visível (neste caso, até que o elemento tenha
        // o ID "meu_elemento")
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ion-radio/button/span")));

        // Uma vez que o elemento esteja visível, clique nele
        element.click();

    }
}