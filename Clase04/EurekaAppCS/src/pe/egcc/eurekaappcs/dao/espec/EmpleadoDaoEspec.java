package pe.egcc.eurekaappcs.dao.espec;

import pe.egcc.eurekaappcs.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 */
public interface EmpleadoDaoEspec extends CrudDaoEspec<Empleado>{
  
  Empleado validar(String usuario, String clave);
  
}
