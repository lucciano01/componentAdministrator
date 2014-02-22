/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetoposartigo.resource;

import br.edu.ifpb.projetoposartigo.dao.UsuarioDAO;
import br.edu.ifpb.projetoposartigo.entidades.Usuario;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Luciano
 */
public class AllUsuarioResource extends ServerResource {
    
    @Get
    public JsonRepresentation getAllUsuarios(){
        
        JsonResult result = new JsonResult();
        JSONObject json = new JSONObject();
        Gson gson = new Gson();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            usuarios = usuarioDAO.getUsuarios();
            String lista = gson.toJson(usuarios);
            json.put("lista", lista);
            result.setData(json);
            result.setSuccess(true);
            result.setMessage("Lista de todos usuarios!");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllUsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AllUsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(AllUsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return new JsonRepresentation(result);
    }
    
}
