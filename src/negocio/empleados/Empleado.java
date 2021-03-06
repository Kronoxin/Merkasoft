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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import negocio.turnos.HorarioTrabajo;
import negocio.turnos.Turno;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Tipo")
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByDni", query = "SELECT e FROM Empleado e WHERE e.dni = :dni"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleado.findByDepartamento", query = "SELECT e FROM Empleado e WHERE e.departamento = :dep"),
    @NamedQuery(name = "Empleado.findBySueldo", query = "SELECT e FROM Empleado e WHERE e.sueldo = :sueldo")})


public class Empleado implements Serializable 
{
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Sueldo")
    private double sueldo;
    @Version
    @Column(name = "Version")
    private Integer version;
    @Basic(optional = false)
    @Column(name = "Disponible")
    private boolean disponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<HorarioTrabajo> horarioTrabajoCollection;
    
    @JoinTable(name = "horario_trabajo", joinColumns = {
        @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")}, inverseJoinColumns = {
        @JoinColumn(name = "id_turno", referencedColumnName = "id_turno")})
    @ManyToMany
    private Collection<Turno> turnoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Tipo")
    private String tipo;
    @JoinColumn(name = "Departamento", referencedColumnName = "id_departamento")
    @ManyToOne
    private Departamento departamento;
     
    public Empleado() 
    {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.empleados.Empleados[ idEmpleado=" + idEmpleado + " ]";
    }

    @XmlTransient
    public Collection<Turno> getTurnoCollection() {
        return turnoCollection;
    }

    public void setTurnoCollection(Collection<Turno> turnoCollection) {
        this.turnoCollection = turnoCollection;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @XmlTransient
    public Collection<HorarioTrabajo> getHorarioTrabajoCollection() {
        return horarioTrabajoCollection;
    }

    public void setHorarioTrabajoCollection(Collection<HorarioTrabajo> horarioTrabajoCollection) {
        this.horarioTrabajoCollection = horarioTrabajoCollection;
    }
    
    
    
}
