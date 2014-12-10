/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cliente;

import negocio.cliente.TCliente;

/**
 * Clase TClienteNormal: hereda de TCliente se emplea para especificar a la clase padre.
 * Agrega el atributo quierevip para determinar que es una empresa.
 */
public class TClienteNormal extends TCliente{
    
    //atributo que especializa la clase

    private boolean quierevip;

    public boolean isQuierevip() {
        return quierevip;
    }

    public void setQuierevip(boolean quierevip) {
        this.quierevip = quierevip;
    }
    
    
}
