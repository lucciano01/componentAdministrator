/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.edu.ifpb.businessservice.sorteio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Luciano
 */
public class GerarSorteio  {
    
   
   private TreeSet<Integer> numeros = new TreeSet<Integer>();
    
    public List<Integer> numerosSorteados() {
        int j=1;
        while(j<6){
            int i = (int)(1+Math.random()*59);
             numeros.add(i);
             j++;
         }
         List<Integer> numerosGerados = new ArrayList<Integer>(numeros);
         return numerosGerados;
       } 
       
   
   
    
}
