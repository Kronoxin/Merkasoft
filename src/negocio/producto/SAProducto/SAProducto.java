/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.producto.SAProducto;


import negocio.producto.TProducto;
import java.util.ArrayList;

/**
 *
 * @author borja
 */
public interface SAProducto 
{
    
    public int altaProducto(TProducto producto);
    public  boolean bajaProducto(int id);
    public boolean modificarProducto(TProducto producto);
    public TProducto mostrarProducto(int id);
    public ArrayList<TProducto> mostrarListaProducto();
    
    
}
