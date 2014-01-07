
import br.edu.ifpb.sorteiobasic.entidades.Sorteio;
import br.edu.ifpb.sorteiobasic.sorteiodao.SorteioDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luciano
 */
public class App {
    public static void main(String[] args) {
        
        SorteioDAO sorteioDAO = new SorteioDAO();
        //Sorteio sorteio = new Sorteio();
        
        //System.out.println(sorteio.numerosSorteados());
      
        //Sorteio sorteio = new Sorteio();
        
        try {
            List<Sorteio> sorteios = sorteioDAO.getSorteiosPorIntervaloDeCOdigo(12,16);
            for (Sorteio sort : sorteios) {
                System.out.println(sort);
            }
//            Sorteio sorteio = sorteioDAO.getSorteioPorCodigo(18);
//            System.out.println(sorteio.toString());
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
