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
public class SorteioResourceDataInterval extends ServerResource {
    
    @Get("/getSorteioPeriodo/{dtInicial}/{dtFinal}")
    public JSONObject getSorteioByDataInterval(){
        
        String dataInicial = (String) getRequestAttributes().get("dtInicial");
        String dataFinal   = (String) getRequestAttributes().get("dtFinal");
        
        SorteioDAO sorteioDAO = new SorteioDAO();
        List<Sorteio> sorteios = new ArrayList<Sorteio>();
        JSONObject json = new JSONObject();
        try {
            
            sorteios = sorteioDAO.getSorteioPorPeriodo(dataInicial, dataFinal);
            Gson gson = new Gson();
            String lista = gson.toJson(sorteios);
            json.put("sorteios", lista);
            
            
        } catch (JSONException ex) {
            Logger.getLogger(SorteioResourceDataInterval.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SorteioResourceDataInterval.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SorteioResourceDataInterval.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SorteioResourceDataInterval.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return json;
    }
    
}
