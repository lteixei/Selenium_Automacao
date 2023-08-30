package br.ce.wcaquino.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Statement;

public class DataUtils {
	
	public static Date obterDataComDiferencaDias(int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		return calendar.getTime();
	}
	
	public static String obterDataFormatada(Date data) {
		DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(data);
	}

	private static Connection connect;
    //Conexao com banco
    public static Connection newBSCSIXConnection() {
        try {
            // Load the JDBC driver
            String portNumber="", sid="", host="", url="", username="", password="", nameService=""; 
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            // Create a connection to the database
            portNumber = "1525";
            nameService = "BSCSIXFQA1";
            host = "snelnxm83";
            url = "jdbc:oracle:thin:@" + host + ":" + portNumber + ":" + nameService;
            username = "SYSADM";
            password = "IX1bscs$.";
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Sucesso ao conectar no BD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ops, erro ao conectar no BD!");
        }
        return connect;
    }
    public ResultSet executeAndReturnFirstResult(String sql){
        try {
            Statement query = connect.createStatement();
            System.out.print("Executando busca: \n" + sql);
            // Executa Script
            ResultSet dados = query.executeQuery(sql);
            dados.next();
            return dados;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //Fichar Conexão
    public static void closeConnection(){
        try {
            connect.close();
            System.out.println("Conexão com BD fechada");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
