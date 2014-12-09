/*
 * transfer que proporciona los atributos de un articulo comprado
 */
package Negocio.venta;
public abstract class TCompraArticulo {
    
    private int _idArticulo;
    private int _cantidad;
    private double _precio;
    //metodos get y set de los atrbutos de compraVenta
    public int getIdArticulo() {
        return _idArticulo;
    }

    public void setIdArticulo(int _idArticulo) {
        this._idArticulo = _idArticulo;
    }

    public int getCantidad() {
        return _cantidad;
    }

    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public double getPrecio() {
        return _precio;
    }

    public void setPrecio(double _precio) {
        this._precio = _precio;
    }
   
    
}
