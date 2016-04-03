package pe.egcc.eurekaappcs.controller;

import pe.egcc.eurekaappcs.domain.Cuenta;
import pe.egcc.eurekaappcs.domain.Empleado;
import pe.egcc.eurekaappcs.service.LogonService;
import pe.egcc.eurekaappcs.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonController {
    
private LogonService validarclave;
    
public LogonController(){
    validarclave = new LogonService();
}    
  
  public void validar(String usuario, String clave){
    LogonService service = new LogonService();
    Empleado bean = service.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
  
  //*************************************************
  public void validarclave1(String cuenta, String clave){
     Cuenta bean = validarclave.validarclave1(cuenta, clave);
     Memoria.put("cuenta", bean);
  }
  
  //**************************************************
  public void cambioclave(String clave , String cuenta){
   validarclave.cambioclave(cuenta ,clave);
  }

  
}
