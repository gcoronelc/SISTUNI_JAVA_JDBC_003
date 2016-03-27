package pe.egcc.eurekaappcs.controller;

import pe.egcc.eurekaappcs.service.LogonService;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonController {
  
  public void validar(String usuario, String clave){
    LogonService service = new LogonService();
    service.validar(usuario, clave);
  }
   
}
