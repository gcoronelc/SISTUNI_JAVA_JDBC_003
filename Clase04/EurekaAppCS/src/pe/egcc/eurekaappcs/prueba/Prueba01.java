package pe.egcc.eurekaappcs.prueba;

import java.util.Map;
import pe.egcc.eurekaappcs.dao.espec.EurekaDaoEspec;
import pe.egcc.eurekaappcs.dao.impl.EurekaDaoImpl;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba01 {

  public static void main(String[] args) {
    try {
      EurekaDaoEspec dao = new EurekaDaoImpl();
      for(Map<String,?> r: dao.getMovimientos("00100001")){
        System.out.println(r.get("MOVINUMERO") + " - " + r.get("MOVIIMPORTE"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
