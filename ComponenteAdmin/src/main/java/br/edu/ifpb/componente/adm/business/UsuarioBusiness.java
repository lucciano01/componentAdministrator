/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.componente.adm.business;

import br.edu.ifpb.componente.admin.dao.UsuarioDAO;
import br.edu.ifpb.componenteadmin.entidade.Usuario;
import java.sql.SQLException;


/**
 *
 * @author Luciano
 */
public class UsuarioBusiness {
         
    
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
        
    public UsuarioBusiness(){
       
    }
    public void save(Usuario u) throws SQLException, ClassNotFoundException{
       usuarioDAO.save(u);
    }
   
}
