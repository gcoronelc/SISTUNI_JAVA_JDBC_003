package pe.egcc.eurekaappcs.dao.espec;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo Coronel
 */
public interface EurekaDaoEspec {
  
  void procDeposito(String cuenta, double importe, String codEmp);
  
  List<Map<String,?>> getMovimientos(String cuenta);
  
}
