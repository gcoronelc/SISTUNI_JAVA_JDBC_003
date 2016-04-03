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
import java.util.List;
import pe.egcc.eurekaappcs.dao.espec.ValidarClaveDaoEspec;
import pe.egcc.eurekaappcs.db.AccesoDB;
import pe.egcc.eurekaappcs.domain.Cuenta;

/**
 *
 * @author julu
 */
public class ValidarClaveDaoImpl implements ValidarClaveDaoEspec{

    @Override
    public Cuenta validarclave(String cuenta, String clave) {  
    Cuenta bean = null;
    Connection cn = null;
    
    try {
        cn = AccesoDB.getConnection();
        
      String sql = "select chr_cuencodigo "
                + "from cuenta "
                + "where chr_cuenclave = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
       if(rs.next()){
        bean = mapRow(rs);
      }
      rs.close();
      pstm.close();
      
    } catch(SQLException e){
     throw new RuntimeException(e.getMessage()); 
    } catch(Exception e){
      throw new RuntimeException("Error de acceso al servidor.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    
    
    return bean;
    }


    @Override
    public Cuenta getForId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cuenta> getForAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cuenta> getForCriteria(Cuenta bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Cuenta bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cuenta bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     private Cuenta mapRow(ResultSet rs) throws SQLException {
    Cuenta bean = new Cuenta();
    
    bean.setMonecodigo(rs.getString("chr_monecodigo"));
    bean.setSucucodigo(rs.getString("chr_sucucodigo"));
    bean.setEmplcreacuenta(rs.getString("chr_emplcreacuenta"));
    bean.setCliecodigo(rs.getString("chr_cliecodigo"));
    bean.setCuencodigo(rs.getString("chr_cuencodigo"));
    
    return bean;
  }
}
