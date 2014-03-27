/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.componente.adm.soap;

import br.edu.ifpb.componenteadmin.entidade.Usuario;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Luciano
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserComponent {
    
    @WebMethod
    void saveUsuario(Usuario u);
    
}
