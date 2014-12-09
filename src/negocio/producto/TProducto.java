/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.producto;

/**
 *
 * @author borja
 */
public class TProducto {
    private int _id;
    private String _nombre;
    private double _precio;
    private String _descripcion;
    private String _codigoDeBarras;
    private int _stock;
    private boolean _activo;

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public double getPrecio() {
        return _precio;
    }

    public void setPrecio(double _precio) {
        this._precio = _precio;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String getCodigoDeBarras() {
        return _codigoDeBarras;
    }

    public void setCodigoDeBarras(String _codigoDeBarras) {
        this._codigoDeBarras = _codigoDeBarras;
    }

    public int getStock() {
        return _stock;
    }

    public void setStock(int _stock) {
        this._stock = _stock;
    }

    public boolean getActivo() {
        return _activo;
    }

    public void setActivo(boolean _activo) {
        this._activo = _activo;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
    
    
    
}
