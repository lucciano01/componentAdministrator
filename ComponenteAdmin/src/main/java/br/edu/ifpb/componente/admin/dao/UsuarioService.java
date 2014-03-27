/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.componente.admin.dao;

import br.edu.ifpb.componenteadmin.entidade.Usuario;



/**
 *
 * @author Luciano
 */
public interface UsuarioService {
    

	public Usuario getUsuarioPorTif(String tif);

	public void saveUsuario(Usuario usuario);

	public void updateUsuario(Usuario usuario, Long id);

	public void removeUsuario(Long id);

	
    
}
