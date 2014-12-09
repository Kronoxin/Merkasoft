/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.producto.SAProducto;


import Negocio.producto.TProducto;
import java.util.ArrayList;

/**
 *
 * @author borja
 */
public interface SAProducto {
    
    public String altaProducto(TProducto producto);
    public  boolean bajaProducto(String codigoBarras);
    public boolean modificarProducto(TProducto producto);
    public TProducto mostrarProducto(String codigoBarras);
    public ArrayList<TProducto> mostrarListaProducto();
    
    
}
