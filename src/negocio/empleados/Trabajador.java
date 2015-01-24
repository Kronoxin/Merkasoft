/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.empleados;

import negocio.departamentos.Departamento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Trabajador")
//No están puestas las namequerys. son necesarias?
    
public class Trabajador extends Empleado implements Serializable
{
    
    @Column(name = "Horas_trabajadas")
    private double horas_trabajadas;
    

    public double getHoras_trabajadas() {
        return horas_trabajadas;
    }

    public void setHoras_trabajadas(double horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }
    
}
