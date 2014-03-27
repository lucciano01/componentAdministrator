/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.componente.admin.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class ConnectionPostgreSQL {
    
    private String url,password, driver, user;
	
	
	public ConnectionPostgreSQL() {
		this.driver = ("org.postgresql.Driver");
		this.url = ("jdbc:postgresql://localhost:5432/projeto_final_pos");
		this.password = ("luciano");
		this.user = ("postgres");
	}


	public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(this.driver);
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
		}
    
}
