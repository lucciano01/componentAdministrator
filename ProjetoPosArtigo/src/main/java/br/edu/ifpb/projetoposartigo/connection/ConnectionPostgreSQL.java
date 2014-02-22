/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetoposartigo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class ConnectionPostgreSQL {
    
    private Connection con;
    private String url = "jdbc:postgresql://localhost:5432/projeto_pos";
    private String driver = "org.postgresql.Driver";
    private String user = "postgres";
    private String password = "luciano";
    
    public ConnectionPostgreSQL(){
        
    }
    
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
    
}
