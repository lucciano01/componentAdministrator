/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiobasic.sorteiodao;

import br.edu.ifpb.sorteiobasic.connection.ConnectionPostgresql;
import br.edu.ifpb.sorteiobasic.entidades.Sorteio;
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
    
    public boolean addSorteio() throws ClassNotFoundException, SQLException{
        Connection con = connection.getConnection();
        String sql = ("insert into sorteio(num1,num2,num3,num4,num5,num6,data_sorteio)values(?,?,?,?,?,?,?)");
        Sorteio sorteio = new Sorteio();
        java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
        List<Integer> numeros = sorteio.numerosSorteados();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, numeros.get(0));
        ps.setInt(2, numeros.get(1));
        ps.setInt(3, numeros.get(2));
        ps.setInt(4, numeros.get(3));
        ps.setInt(5, numeros.get(4));
        ps.setInt(6, numeros.get(5));
        ps.setDate(7, data);
        ps.execute();
        ps.close();
        con.close();
        return true;
    }
    public void addSorteio(Sorteio sorteio) throws ClassNotFoundException, SQLException{
        Connection con = connection.getConnection();
        String sql = ("insert into sorteio(data_sorteio,num1,num2,num3,num4,num5,num6)values(?,?,?,?,?,?,?)");
        PreparedStatement ps = con.prepareStatement(sql);
        java.sql.Date data = new Date(System.currentTimeMillis());
        ps.setDate(1, data);
        ps.setInt(2, sorteio.getNum1());
        ps.setInt(3, sorteio.getNum2());
        ps.setInt(4, sorteio.getNum3());
        ps.setInt(5, sorteio.getNum4());
        ps.setInt(6, sorteio.getNum5());
        ps.setInt(7, sorteio.getNum6());
        ps.execute();
        ps.close();
        con.close();
    }
    
    public List<Sorteio> getAllSorteios() throws ClassNotFoundException, SQLException{
        Connection con = connection.getConnection();
        List<Sorteio> sorteios = new ArrayList();
        Sorteio sorteio = null;
        String sql = ("select * from sorteio");
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            sorteio = new Sorteio();
            sorteio.setId(rs.getInt("id"));
            sorteio.setDataSorteio(rs.getDate("data_sorteio"));
            sorteio.setNum1(rs.getInt("num1"));
            sorteio.setNum2(rs.getInt("num2"));
            sorteio.setNum3(rs.getInt("num3"));
            sorteio.setNum4(rs.getInt("num4"));
            sorteio.setNum5(rs.getInt("num5"));
            sorteio.setNum6(rs.getInt("num6"));
            sorteios.add(sorteio);
        }
        rs.close();
        ps.close();
        con.close();
        return sorteios;
    }
    
    public List<Sorteio> getSorteioByData(String data) throws ClassNotFoundException, SQLException, ParseException{
        Connection con = connection.getConnection();
        List<Sorteio> sorteios = new ArrayList();
        Sorteio sorteio = null;
        String sql = ("select * from sorteio where data_sorteio = ?");
        PreparedStatement ps = con.prepareStatement(sql);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dt = new java.sql.Date(format.parse(data).getTime());
        ps.setDate(1, dt);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            sorteio = new Sorteio();
            sorteio.setId(rs.getInt("id"));
            sorteio.setDataSorteio(rs.getDate("data_sorteio"));
            sorteio.setNum1(rs.getInt("num1"));
            sorteio.setNum2(rs.getInt("num2"));
            sorteio.setNum3(rs.getInt("num3"));
            sorteio.setNum4(rs.getInt("num4"));
            sorteio.setNum5(rs.getInt("num5"));
            sorteio.setNum6(rs.getInt("num6"));
            sorteios.add(sorteio);
           }
        rs.close();
        ps.close();
        con.close();
        return sorteios;
        
    }
    public List<Sorteio> getSorteioPorPeriodo(String dataInicial, String dataFinal) throws ClassNotFoundException, SQLException, ParseException{
        Sorteio sorteio = null;
        List<Sorteio> sorteios = new ArrayList<Sorteio>();
        Connection con = connection.getConnection();
        String sql = ("select * from sorteio where data_sorteio between ? and ?");
        PreparedStatement ps = con.prepareStatement(sql);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dtInicial = new java.sql.Date(format.parse(dataInicial).getTime());
        java.sql.Date dtFinal = new java.sql.Date(format.parse(dataFinal).getTime());
        ps.setDate(1, dtInicial);
        ps.setDate(2, dtFinal);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            sorteio = new Sorteio();
            sorteio.setId(rs.getInt("id"));
            sorteio.setDataSorteio(rs.getDate("data_sorteio"));
            sorteio.setNum1(rs.getInt("num1"));
            sorteio.setNum2(rs.getInt("num2"));
            sorteio.setNum3(rs.getInt("num3"));
            sorteio.setNum4(rs.getInt("num4"));
            sorteio.setNum5(rs.getInt("num5"));
            sorteio.setNum6(rs.getInt("num6"));
            sorteios.add(sorteio);
        }
        rs.close();
        ps.close();
        con.close();
        return sorteios;
    }
    
    public Sorteio getSorteioPorCodigo(int codigo) throws ClassNotFoundException, SQLException{
        Connection con = connection.getConnection();
        Sorteio sorteio = null;
        String sql = ("select * from sorteio where id = ?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            sorteio = new Sorteio();
            sorteio.setId(rs.getInt("id"));
            sorteio.setDataSorteio(rs.getDate("data_sorteio"));
            sorteio.setNum1(rs.getInt("num1"));
            sorteio.setNum2(rs.getInt("num2"));
            sorteio.setNum3(rs.getInt("num3"));
            sorteio.setNum4(rs.getInt("num4"));
            sorteio.setNum5(rs.getInt("num5"));
            sorteio.setNum6(rs.getInt("num6"));
        }
            return sorteio;
    }
    public List<Sorteio> getSorteiosPorIntervaloDeCOdigo(int codigoInicial, int codigoFinal) throws ClassNotFoundException, SQLException{
        List<Sorteio> sorteios = new ArrayList();
        Sorteio sorteio = null;
        Connection con = connection.getConnection();
        String sql = ("select * from sorteio where id between ? and ?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codigoInicial);
        ps.setInt(2, codigoFinal);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            sorteio = new Sorteio();
            sorteio.setId(rs.getInt("id"));
            sorteio.setDataSorteio(rs.getDate("data_sorteio"));
            sorteio.setNum1(rs.getInt("num1"));
            sorteio.setNum2(rs.getInt("num2"));
            sorteio.setNum3(rs.getInt("num3"));
            sorteio.setNum4(rs.getInt("num4"));
            sorteio.setNum5(rs.getInt("num5"));
            sorteio.setNum6(rs.getInt("num6"));
            sorteios.add(sorteio);
        }
        rs.close();
        ps.close();
        con.close();
        return sorteios;
    }
    
}
