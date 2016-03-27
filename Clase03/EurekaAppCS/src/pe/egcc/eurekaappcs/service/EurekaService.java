package pe.egcc.eurekaappcs.service;

import pe.egcc.eurekaappcs.dao.espec.EurekaDaoEspec;
import pe.egcc.eurekaappcs.dao.impl.EurekaDaoImpl;

/**
 *
 * @author Gustavo Coronel
 */
public class EurekaService {

  private EurekaDaoEspec eurekaDao;

  public EurekaService() {
    eurekaDao = new EurekaDaoImpl();
  }
  
  public void procDeposito(String cuenta, double importe, String codEmp) {
     if(cuenta == null || cuenta.isEmpty()){
       throw new RuntimeException("Cuenta no es correcta.");
     }
     if(importe <= 0.0){
       throw new RuntimeException("Error, importe no es valido.");
     }
     eurekaDao.procDeposito(cuenta, importe, codEmp);
  }
  
}
