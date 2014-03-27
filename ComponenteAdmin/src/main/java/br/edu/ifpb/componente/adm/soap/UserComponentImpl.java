/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.componente.adm.soap;

import br.edu.ifpb.componente.admin.dao.UsuarioDAO;
import br.edu.ifpb.componenteadmin.entidade.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 *
 * @author Luciano
 */
@WebService(endpointInterface = "br.edu.ifpb.componente.adm.soap.UserComponent")
public class UserComponentImpl implements UserComponent{
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    public void saveUsuario(Usuario u) {
        try {
            usuarioDAO.save(u);
        } catch (SQLException ex) {
            Logger.getLogger(UserComponentImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserComponentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
