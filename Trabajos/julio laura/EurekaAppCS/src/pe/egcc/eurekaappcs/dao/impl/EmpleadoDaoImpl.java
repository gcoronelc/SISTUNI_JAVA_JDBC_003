package pe.egcc.eurekaappcs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.egcc.eurekaappcs.dao.espec.EmpleadoDaoEspec;
import pe.egcc.eurekaappcs.db.AccesoDB;
import pe.egcc.eurekaappcs.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 */
public class EmpleadoDaoImpl implements EmpleadoDaoEspec{

  @Override
  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_emplcodigo, vch_emplpaterno, "
              + "vch_emplmaterno, vch_emplnombre, vch_emplciudad, "
              + "vch_empldireccion, vch_emplusuario "
              + "from empleado "
              + "where vch_emplusuario = ? "
              + "and vch_emplclave = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = mapRow(rs);
      }
      rs.close();
      pstm.close();
    } catch (SQLException e) {
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
  public Empleado getForId(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Empleado> getForAll() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Empleado> getForCriteria(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void insert(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private Empleado mapRow(ResultSet rs) throws SQLException {
    Empleado bean = new Empleado();
    bean.setCodigo(rs.getString("chr_emplcodigo"));
    bean.setPaterno(rs.getString("vch_emplpaterno"));
    bean.setMaterno(rs.getString("vch_emplmaterno"));
    bean.setNombre(rs.getString("vch_emplnombre"));
    bean.setCiudad(rs.getString("vch_emplciudad"));
    bean.setDireccion(rs.getString("vch_empldireccion"));
    bean.setUsuario(rs.getString("vch_emplusuario"));
    return bean;
  }
  
}
