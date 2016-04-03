package pe.egcc.eurekaappcs.service;

import pe.egcc.eurekaappcs.dao.espec.CambioClaveDaoEspec;
import pe.egcc.eurekaappcs.dao.espec.EmpleadoDaoEspec;
import pe.egcc.eurekaappcs.dao.impl.ValidarClaveDaoImpl;
import pe.egcc.eurekaappcs.dao.impl.EmpleadoDaoImpl;
import pe.egcc.eurekaappcs.domain.Empleado;
import pe.egcc.eurekaappcs.dao.espec.ValidarClaveDaoEspec;
import pe.egcc.eurekaappcs.dao.impl.CambioClaveDaoImpl;
import pe.egcc.eurekaappcs.domain.Cuenta;

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
  
 //**********************************************************
  public Cuenta validarclave1(String cuenta , String clave){
   if(cuenta == null || cuenta.isEmpty()){
      throw  new RuntimeException("Error, datos incorrectos.");
    }
    if(clave == null || clave.isEmpty()){
      throw  new RuntimeException("Error, datos incorrectos.");
    }
   ValidarClaveDaoEspec dao = new ValidarClaveDaoImpl();
   Cuenta bean = dao.validarclave(cuenta, clave);
   return bean;
  }
  //**********************************************************
  
  public void cambioclave(String cuenta , String clave){
  if(cuenta == null || cuenta.isEmpty()){
      throw  new RuntimeException("Error, datos incorrectos.");
    }
      
  if(clave==null || clave.isEmpty()){
  throw  new RuntimeException("Error, datos incorrectos.");
  }
  CambioClaveDaoEspec cambio1 = new CambioClaveDaoImpl();
  cambio1.cambioclave(cuenta,clave);    
  }
  
}
