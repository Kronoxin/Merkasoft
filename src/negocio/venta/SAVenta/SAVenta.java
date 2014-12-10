/*
Interfaz que proporciona los metodos del servicio de aplicacion de venta
 */
package negocio.venta.SAVenta;

import negocio.venta.TCompraArticulo;
import negocio.venta.TVenta;
import java.util.ArrayList;

public interface SAVenta {
    
    public int altaventa(TVenta venta, int idCliente);
    public boolean devolucionProducto(TCompraArticulo articulo,int idVenta);
    public TVenta mostrarVenta(int id);
    public ArrayList<TVenta> mostrarListaVenta();
    
}
