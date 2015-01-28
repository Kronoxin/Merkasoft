/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.turnos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import negocio.empleados.Empleado;



@Entity
@Table(name = "horario_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioTrabajo.findAll", query = "SELECT h FROM HorarioTrabajo h"),
    @NamedQuery(name = "HorarioTrabajo.findByIdEmpleado", query = "SELECT h FROM HorarioTrabajo h WHERE h.horarioTrabajoPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "HorarioTrabajo.findByIdTurno", query = "SELECT h FROM HorarioTrabajo h WHERE h.horarioTrabajoPK.idTurno = :idTurno"),
    @NamedQuery(name = "HorarioTrabajo.findByVersion", query = "SELECT h FROM HorarioTrabajo h WHERE h.version = :version"),
    @NamedQuery(name = "HorarioTrabajo.findByDisponible", query = "SELECT h FROM HorarioTrabajo h WHERE h.disponible = :disponible")})
public class HorarioTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorarioTrabajoPK horarioTrabajoPK;
    @Column(name = "Version")
    @Version
    private Integer version;
    @Basic(optional = false)
    @Column(name = "disponible")
    private boolean disponible = true;
    @JoinColumn(name = "id_turno", referencedColumnName = "id_turno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turno turno;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;
    
    public static final String QUERY_BUSCAR_TURNOS_POR_IDEMPLEADO = "HorarioTrabajo.findByIdEmpleado";
    public static final String QUERY_BUSCAR_TODOS_TURNOS_CON_TODOS_EMPLEADOS = "HorarioTrabajo.findAll";

    public HorarioTrabajo() {
    }

    public HorarioTrabajo(HorarioTrabajoPK horarioTrabajoPK) {
        this.horarioTrabajoPK = horarioTrabajoPK;
    }

    public HorarioTrabajo(HorarioTrabajoPK horarioTrabajoPK, boolean disponible) {
        this.horarioTrabajoPK = horarioTrabajoPK;
        this.disponible = disponible;
    }

    public HorarioTrabajo(int idEmpleado, int idTurno) {
        this.horarioTrabajoPK = new HorarioTrabajoPK(idEmpleado, idTurno);
    }

    public HorarioTrabajoPK getHorarioTrabajoPK() {
        return horarioTrabajoPK;
    }

    public void setHorarioTrabajoPK(HorarioTrabajoPK horarioTrabajoPK) {
        this.horarioTrabajoPK = horarioTrabajoPK;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horarioTrabajoPK != null ? horarioTrabajoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioTrabajo)) {
            return false;
        }
        HorarioTrabajo other = (HorarioTrabajo) object;
        if ((this.horarioTrabajoPK == null && other.horarioTrabajoPK != null) || (this.horarioTrabajoPK != null && !this.horarioTrabajoPK.equals(other.horarioTrabajoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.turnos.HorarioTrabajo[ horarioTrabajoPK=" + horarioTrabajoPK + " ]";
    }
    
}
