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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import negocio.turnos.Turno;


@Entity
@DiscriminatorValue("Supervisor")
//No están puestas las namequerys. son necesarias?
    
public class Supervisor extends Empleado implements Serializable
{
    
    @Column(name = "Factor_productividad")
    private double factor_productividad;
    

    public double getFactor_productividad() {
        return factor_productividad;
    }

    public void setFactor_productividad(double factor_productividad) {
        this.factor_productividad = factor_productividad;
    }
}