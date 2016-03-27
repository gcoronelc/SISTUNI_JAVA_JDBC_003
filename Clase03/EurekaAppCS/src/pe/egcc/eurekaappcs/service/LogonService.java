package pe.egcc.eurekaappcs.service;

import pe.egcc.eurekaappcs.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonService {

  public Empleado validar(String usuario, String clave){
    if(usuario == null || usuario.isEmpty()){
      throw  new RuntimeException("Error, datos incorrectos.");
    }
    if(clave == null || clave.isEmpty()){
      throw  new RuntimeException("Error, datos incorrectos.");
    }
    if(!usuario.equals("gustavo")){
      throw  new RuntimeException("Error, datos incorrectos.");
    }
    return null;
  }
  
}
