/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class ConnectionPostgresql {
    
  
    private String url = "jdbc:postgresql://localhost:5432/loteriapos";
    private String driver = "org.postgresql.Driver";
    private String user = "postgres";
    private String password = "luciano";
    private Connection con;
    
    
    public ConnectionPostgresql() {
       
    }
    
        
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
         Class.forName(this.driver);
         this.con = DriverManager.getConnection(url, user , password);
         return con;
      }
    
}
