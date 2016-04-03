/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.eurekaappcs.dao.espec;

/**
 *
 * @author julu
 */
public interface RetiroDaoEspec {
    
    void procRetiro(String cuenta, double importe , String clave, String codEmp);
    
}
