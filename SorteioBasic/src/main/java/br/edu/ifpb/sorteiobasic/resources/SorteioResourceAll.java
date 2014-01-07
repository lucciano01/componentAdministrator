/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiobasic.resources;

import br.edu.ifpb.sorteiobasic.entidades.Sorteio;
import br.edu.ifpb.sorteiobasic.sorteiodao.SorteioDAO;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Luciano
 */
public class SorteioResourceAll extends ServerResource {
    
    @Get("/sorteios")
    public JSONObject getSorteios(){
        
        List<Sorteio> sorteios = new ArrayList<Sorteio>();
        SorteioDAO sorteioDAO = new SorteioDAO();
        JSONObject json = new JSONObject();
        try {
            
            sorteios = sorteioDAO.getAllSorteios();
            Gson gson = new Gson();
            String lista = gson.toJson(sorteios);
            json.put("lista", lista);
            
            
        } catch (JSONException ex) {
            Logger.getLogger(SorteioResourceAll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SorteioResourceAll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SorteioResourceAll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
        
    }
}
