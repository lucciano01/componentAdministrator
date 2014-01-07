/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.manager;

import br.edu.ifpb.sorteiointermediate.entidades.Estatistica;
import br.edu.ifpb.sorteiointermediate.estatiscadao.EstatiscaDAO;
import br.edu.ifpb.sorteiointermediate.sorteiodao.SorteioDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class FrequencyManager {
     EstatiscaDAO estatisticaDAO = new EstatiscaDAO();
     Estatistica estatisca = new Estatistica();
     SorteioDAO sorteioDAO = new SorteioDAO();
     
    public List<Integer> getMaiorFrequenciaAllSorteios() throws ClassNotFoundException,  SQLException{
        
        List<Integer> numerosSorteados = sorteioDAO.getAllSorteios();
        List<Integer> resultado = new ArrayList<Integer>();
       
        
        
        int numeroMaisSorteado = numerosSorteados.get(0);
        int frequenciaDoNumeroMaisSorteado = Collections.frequency(numerosSorteados, numeroMaisSorteado);
        
        for(int i = 1;  i < numerosSorteados.size(); i++){
            int numeroSorteadoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisSorteadoAux = Collections.frequency(numerosSorteados, numeroSorteadoAux);
            
            if(frequenciaDoNumeroMaisSorteadoAux > frequenciaDoNumeroMaisSorteado){
                frequenciaDoNumeroMaisSorteado = frequenciaDoNumeroMaisSorteadoAux;
                numeroMaisSorteado = numeroSorteadoAux;
               }
          }
        resultado.add(numeroMaisSorteado);
        resultado.add(frequenciaDoNumeroMaisSorteado);
        estatisca.setNumero(numeroMaisSorteado);
        estatisca.setQtdeOcorrencias(frequenciaDoNumeroMaisSorteado);
        estatisca.setTipoConsulta("maior frequencia todos os sorteios");
        estatisticaDAO.addEstatistica(estatisca);
        return resultado;
    }
    
    
    
    public List<Integer> getMaiorFrequenciPorIntervaloDeCodigo(int codInicial, int codFinal) throws ClassNotFoundException, SQLException{
       
        List<Integer> numerosSorteados = sorteioDAO.getSorteiosPorIntervaloDeCOdigo(codInicial, codFinal);
        List<Integer> resultado = new ArrayList<Integer>();
         int numeroMaisSorteado = numerosSorteados.get(0);
        int frequenciaDoNumeroMaisSorteado = Collections.frequency(numerosSorteados, numeroMaisSorteado);
        
        for(int i = 1;  i < numerosSorteados.size(); i++){
            int numeroSorteadoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisSorteadoAux = Collections.frequency(numerosSorteados, numeroSorteadoAux);
            
            if(frequenciaDoNumeroMaisSorteadoAux > frequenciaDoNumeroMaisSorteado){
                frequenciaDoNumeroMaisSorteado = frequenciaDoNumeroMaisSorteadoAux;
                numeroMaisSorteado = numeroSorteadoAux;
               }
          }
        resultado.add(numeroMaisSorteado);
        resultado.add(frequenciaDoNumeroMaisSorteado);
        estatisca.setNumero(numeroMaisSorteado);
        estatisca.setQtdeOcorrencias(frequenciaDoNumeroMaisSorteado);
        estatisca.setTipoConsulta("maior frequencia por intervalo de codigo");
        estatisticaDAO.addEstatistica(estatisca);
        return resultado;
       }
    
     public List<Integer> getMaiorFrequenciPorData(String data) throws ClassNotFoundException, SQLException, ParseException{
       
        List<Integer> numerosSorteados = sorteioDAO.getSorteioByData(data);
        List<Integer> resultado = new ArrayList<Integer>();
         int numeroMaisSorteado = numerosSorteados.get(0);
        int frequenciaDoNumeroMaisSorteado = Collections.frequency(numerosSorteados, numeroMaisSorteado);
        
        for(int i = 1;  i < numerosSorteados.size(); i++){
            int numeroSorteadoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisSorteadoAux = Collections.frequency(numerosSorteados, numeroSorteadoAux);
            
            if(frequenciaDoNumeroMaisSorteadoAux > frequenciaDoNumeroMaisSorteado){
                frequenciaDoNumeroMaisSorteado = frequenciaDoNumeroMaisSorteadoAux;
                numeroMaisSorteado = numeroSorteadoAux;
               }
          }
        resultado.add(numeroMaisSorteado);
        resultado.add(frequenciaDoNumeroMaisSorteado);
        estatisca.setNumero(numeroMaisSorteado);
        estatisca.setQtdeOcorrencias(frequenciaDoNumeroMaisSorteado);
        estatisca.setTipoConsulta("maior frequencia por data de sorteio");
        estatisticaDAO.addEstatistica(estatisca);
        return resultado;
       }
     
  public List<Integer> getMaiorFrequenciaPorIntervaloData(String dataIncial, String dataFinal) throws ClassNotFoundException, SQLException, ParseException{
       
        List<Integer> numerosSorteados = sorteioDAO.getSorteioPorPeriodo(dataIncial, dataFinal);
        List<Integer> resultado = new ArrayList<Integer>();
         int numeroMaisSorteado = numerosSorteados.get(0);
        int frequenciaDoNumeroMaisSorteado = Collections.frequency(numerosSorteados, numeroMaisSorteado);
        
        for(int i = 1;  i < numerosSorteados.size(); i++){
            int numeroSorteadoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisSorteadoAux = Collections.frequency(numerosSorteados, numeroSorteadoAux);
            
            if(frequenciaDoNumeroMaisSorteadoAux > frequenciaDoNumeroMaisSorteado){
                frequenciaDoNumeroMaisSorteado = frequenciaDoNumeroMaisSorteadoAux;
                numeroMaisSorteado = numeroSorteadoAux;
               }
          }
        resultado.add(numeroMaisSorteado);
        resultado.add(frequenciaDoNumeroMaisSorteado);
        estatisca.setNumero(numeroMaisSorteado);
        estatisca.setQtdeOcorrencias(frequenciaDoNumeroMaisSorteado);
        estatisca.setTipoConsulta("maior frequencia por intervalo de data de sorteio");
        estatisticaDAO.addEstatistica(estatisca);
        return resultado;
       }
  
  public List<Integer> getMenorFrequenciaAllSorteios() throws ClassNotFoundException,  SQLException{
       
        List<Integer> numerosSorteados = sorteioDAO.getAllSorteios();
        List<Integer> resultado = new ArrayList<Integer>();
        estatisticaDAO = new EstatiscaDAO();
        estatisca = new Estatistica();
        
        int numeroMenosSorteado = numerosSorteados.get(0);
        int frequenciaDoNumeroMaisSorteado = Collections.frequency(numerosSorteados, numeroMenosSorteado);
        
        for(int i = 1;  i < numerosSorteados.size(); i++){
            int numeroSorteadoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMenosSorteadoAux = Collections.frequency(numerosSorteados, numeroSorteadoAux);
            
            if(frequenciaDoNumeroMenosSorteadoAux < frequenciaDoNumeroMaisSorteado){
                frequenciaDoNumeroMaisSorteado = frequenciaDoNumeroMenosSorteadoAux;
                numeroMenosSorteado = numeroSorteadoAux;
               }
          }
        resultado.add(numeroMenosSorteado);
        resultado.add(frequenciaDoNumeroMaisSorteado);
        
        estatisca.setNumero(numeroMenosSorteado);
        estatisca.setQtdeOcorrencias(frequenciaDoNumeroMaisSorteado);
        estatisca.setTipoConsulta("menor frequencia todos os sorteios");
        estatisticaDAO.addEstatistica(estatisca);
        return resultado;
    }
      
 public List<Integer> getMenorFrequenciPorIntervaloDeCodigo(int codInicial, int codFinal) throws ClassNotFoundException, SQLException{
       
        List<Integer> numerosSorteados = sorteioDAO.getSorteiosPorIntervaloDeCOdigo(codInicial, codFinal);
        List<Integer> resultado = new ArrayList<Integer>();
         int numeroMenosSorteado = numerosSorteados.get(0);
        int frequenciaDoNumeroMenosSorteado = Collections.frequency(numerosSorteados, numeroMenosSorteado);
        
        for(int i = 1;  i < numerosSorteados.size(); i++){
            int numeroSorteadoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMenosSorteadoAux = Collections.frequency(numerosSorteados, numeroSorteadoAux);
            
            if(frequenciaDoNumeroMenosSorteadoAux < frequenciaDoNumeroMenosSorteado){
                frequenciaDoNumeroMenosSorteado = frequenciaDoNumeroMenosSorteadoAux;
                numeroMenosSorteado = numeroSorteadoAux;
               }
          }
        resultado.add(numeroMenosSorteado);
        resultado.add(frequenciaDoNumeroMenosSorteado);
        estatisca.setNumero(numeroMenosSorteado);
        estatisca.setQtdeOcorrencias(frequenciaDoNumeroMenosSorteado);
        estatisca.setTipoConsulta("menor frequencia por intervalo de codigo");
        estatisticaDAO.addEstatistica(estatisca);
        return resultado;
       }
       
  public List<Integer> getMenorFrequenciPorData(String data) throws ClassNotFoundException, SQLException, ParseException{
       
        List<Integer> numerosSorteados = sorteioDAO.getSorteioByData(data);
        List<Integer> resultado = new ArrayList<Integer>();
         int numeroMenosSorteado = numerosSorteados.get(0);
        int frequenciaDoNumeroMenosSorteado = Collections.frequency(numerosSorteados, numeroMenosSorteado);
        
        for(int i = 1;  i < numerosSorteados.size(); i++){
            int numeroSorteadoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisSorteadoAux = Collections.frequency(numerosSorteados, numeroSorteadoAux);
            
            if(frequenciaDoNumeroMaisSorteadoAux < frequenciaDoNumeroMenosSorteado){
                frequenciaDoNumeroMenosSorteado = frequenciaDoNumeroMaisSorteadoAux;
                numeroMenosSorteado = numeroSorteadoAux;
               }
          }
        resultado.add(numeroMenosSorteado);
        resultado.add(frequenciaDoNumeroMenosSorteado);
        estatisca.setNumero(numeroMenosSorteado);
        estatisca.setQtdeOcorrencias(frequenciaDoNumeroMenosSorteado);
        estatisca.setTipoConsulta("menor frequencia por data de sorteio");
        estatisticaDAO.addEstatistica(estatisca);
        return resultado;
       }
  
  public List<Integer> getMenorFrequenciaPorIntervaloData(String dataIncial, String dataFinal) throws ClassNotFoundException, SQLException, ParseException{
       
        List<Integer> numerosSorteados = sorteioDAO.getSorteioPorPeriodo(dataIncial, dataFinal);
        List<Integer> resultado = new ArrayList<Integer>();
         int numeroMenosSorteado = numerosSorteados.get(0);
        int frequenciaDoNumeroMenosSorteado = Collections.frequency(numerosSorteados, numeroMenosSorteado);
        
        for(int i = 1;  i < numerosSorteados.size(); i++){
            int numeroSorteadoAux = numerosSorteados.get(i);
            int frequenciaDoNumeroMaisSorteadoAux = Collections.frequency(numerosSorteados, numeroSorteadoAux);
            
            if(frequenciaDoNumeroMaisSorteadoAux < frequenciaDoNumeroMenosSorteado){
                frequenciaDoNumeroMenosSorteado = frequenciaDoNumeroMaisSorteadoAux;
                numeroMenosSorteado = numeroSorteadoAux;
               }
          }
        resultado.add(numeroMenosSorteado);
        resultado.add(frequenciaDoNumeroMenosSorteado);
        estatisca.setNumero(numeroMenosSorteado);
        estatisca.setQtdeOcorrencias(frequenciaDoNumeroMenosSorteado);
        estatisca.setTipoConsulta("menor frequencia por intervalo de data de sorteio");
        estatisticaDAO.addEstatistica(estatisca);
        return resultado;
       }
    
}
