package pe.egcc.eurekaappcs.controller;

import pe.egcc.eurekaappcs.domain.Empleado;
import pe.egcc.eurekaappcs.service.EurekaService;
import pe.egcc.eurekaappcs.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaController {
  
  private EurekaService eurekaService;

  public CuentaController() {
    eurekaService = new EurekaService();
  }
  
  public void procDeposito(String cuenta, double importe) {
    Empleado bean = (Empleado) Memoria.get("usuario");
    eurekaService.procDeposito(cuenta, importe, bean.getCodigo());
  }
  
}
