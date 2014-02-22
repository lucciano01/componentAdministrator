/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetoposartigo.dao;

import br.edu.ifpb.projetoposartigo.connection.ConnectionPostgreSQL;
import br.edu.ifpb.projetoposartigo.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class UsuarioDAO {
    
    ConnectionPostgreSQL connection = new ConnectionPostgreSQL();
    
    public void addUsuario(Usuario usuario) throws ClassNotFoundException, SQLException{
        Connection con = connection.getConnection();
        String sql = ("insert into usuario(nome,idade,cpf)values(?,?,?)");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setInt(2, usuario.getIdade());
        ps.setString(3, usuario.getCpf());
        ps.execute();
        ps.close();
        con.close();
    }
    
    public Usuario getUsuarioById(int id) throws ClassNotFoundException, SQLException{
        Usuario usuario  =  new Usuario();
        Connection con = connection.getConnection();
        String sql = ("select * from Usuario u where u.id=?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        usuario.setNome(rs.getString("nome"));
        usuario.setCpf(rs.getString("cpf"));
        usuario.setIdade(rs.getInt("idade"));
        }
        rs.close();
        ps.close();
        con.close();
        return usuario;
    }
    
    public List<Usuario> getUsuarios() throws ClassNotFoundException, SQLException{
        Usuario usuario = null;
        List<Usuario> usuarios  = new ArrayList<Usuario>();
        Connection con = connection.getConnection();
        String sql = ("select * from Usuario");
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setIdade(rs.getInt("idade"));
            usuario.setCpf(rs.getString("cpf"));
            usuarios.add(usuario);
        }
        rs.close();
        ps.close();
        con.close();
        
        return usuarios;
    }
    
    public void removeUsuario(int id) throws SQLException, ClassNotFoundException{
        Connection con = connection.getConnection();
        String sql = ("delete from Usuario u where u.id=?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();
        con.close();
     }
    
    public void updateUsuario(Usuario usuario, int id) throws ClassNotFoundException, SQLException{
        Connection con = connection.getConnection();
        String sql  = ("update Usuario u set nome=?, cpf=?, idade=? where u.id=?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getCpf());
        ps.setInt(3, usuario.getIdade());
        ps.setInt(4, id);
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
}
