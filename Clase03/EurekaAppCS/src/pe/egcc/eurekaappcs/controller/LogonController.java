package pe.egcc.eurekaappcs.controller;

import pe.egcc.eurekaappcs.domain.Empleado;
import pe.egcc.eurekaappcs.service.LogonService;
import pe.egcc.eurekaappcs.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonController {
  
  public void validar(String usuario, String clave){
    LogonService service = new LogonService();
    Empleado bean = service.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
   
}
