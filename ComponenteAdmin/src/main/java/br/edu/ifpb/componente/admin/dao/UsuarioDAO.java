/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.componente.admin.dao;

import br.edu.ifpb.componente.admin.connection.ConnectionPostgreSQL;
import br.edu.ifpb.componenteadmin.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class UsuarioDAO {
    
    ConnectionPostgreSQL connectionPostgreSQL = new ConnectionPostgreSQL();
   

    public UsuarioDAO() {
        
    }
        
    public void save(Usuario u) throws SQLException, ClassNotFoundException{
        Connection con = connectionPostgreSQL.getConnection();
        String sql = ("insert into usuario (nome,cpf,email,tif,imagem1,imagem2,imagem3,imagem4)values(?,?,?,?,?,?,?,?)");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u.getNome());
        ps.setString(2, u.getCpf());
        ps.setString(3, u.getEmail());
        ps.setString(4, u.getTif());
        ps.setBytes(5, u.getImagem1());
        ps.setBytes(6, u.getImagem2());
        ps.setBytes(7, u.getImagem3());
        ps.setBytes(8, u.getImagem4());
        ps.execute();
        ps.close();
        con.close();
    }
    
   
    
    
}
