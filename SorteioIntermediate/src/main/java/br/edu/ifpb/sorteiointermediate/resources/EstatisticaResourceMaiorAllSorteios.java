/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.resources;

import br.edu.ifpb.sorteiointermediate.entidades.Estatistica;
import br.edu.ifpb.sorteiointermediate.manager.FrequencyManager;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;


/**
 *
 * @author Luciano
 */

public class EstatisticaResourceMaiorAllSorteios extends ServerResource  {
  
    @Get
    @Produces(MediaType.TEXT_XML)
    @Path("/all")
    public Estatistica getEstatisticaMaiorAllSorteios() throws ClassNotFoundException, SQLException, JAXBException{
        FrequencyManager frequencyManager = new FrequencyManager();
        List<Integer> resultado = frequencyManager.getMaiorFrequenciaAllSorteios();
        Estatistica estatistica = new Estatistica();
        estatistica.setNumero(resultado.get(0));
        estatistica.setQtdeOcorrencias(resultado.get(1));
        //System.out.println(estatistica.toString());
//        JAXBContext ctx = JAXBContext.newInstance(Estatistica.class);
//        Marshaller marshaller = ctx.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return estatistica;
    }
    
}
