package br.edu.ifpb.businessservice;

import be.edu.ifpb.businessservice.sorteio.GerarSorteio;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
       
        GerarSorteio gerarSorteio = new GerarSorteio();
        
        
        List<Integer> aux = new ArrayList<Integer>();
        aux = gerarSorteio.numerosSorteados();
        System.out.println(aux);
        
    }
}
