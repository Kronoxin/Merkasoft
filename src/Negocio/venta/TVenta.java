/*
 *Transfer que proporciona los atributos de una venta
 */
package Negocio.venta;

import Negocio.cliente.TCliente;
import java.util.ArrayList;
import java.util.Date;

public abstract  class TVenta {
    
    
    private int _id;
    private TCliente _cliente;
    private Date _fecha;
    private ArrayList<TCompraArticulo> _listaproductos;
    private boolean _activo;
    //Metodos get y set de los atributos de venta
    public int getId() {
        return _id;
    }
    
    public void setId(int _id) {
        this._id = _id;
    }

    public TCliente getCliente() {
        return _cliente;
    }

    public void setCliente(TCliente _cliente) {
        this._cliente = _cliente;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public ArrayList<TCompraArticulo> getListaproductos() {
        return _listaproductos;
    }

    public void setListaproductos(ArrayList<TCompraArticulo> _listaproductos) {
        this._listaproductos = _listaproductos;
    }

    public boolean isActivo() {
        return _activo;
    }

    public void setActivo(boolean _activo) {
        this._activo = _activo;
    }
    
}
