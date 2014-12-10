
import Negocio.cliente.TClienteNormal;
import integracion.DAO.cliente.Imp.DAOClienteImp;
import integracion.transaction.Transaction;
import integracion.transaction.transactionManager.Imp.TransactionManagerImp;
import integracion.transaction.transactionManager.TransactionManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guinos
 */

//Main para hacer pruebas
public class Main {
    
    public static void main(String[] args) throws Exception
    {
        TClienteNormal prueba = new TClienteNormal();
        prueba.setDNI("123456781");
        prueba.setFechaNacimiento("20/03/1990");
        prueba.setQuierevip(true);
        DAOClienteImp dc = new DAOClienteImp();
        TransactionManager tm = TransactionManager.obtenerInstanacia();
        tm.nuevaTransaccion();
        Transaction t = tm.getTransaccion();
        t.start();
        
        dc.altaCliente(prueba);
    }
}
