/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.cliente;

/**
 * Clase TClienteVip: hereda de TCliente se emplea para especificar a la clase padre.
 * Agrega el atributo financiacion para determinar que es una empresa.
 */
public class TClienteVip extends TCliente {
    //atributo que especializa la clase
    private float financiacion;

    public float getFinanciacion() {
        return financiacion;
    }

    public void setFinanciacion(float financiacion) {
        this.financiacion = financiacion;
    }
    
    
}
