package br.ce.wcaquino.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = false;
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime(); 
	//ESSA LINHA A CADA BATERIA DE TESTE ELA TROCAR� O NOME E EU N�O VOU PRECISAR MAIS IR L� PARA DELETAR E COME�AR OUTRO TESTE
	//fAZENDO ISSO, TENHO QUE IR NA onde criei e alterei as contas e trocar o nome para "NOME_CONTA_ALTERADA
	
	public static Browsers browser = Browsers.CHROME;
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}

}
