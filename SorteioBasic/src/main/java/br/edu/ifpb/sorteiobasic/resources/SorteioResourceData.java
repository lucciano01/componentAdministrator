/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiobasic.resources;

import br.edu.ifpb.sorteiobasic.entidades.Sorteio;
import br.edu.ifpb.sorteiobasic.sorteiodao.SorteioDAO;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.text.ParseException;
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
public class SorteioResourceData extends ServerResource {
    
    @Get("/data/{data}")
    public JSONObject getSorteioByData(){
        
        JSONObject json = new JSONObject();
        
        String data = (String)getRequestAttributes().get("data");
        
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Sorteio> sorteios = new ArrayList<Sorteio>();
        try {
           
            sorteios = sorteioDAO.getSorteioByData(data);
            Gson gson = new Gson();
            String lista  = gson.toJson(sorteios);
            json.put("lista", lista);
            
            
        } catch (JSONException ex) {
            Logger.getLogger(SorteioResourceData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SorteioResourceData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SorteioResourceData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SorteioResourceData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return json;
        
    }
    
}
