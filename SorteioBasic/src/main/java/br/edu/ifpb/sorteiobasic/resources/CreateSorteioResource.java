/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiobasic.resources;

import br.edu.ifpb.sorteiobasic.entidades.Sorteio;
import br.edu.ifpb.sorteiobasic.sorteiodao.SorteioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;


/**
 *
 * @author Luciano
 */
public class CreateSorteioResource extends ServerResource {
    
    @Post("/sorteio")
    public void createSorteio(){
        
        JSONObject json = new JSONObject();
        try {
            /*int id   = json.getInt("id");
            int num1 = json.getInt("num1");
            int num2 = json.getInt("num2");
            int num3 = json.getInt("num3");
            int num4 = json.getInt("num4");
            int num5 = json.getInt("num5");
            int num6 = json.getInt("num6");
            
            sorteio.setDataSorteio(new java.sql.Date(System.currentTimeMillis()));
            //sorteio.setId(id);
            sorteio.setNum1(num1);
            sorteio.setNum2(num2);
            sorteio.setNum3(num3);
            sorteio.setNum4(num4);
            sorteio.setNum5(num5);
            sorteio.setNum6(num6);
           */ 
            SorteioDAO sorteioDAO = new SorteioDAO();
            //sorteioDAO.addSorteio(sorteio);
            sorteioDAO.addSorteio();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateSorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateSorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
       // return null;
       
    }
    
    @Get
    public JSONObject getSorteioByCodigo(){
        
        JSONObject json = new JSONObject();
        
        int id = Integer.parseInt((String)getRequestAttributes().get("id"));
        
        SorteioDAO sorteioDAO = new SorteioDAO();
        Sorteio sorteio = new Sorteio();
        try {
            //System.out.println("passou");      
            sorteio = sorteioDAO.getSorteioPorCodigo(id);
            json.put("id", sorteio.getId());
            json.put("data", sorteio.getDataSorteio());
            json.put("num1", sorteio.getNum1());
            json.put("num2", sorteio.getNum2());
            json.put("num3", sorteio.getNum3());
            json.put("num4", sorteio.getNum4());
            json.put("num5", sorteio.getNum5());
            json.put("num6", sorteio.getNum6());
            
        } catch (JSONException ex) {
            Logger.getLogger(CreateSorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateSorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateSorteioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return json;
        
    }
    
}
