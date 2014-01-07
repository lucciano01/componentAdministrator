/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.util;

import br.edu.ifpb.sorteiointermediate.entidades.Estatistica;
import br.edu.ifpb.sorteiointermediate.estatiscadao.EstatiscaDAO;
import br.edu.ifpb.sorteiointermediate.manager.FrequencyManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Luciano
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, ClassNotFoundException, SQLException, ParseException, JAXBException {
        
//        FrequencyManager frequencyManager = new FrequencyManager();
//        List<Integer> numeros = new ArrayList<Integer>();
//        
//        numeros = frequencyManager.getMaiorFrequenciaPorIntervaloData("2013-11-05","2013-12-10");
//        
//        for (Integer num : numeros) {
//            System.out.println(num);
//        }
        FrequencyManager frequencyManager = new FrequencyManager();
        List<Integer> frequencia= frequencyManager.getMaiorFrequenciaAllSorteios();
       // EstatiscaDAO estatisticaDAO = new EstatiscaDAO();
        Estatistica estatisca = new Estatistica();
        estatisca.setId(1);
        estatisca.setNumero(frequencia.get(0));
        estatisca.setQtdeOcorrencias(frequencia.get(1));
        estatisca.setTipoConsulta("maior frequencia todos os sorteios");
        
        
        JAXBContext ctx = JAXBContext.newInstance(Estatistica.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(estatisca, System.out);
        
    }
}
