package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba06 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      // Proceso
      cn = AccesoDB.getConnection();
      String sql = "insert into parametro(chr_paracodigo,vch_paradescripcion,"
              + "vch_paravalor,vch_paraestado) values(?,?,?,?) ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, "010");
      pstm.setString(2, "Profesor");
      pstm.setString(3, "Gustavo Coronel");
      pstm.setString(4, "ACTIVO");
      int filas = pstm.executeUpdate();
      System.out.println("Filas procesadas: " + filas);
      pstm.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

}
