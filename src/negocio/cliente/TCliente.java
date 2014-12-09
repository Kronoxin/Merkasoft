/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.cliente;

import Negocio.venta.TVenta;
import java.util.ArrayList;

/**
 * Clase abstracta tCliente: esta clase sirve como contenedor de informacion, empleado
 * para transmitir la informacion entre capas. Tiene todos los atributos, get y set.
 */
public class TCliente {
    
    //Atributos del TCliente
    private int _id;
    private String _nombre;
    private String _apellidos;
    private String _DNI;
    private String _fecha_nacimiento; //Formato: "dd/mm/yyyy"
    private ArrayList<TVenta> _venta;
    private boolean _activo;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getApellidos() {
        return _apellidos;
    }

    public void setApellidos(String _apellidos) {
        this._apellidos = _apellidos;
    }

    public String getDNI() {
        return _DNI;
    }

    public void setDNI(String _DNI) {
        this._DNI = _DNI;
    }
    
    public String getFechaNacimiento()
    {
        return _fecha_nacimiento;
    }
    public void setFechaNacimiento(String fecha)
    {
        this._fecha_nacimiento = fecha;
    }

    public ArrayList<TVenta> getVenta() {
        return _venta;
    }

    public void setVenta(ArrayList<TVenta> _venta) {
        this._venta = _venta;
    }


    public boolean isActivo() {
        return _activo;
    }

    public void setActivo(boolean _activo) {
        this._activo = _activo;
    }
    
    
    
}