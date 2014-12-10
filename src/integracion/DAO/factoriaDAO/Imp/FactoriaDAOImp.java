/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.DAO.factoriaDAO.Imp;

import integracion.DAO.cliente.DAOCliente;
import integracion.DAO.cliente.Imp.DAOClienteImp;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.DAO.producto.DAOProducto;
import integracion.DAO.producto.Imp.DAOProductoImp;
import integracion.DAO.venta.DAOVenta;
import integracion.DAO.venta.Imp.DAOVentaImp;

/**
 *
 * @author Ruben
 */
public class FactoriaDAOImp extends FactoriaDAO
{
    
    @Override
    public DAOCliente getDAOCliente() {
        return new DAOClienteImp();
    }
    
    @Override
    public DAOProducto getDAOProducto() {
        return new DAOProductoImp();
    }

    @Override
    public DAOVenta getDAOVenta() {
        return new DAOVentaImp();
    }
     
}