/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.query.factoriaQuery.Imp;

import integracion.query.Query;
import integracion.query.cliente.QueryMediaClientes;
import integracion.query.factoriaQuery.FactoriaQuery;

/**
 *
 * @author Ruben
 */
public class FactoriaQueryImp extends FactoriaQuery
{

    @Override
    public Query obtenerQueryClientesMedia() 
    {
        return new QueryMediaClientes();
    }
    
}
