/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.turnos;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.sql.Time;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import negocio.empleados.Empleado;


@Entity
@Table(name = "turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t"),
    @NamedQuery(name = "Turno.findByIdTurno", query = "SELECT t FROM Turno t WHERE t.idTurno = :idTurno"),
    @NamedQuery(name = "Turno.findByNombre", query = "SELECT t FROM Turno t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Turno.findByHoraEntrada", query = "SELECT t FROM Turno t WHERE t.horaEntrada = :horaEntrada"),
    @NamedQuery(name = "Turno.findByHoraSalida", query = "SELECT t FROM Turno t WHERE t.horaSalida = :horaSalida")})
public class Turno implements Serializable {
    @Column(name = "Hora_entrada")
    private Integer horaentrada;
    @Column(name = "Hora_salida")
    private Integer horasalida;
    @Column(name = "Minuto_entrada")
    private Integer minutoentrada;
    @Column(name = "Minuto_salida")
    private Integer minutosalida;
    @Column(name = "Version")
    private Integer version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turno")
    private Collection<HorarioTrabajo> horarioTrabajoCollection;
    @ManyToMany(mappedBy = "turnoCollection")
    private Collection<Empleado> empleadosCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_turno")
    private Integer idTurno;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Hora_Entrada")   
    private int horaEntrada;
    @Column(name = "Hora_Salida")
    private int horaSalida;
    @Column(name = "Minuto_Entrada")   
    private int minutoEntrada;
    @Column(name = "Minuto_Salida")
    private int minutoSalida;
    @Column(name = "Disponible")
    private boolean Disponible;

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

    public Turno() {
    }

    public Turno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    public void setMinutoEntrada(int minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }

    public int getMinutoSalida() {
        return minutoSalida;
    }

    public void setMinutoSalida(int minutoSalida) {
        this.minutoSalida = minutoSalida;
    }   

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurno != null ? idTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.idTurno == null && other.idTurno != null) || (this.idTurno != null && !this.idTurno.equals(other.idTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.turnos.Turno[ idTurno=" + idTurno + " ]";
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleado> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    public Integer getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(Integer horaentrada) {
        this.horaentrada = horaentrada;
    }

    public Integer getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(Integer horasalida) {
        this.horasalida = horasalida;
    }

    public Integer getMinutoentrada() {
        return minutoentrada;
    }

    public void setMinutoentrada(Integer minutoentrada) {
        this.minutoentrada = minutoentrada;
    }

    public Integer getMinutosalida() {
        return minutosalida;
    }

    public void setMinutosalida(Integer minutosalida) {
        this.minutosalida = minutosalida;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<HorarioTrabajo> getHorarioTrabajoCollection() {
        return horarioTrabajoCollection;
    }

    public void setHorarioTrabajoCollection(Collection<HorarioTrabajo> horarioTrabajoCollection) {
        this.horarioTrabajoCollection = horarioTrabajoCollection;
    }
    
    
    
}
