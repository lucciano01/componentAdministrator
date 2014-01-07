/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiobasic.resources;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * @author Luciano
 */
public class MainApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
         Router router = new Router();
        
        //gerar sorteio 
        router.attach("/sorteio", CreateSorteioResource.class);
        //recuperar todos os sorteios
        router.attach("/sorteios", SorteioResourceAll.class);
        //router.attach("/getSorteio/{id}", CreateSorteioResource.class);
        router.attach("/getSorteio/{id}", CreateSorteioResource.class);
        //recuperar sorteio por faixa de codigo
        router.attach("/getSorteioFaixa/{idInicial}/{idFinal}", SorteioResourceCodeInterval.class);
        //recuperar sorteio por data
        router.attach("/getSorteioData/{data}", SorteioResourceData.class);
        //recuperar sorteio por periodo
        router.attach("/getSorteioPeriodo/{dtInicial}/{dtFinal}", SorteioResourceDataInterval.class);
        
        return router;
    }
    
    
    
    
   
}
