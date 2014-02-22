/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetoposartigo.resource;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * @author Luciano
 */
public class MainApplication extends Application {
    
   
    
    @Override
    public Restlet createInboundRoot(){
        Router router = new Router();
        
        //recupera usuario pelo id
        router.attach("/getusuario/{id}", UsuarioResource.class);
        
        //grava usuario
        router.attach("/insertusuario/{nome}/{cpf}/{idade}", UsuarioResource.class);
        
        //remover usuario
        router.attach("/remove/{id}", UsuarioResource.class);
        
        //update usuario
        router.attach("/update/{id}/{nome}/{cpf}/{idade}", UsuarioResource.class);
        
        //recuperar todos os usuarios
        router.attach("/getall", AllUsuarioResource.class);
        
        return router;
    }
     
    
}
