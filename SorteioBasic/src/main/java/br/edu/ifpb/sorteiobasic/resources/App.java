/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiobasic.resources;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 *
 * @author Luciano
 */
public class App {
    public static void main(String[] args) throws Exception {
        
        Component component = new Component();
        component.getServers().add(Protocol.HTTP , 9090);
        component.getDefaultHost().attach("/SorteioService", new MainApplication());
        component.start();
    }
}
