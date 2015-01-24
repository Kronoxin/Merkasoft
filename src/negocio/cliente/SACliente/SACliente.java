/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cliente.SACliente;

import negocio.cliente.TCliente;
import java.util.ArrayList;


public interface SACliente {
    
    public int altaCliente(TCliente cliente)throws Exception;
    public boolean eliminarCliente(int id)throws Exception;
    public boolean modificarCliente(TCliente cliente)throws Exception;
    public TCliente mostrarCliente(int id)throws Exception;    
    public ArrayList<TCliente> mostrarListaCliente()throws Exception;
    public ArrayList<TCliente> mostrarClientesMedia()throws Exception;
        
    
}
