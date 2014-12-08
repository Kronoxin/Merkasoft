/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.venta.SAVenta;

import Negocio.venta.TCompraArticulo;
import Negocio.venta.TVenta;
import java.util.ArrayList;

/**
 *
 * @author borja
 */
public interface SAVenta {
    
    public int altaventa(TVenta venta);
    public boolean devolucionProducto(TCompraArticulo articulo);
    public TVenta mostrarVenta(int id);
    public ArrayList<TVenta> mostrarListaVenta();
    
}
