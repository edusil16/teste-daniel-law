package br.com.teste.util.domain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static Connection getConnection() {
        
        Connection conn = null;

        String rost = "jdbc:mysql://localhost:3306/teste_daniel?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";
        String senha = "340608";

        try {
        	
        	Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(rost, user, senha);           
           
        } catch (SQLException ex) {

            System.err.println("Erro ao conectar na base de dados" + ex.getMessage());

            throw new RuntimeException(ex.getMessage());
            
        }catch (ClassNotFoundException e) {
			
        	System.out.println(e.getMessage());
		}   
        
        return conn;        
    }
}