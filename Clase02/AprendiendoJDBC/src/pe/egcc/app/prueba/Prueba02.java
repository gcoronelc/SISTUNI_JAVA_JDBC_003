package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba02 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "Select * from empleado "
              + "where vch_emplusuario = 'cromero'";
      Statement stm = cn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while(rs.next()){
        String texto = rs.getString("CHR_EMPLCODIGO") +
                " | " + rs.getString("VCH_EMPLPATERNO") +
                " | " + rs.getString("VCH_EMPLUSUARIO");
        System.out.println(texto);
      }
      rs.close();
      stm.close();
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
