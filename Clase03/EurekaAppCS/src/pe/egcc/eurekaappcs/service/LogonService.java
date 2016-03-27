package pe.egcc.eurekaappcs.service;

import pe.egcc.eurekaappcs.dao.espec.EmpleadoDaoEspec;
import pe.egcc.eurekaappcs.dao.impl.EmpleadoDaoImpl;
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
    EmpleadoDaoEspec dao = new EmpleadoDaoImpl();
    Empleado bean = dao.validar(usuario, clave);
    if(bean == null){
      throw new RuntimeException("Datos son incorrectos.");
    }
    return bean;
  }
  
}
