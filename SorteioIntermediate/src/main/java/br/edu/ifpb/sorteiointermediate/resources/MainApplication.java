/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.resources;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;




/**
 *
 * @author Luciano
 */
public class MainApplication extends Application{
    
    @Override
    public Restlet createInboundRoot(){
        Router router = new Router();
       
        router.attach("/all", EstatisticaResourceMaiorAllSorteios.class);
        
        return router;
        
    }
    
}
