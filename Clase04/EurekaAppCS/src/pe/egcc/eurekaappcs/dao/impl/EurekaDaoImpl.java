package pe.egcc.eurekaappcs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import pe.egcc.eurekaappcs.dao.espec.EurekaDaoEspec;
import pe.egcc.eurekaappcs.db.AccesoDB;
import pe.egcc.eurekaappcs.util.JdbcUtil;

/**
 *
 * @author Gustavo Coronel
 */
public class EurekaDaoImpl implements EurekaDaoEspec {

  @Override
  public void procDeposito(String cuenta, double importe, String codEmp) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);
      // Actualizar cuenta
      String sql = "update cuenta "
              + "set dec_cuensaldo = dec_cuensaldo + ?, "
              + "int_cuencontmov = int_cuencontmov + 1 "
              + "where chr_cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, importe);
      pstm.setString(2, cuenta);
      pstm.executeUpdate();
      pstm.close();
      // Leer el contador
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
      // Insertar movimiento
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
      // Confirmar Tx
      cn.commit();
    } catch (SQLException e) {
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

  @Override
  public List<Map<String, ?>> getMovimientos(String cuenta) {
    Connection cn = null;
    List<Map<String, ?>> lista = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "SELECT "
              + "CUENCODIGO, MONENOMBRE, SUCUNOMBRE, "
              + "CUENSALDO, CUENESTADO, MOVINUMERO, "
              + "MOVIFECHA, TIPONOMBRE, TIPOACCION, "
              + "MOVIIMPORTE FROM V_MOVIMIENTO "
              + "WHERE CUENCODIGO = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      lista = JdbcUtil.rsToList(rs);
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

}
