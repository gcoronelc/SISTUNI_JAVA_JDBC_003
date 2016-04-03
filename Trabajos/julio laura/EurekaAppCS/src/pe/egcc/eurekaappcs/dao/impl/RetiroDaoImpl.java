/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.eurekaappcs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.eurekaappcs.dao.espec.RetiroDaoEspec;
import pe.egcc.eurekaappcs.db.AccesoDB;

/**
 *
 * @author julu
 */
public class RetiroDaoImpl implements RetiroDaoEspec{

    @Override
    public void procRetiro(String cuenta, double importe, String clave, String codEmp) {
    Connection cn = null;
    try{
    cn = AccesoDB.getConnection();
    cn.setAutoCommit(false);
    String sql = "update cuenta "
            + "set dec_cuensaldo = dec_cuensaldo - ?,"
            + "int_cuencontmov = int_cuencontmov + 1"
            + "where chr_cuencodigo = ?"
            + "and chr_cuenclave = ? ";
    PreparedStatement pstm = cn.prepareStatement(sql);
    pstm.setDouble(1, importe);
    pstm.setString(2, cuenta);
    pstm.setString(3, clave);
    pstm.executeQuery();
    pstm.close();
    //************************************************
    
    sql = "select int_cuencontmov "
              + "from cuenta "
              + "where chr_cuencodigo = ?";
    pstm = cn.prepareStatement(sql);
    pstm.setString(1, cuenta);
    ResultSet rs = pstm.executeQuery();
    rs.next();
    int cont = rs.getInt("int_cuencontmov");
    rs.close();
    pstm.close();
     //***********************************************
    sql = "insert into movimiento(chr_cuencodigo,int_movinumero,"
            + "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,"
            + "dec_moviimporte) values(?,?,SYSDATE,?,'003',?)";
    pstm = cn.prepareStatement(sql);
    pstm.setString(1, cuenta);
    pstm.setInt(2, cont);
    pstm.setString(3, codEmp);
    pstm.setDouble(4, importe);
    pstm.executeUpdate();
    pstm.close();
    //*********************************************
    cn.commit();
    }catch (SQLException e){
        try{
            cn.rollback();
        }catch(Exception e1){
        }
        throw new RuntimeException(e.getMessage());
    }catch (Exception e){
        try{
            cn.rollback();
        }catch(Exception e1){
        }
        throw new RuntimeException("Errooorrr perdiste todo tu dinero");
    }finally {
    try{
    cn.close();
    }catch(Exception e){
    }    
    }  
    }//procRetiro
    
}
