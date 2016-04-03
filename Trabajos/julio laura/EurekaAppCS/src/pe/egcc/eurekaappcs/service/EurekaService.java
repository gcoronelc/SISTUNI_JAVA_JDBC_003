package pe.egcc.eurekaappcs.service;

import pe.egcc.eurekaappcs.dao.espec.EurekaDaoEspec;
import pe.egcc.eurekaappcs.dao.espec.RetiroDaoEspec;
import pe.egcc.eurekaappcs.dao.impl.EurekaDaoImpl;
import pe.egcc.eurekaappcs.dao.impl.RetiroDaoImpl;
import pe.egcc.eurekaappcs.util.Dialogo;

/**
 *
 * @author Gustavo Coronel
 */

public class EurekaService {

  private EurekaDaoEspec eurekaDao;
  private RetiroDaoEspec retiro;
  
  public EurekaService() {
    eurekaDao = new EurekaDaoImpl();
    retiro =new RetiroDaoImpl();
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
  
  public void procRetio(String cuenta, double importe, String clave, String codEmp){
     if(cuenta == null || cuenta.isEmpty()){
       throw new RuntimeException("Cuenta no es correcta.");
     }
     if(importe <= 0.0){
       throw new RuntimeException("Error, importe no es valido.");
     }
     if (clave == null || clave.isEmpty()){
      throw new RuntimeException("Clave INCORRECTA TE HAKEARON");
     }
     
  retiro.procRetiro(cuenta, importe, clave, codEmp);
  }
  
  
}
