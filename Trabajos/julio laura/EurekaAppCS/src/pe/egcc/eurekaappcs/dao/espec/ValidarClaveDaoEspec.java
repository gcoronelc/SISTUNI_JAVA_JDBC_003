/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.eurekaappcs.dao.espec;

import pe.egcc.eurekaappcs.domain.Cuenta;

/**
 *
 * @author julu
 */
public interface ValidarClaveDaoEspec extends CrudDaoEspec<Cuenta>{
    
 Cuenta validarclave(String cuenta,String clave);  
}
