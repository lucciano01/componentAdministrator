/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetoposartigo.resource;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Luciano
 */
public class JsonResult extends JSONObject{
    
    public void setData(JSONObject json){
        try {
            put("json", json);
        } catch (JSONException ex) {
            Logger.getLogger(JsonResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setSuccess(boolean s){
        try {
            put("success" ,s);
        } catch (JSONException ex) {
            Logger.getLogger(JsonResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setMessage(String msg){
        try {
            put("message" , msg);
        } catch (JSONException ex) {
            Logger.getLogger(JsonResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
