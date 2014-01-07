/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.sorteiodao;

import br.edu.ifpb.sorteiointermediate.connection.ConnectionPostgresql;
import br.edu.ifpb.sorteiointermediate.entidades.Sorteio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class SorteioDAO {
    
      ConnectionPostgresql connection = new ConnectionPostgresql();
    
    
    public List<Integer> getAllSorteios() throws ClassNotFoundException, SQLException{
        Connection con = connection.getConnection();
        List<Integer> numeros = new ArrayList();
        String sql = ("select num1,num2,num3,num4,num5,num6 from sorteio");
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            numeros.add(rs.getInt("num1"));
            numeros.add(rs.getInt("num2"));
            numeros.add(rs.getInt("num3"));
            numeros.add(rs.getInt("num4"));
            numeros.add(rs.getInt("num5"));
            numeros.add(rs.getInt("num6"));
        }
        rs.close();
        ps.close();
        con.close();
        return numeros;
    }
    
    public List<Integer> getSorteioByData(String data) throws ClassNotFoundException, SQLException, ParseException{
        Connection con = connection.getConnection();
        List<Integer> numeros = new ArrayList();
        String sql = ("select num1,num2,num3,num4,num5,num6 from sorteio where data_sorteio = ?");
        PreparedStatement ps = con.prepareStatement(sql);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dt = new java.sql.Date(format.parse(data).getTime());
        ps.setDate(1, dt);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            numeros.add(rs.getInt("num1"));
            numeros.add(rs.getInt("num2"));
            numeros.add(rs.getInt("num3"));
            numeros.add(rs.getInt("num4"));
            numeros.add(rs.getInt("num5"));
            numeros.add(rs.getInt("num6"));
           }
        rs.close();
        ps.close();
        con.close();
        return numeros;
        
    }
    public List<Integer> getSorteioPorPeriodo(String dataInicial, String dataFinal) throws ClassNotFoundException, SQLException, ParseException{
        List<Integer> numeros = new ArrayList();
        Connection con = connection.getConnection();
        String sql = ("select num1,num2,num3,num4,num5,num6 from sorteio where data_sorteio between ? and ?");
        PreparedStatement ps = con.prepareStatement(sql);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dtInicial = new java.sql.Date(format.parse(dataInicial).getTime());
        java.sql.Date dtFinal = new java.sql.Date(format.parse(dataFinal).getTime());
        ps.setDate(1, dtInicial);
        ps.setDate(2, dtFinal);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            numeros.add(rs.getInt("num1"));
            numeros.add(rs.getInt("num2"));
            numeros.add(rs.getInt("num3"));
            numeros.add(rs.getInt("num4"));
            numeros.add(rs.getInt("num5"));
            numeros.add(rs.getInt("num6"));
        }
        rs.close();
        ps.close();
        con.close();
        return numeros;
    }
    
    
    public List<Integer> getSorteiosPorIntervaloDeCOdigo(int codigoInicial, int codigoFinal) throws ClassNotFoundException, SQLException{
        List<Integer> numeros = new ArrayList();
        Connection con = connection.getConnection();
        String sql = ("select num1,num2,num3,num4,num5,num6 from sorteio where id between ? and ?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codigoInicial);
        ps.setInt(2, codigoFinal);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            numeros.add(rs.getInt("num1"));
            numeros.add(rs.getInt("num2"));
            numeros.add(rs.getInt("num3"));
            numeros.add(rs.getInt("num4"));
            numeros.add(rs.getInt("num5"));
            numeros.add(rs.getInt("num6"));
        }
        rs.close();
        ps.close();
        con.close();
        return numeros;
    }
    
}
