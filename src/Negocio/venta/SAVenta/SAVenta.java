/*
Interfaz que proporciona los metodos del servicio de aplicacion de venta
 */
package Negocio.venta.SAVenta;

import Negocio.venta.TCompraArticulo;
import Negocio.venta.TVenta;
import java.util.ArrayList;

public interface SAVenta {
    
    public int altaventa(TVenta venta);
    public boolean devolucionProducto(TCompraArticulo articulo);
    public TVenta mostrarVenta(int id);
    public ArrayList<TVenta> mostrarListaVenta();
    
}
