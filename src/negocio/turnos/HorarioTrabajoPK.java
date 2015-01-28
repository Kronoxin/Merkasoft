/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.turnos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class HorarioTrabajoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private int idEmpleado;
    @Basic(optional = false)
    @Column(name = "id_turno")
    private int idTurno;

    public HorarioTrabajoPK() {
    }

    public HorarioTrabajoPK(int idEmpleado, int idTurno) {
        this.idEmpleado = idEmpleado;
        this.idTurno = idTurno;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEmpleado;
        hash += (int) idTurno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioTrabajoPK)) {
            return false;
        }
        HorarioTrabajoPK other = (HorarioTrabajoPK) object;
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        if (this.idTurno != other.idTurno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.turnos.HorarioTrabajoPK[ idEmpleado=" + idEmpleado + ", idTurno=" + idTurno + " ]";
    }
    
}
