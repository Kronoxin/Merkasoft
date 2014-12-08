/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.cliente.SACliente;

import Negocio.cliente.TCliente;
import java.util.ArrayList;

/**
 *
 * @author borja
 */
public interface SACliente {
    
    public int altaCliente(TCliente cliente);
    public boolean eliminarCliente(int id);
    public boolean modificarCliente(TCliente cliente);
    public boolean mostrarCliente(int id);    
    public ArrayList<TCliente> mostrarListaCliente();
    public ArrayList<TCliente> mostrarClientesMedia();
        
    
}
