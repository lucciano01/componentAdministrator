/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetoposartigo.resource;

import br.edu.ifpb.projetoposartigo.dao.UsuarioDAO;
import br.edu.ifpb.projetoposartigo.entidades.Usuario;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Luciano
 */
public class UsuarioResource extends ServerResource {
    
    @Post
    public JsonRepresentation addUser(){
        
            JsonResult result = new JsonResult();
           
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario  = new Usuario();
           
        
        try {
            
            
            String nome = (String) getRequestAttributes().get("nome");
            String cpf = (String) getRequestAttributes().get("cpf");
            String age = (String)getRequestAttributes().get("idade");
            
            Integer idade = Integer.parseInt(age);
            
            usuario.setNome(nome);
            usuario.setCpf(cpf);
            usuario.setIdade(idade);
            
            
            
            usuarioDAO.addUsuario(usuario);
            result.setMessage("Usuário cadastrado com sucesso!");
            result.setSuccess(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new JsonRepresentation(result);
        
    }
    
    @Get
    public JsonRepresentation getUserById() throws JSONException{
        
        JsonResult result = new JsonResult();
        JSONObject json = new JSONObject();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario  = new Usuario();
        Gson gson = new Gson();
        
        int id = Integer.parseInt((String)getRequestAttributes().get("id"));
        try {
            usuario = usuarioDAO.getUsuarioById(id);
            String u = gson.toJson(usuario);
            
            json.put("usuario", u);
            result.setData(json);
            result.setSuccess(true);
            result.setMessage("Usuário recuperado com sucesso!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new JsonRepresentation(result);
    }
    
    @Delete
    public JsonRepresentation removeUser(){
        
       JsonResult result = new JsonResult();
        
        int id = Integer.parseInt((String)getRequestAttributes().get("id"));
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.removeUsuario(id);
            result.setMessage("Usuario removido com sucesso!");
            result.setSuccess(true);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new JsonRepresentation(result);
    }
    
    @Put
    public JsonRepresentation updateUsuario(){
         JsonResult result = new JsonResult();
       
        try {
            
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario  = new Usuario();
               
                String cod = (String) getRequestAttributes().get("id");
                String nome = (String) getRequestAttributes().get("nome");
                String cpf = (String) getRequestAttributes().get("cpf");
                String age = (String)getRequestAttributes().get("idade");
                
                Integer idade = Integer.parseInt(age);
                Integer id = Integer.parseInt(cod);
                
                usuario = usuarioDAO.getUsuarioById(id);
                
                usuario.setNome(nome);
                usuario.setCpf(cpf);
                usuario.setIdade(idade);
                usuarioDAO.updateUsuario(usuario, id);
                result.setMessage("Usuario alterado com sucesso!");
                result.setSuccess(true);
                       
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return new JsonRepresentation(result);
    }
    
}
