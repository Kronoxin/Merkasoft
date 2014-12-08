/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.venta;

/**
 *
 * @author borja
 */
public abstract class TCompraArticulo {
    
    private int _idArticulo;
    private int _cantidad;
    private double _precio;
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
