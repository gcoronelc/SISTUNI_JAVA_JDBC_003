package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba04 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      // Leer el usuario
      String usuario;
      usuario = JOptionPane.showInputDialog("Ingrese usuario");
      // Proceso
      cn = AccesoDB.getConnection();
      String sql = "Select * from empleado "
              + "where vch_emplusuario = ? ";
      System.err.println("SQL: " + sql);
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      ResultSet rs = pstm.executeQuery();
      while(rs.next()){
        String texto = rs.getString("CHR_EMPLCODIGO") +
                " | " + rs.getString("VCH_EMPLPATERNO") +
                " | " + rs.getString("VCH_EMPLUSUARIO");
        System.out.println(texto);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
  
}
