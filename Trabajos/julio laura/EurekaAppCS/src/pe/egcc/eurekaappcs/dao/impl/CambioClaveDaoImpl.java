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
import pe.egcc.eurekaappcs.dao.espec.CambioClaveDaoEspec;
import pe.egcc.eurekaappcs.db.AccesoDB;

/**
 *
 * @author julu
 */
public class CambioClaveDaoImpl implements CambioClaveDaoEspec {

    @Override
    public void cambioclave(String cuenta,String clave) {
         Connection cn = null;
    try{
    cn = AccesoDB.getConnection();
    cn.setAutoCommit(false);
    
    String sql = "update cuenta "
            +"set chr_cuenclave = ? "
            + "where chr_cuencodigo = ?";
    
    PreparedStatement pstm = cn.prepareStatement(sql);
    pstm.setString(1, clave);
    pstm.setString(2, cuenta);
    pstm.executeUpdate();
    pstm.close();
    ResultSet rs = pstm.executeQuery();
    rs.next();
    rs.close();
    pstm.close();
    
    sql = "insert into cuenta(chr_cuenclave)"
              + "values(?)";
    pstm = cn.prepareStatement(sql);
    pstm.setString(1, clave);
    pstm.executeUpdate();
    pstm.close();
    cn.commit();
    }catch (SQLException e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    
    
    
    }
}
