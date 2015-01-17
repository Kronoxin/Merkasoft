/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.empleados.SA.Imp;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import negocio.departamentos.Departamento;
import negocio.turnos.Turno;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.departamentos.SA.Imp.SADepartamentoImp;
import negocio.empleados.Empleado;
import negocio.empleados.SA.SAEmpleado;
import negocio.turnos.SA.exceptions.NonexistentEntityException;
import negocio.turnos.Turno;

/**
 *
 * @author Ruben
 */
public class SAEmpleadoImp implements SAEmpleado {

    

    public SAEmpleadoImp() 
    {
    }

   
    @Override
    public int altaEmpleado(Empleado empleado) 
    {
        if (empleado.getTurnoCollection() == null) {
            empleado.setTurnoCollection(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try 
        {
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
            
            em.getTransaction().begin();
            Departamento departamento = empleado.getDepartamento();
            if (departamento != null) {
                departamento = em.getReference(departamento.getClass(), departamento.getIdDepartamento());
                empleado.setDepartamento(departamento);
            }
            Collection<Turno> attachedTurnoCollection = new ArrayList<Turno>();
            for (Turno turnoCollectionTurnoToAttach : empleado.getTurnoCollection()) {
                turnoCollectionTurnoToAttach = em.getReference(turnoCollectionTurnoToAttach.getClass(), turnoCollectionTurnoToAttach.getIdTurno());
                attachedTurnoCollection.add(turnoCollectionTurnoToAttach);
            }
            empleado.setTurnoCollection(attachedTurnoCollection);
            em.persist(empleado);
            if (departamento != null) {
                departamento.getEmpleadosCollection().add(empleado);
                departamento = em.merge(departamento);
            }
            for (Turno turnoCollectionTurno : empleado.getTurnoCollection()) {
                turnoCollectionTurno.getEmpleadosCollection().add(empleado);
                turnoCollectionTurno = em.merge(turnoCollectionTurno);
            }
            em.getTransaction().commit();
        } 
        finally 
        {
            if (em != null) 
            {
                em.close();
            }
        }
        
        return empleado.getIdEmpleado();
    }

    @Override
    public boolean modificarEmpleado(Empleado empleado)
    {
        EntityManager em = null;
        boolean correcto = true;
        try {
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleados = em.find(Empleado.class, empleado.getIdEmpleado());
            Departamento departamentoOld = persistentEmpleados.getDepartamento();
            Departamento departamentoNew = empleado.getDepartamento();
            Collection<Turno> turnoCollectionOld = persistentEmpleados.getTurnoCollection();
            Collection<Turno> turnoCollectionNew = empleado.getTurnoCollection();
            if (departamentoNew != null) {
                departamentoNew = em.getReference(departamentoNew.getClass(), departamentoNew.getIdDepartamento());
                empleado.setDepartamento(departamentoNew);
            }
            Collection<Turno> attachedTurnoCollectionNew = new ArrayList<Turno>();
            if(turnoCollectionNew != null)
            {
                for (Turno turnoCollectionNewTurnoToAttach : turnoCollectionNew) {
                    turnoCollectionNewTurnoToAttach = em.getReference(turnoCollectionNewTurnoToAttach.getClass(), turnoCollectionNewTurnoToAttach.getIdTurno());
                    attachedTurnoCollectionNew.add(turnoCollectionNewTurnoToAttach);
                }
            }
            turnoCollectionNew = attachedTurnoCollectionNew;
            empleado.setTurnoCollection(turnoCollectionNew);
            empleado = em.merge(empleado);
            if (departamentoOld != null && !departamentoOld.equals(departamentoNew)) {
                departamentoOld.getEmpleadosCollection().remove(empleado);
                departamentoOld = em.merge(departamentoOld);
            }
            if (departamentoNew != null && !departamentoNew.equals(departamentoOld)) {
                departamentoNew.getEmpleadosCollection().add(empleado);
                departamentoNew = em.merge(departamentoNew);
            }
            if (turnoCollectionOld != null)
            {
                for (Turno turnoCollectionOldTurno : turnoCollectionOld) {
                    if (!turnoCollectionNew.contains(turnoCollectionOldTurno)) {
                        turnoCollectionOldTurno.getEmpleadosCollection().remove(empleado);
                        turnoCollectionOldTurno = em.merge(turnoCollectionOldTurno);
                    }
                }
            }
            if ( turnoCollectionNew != null)
            {
                for (Turno turnoCollectionNewTurno : turnoCollectionNew) {
                    if (!turnoCollectionOld.contains(turnoCollectionNewTurno)) {
                        turnoCollectionNewTurno.getEmpleadosCollection().add(empleado);
                        turnoCollectionNewTurno = em.merge(turnoCollectionNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } 
        catch (Exception ex) 
        {
            correcto = false;
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleado.getIdEmpleado();
                if (mostrarEmpleado(id) == null) {
                    System.out.println("The empleados with id " + id + " no longer exists.");
                }
            }
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return correcto;
    }
    
    @Override
    public Empleado mostrarEmpleado(int id) {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }
    
    @Override
     public ArrayList<Empleado> mostrarListaEmpleados() 
    {
        return new ArrayList(findEmpleadosEntities(true, -1, -1));
    }

    @Override
    public boolean bajaEmpleado(int id)
    {
        EntityManager em = null;
        boolean correcto = true;
        try {
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleados = em.find(Empleado.class, id);
            
            persistentEmpleados.setDisponible(false);
            em.merge(persistentEmpleados);
            em.getTransaction().commit();
        } 
        catch (Exception ex) 
        {
            correcto = false;
            ex.printStackTrace();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return correcto;
    }
    

    
   

    private List<Empleado> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getEmpleadosCount() {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public static void main(String args[])
    {
        SAEmpleadoImp sa = new SAEmpleadoImp();
        Empleado empleado = new Empleado();
        Departamento dep = new Departamento();
        /*
        empleado.setNombre("Prueba1");
        empleado.setDni("12345678A");
        empleado.setApellidos("Cosas");
        empleado.setDireccion("Calle rabo 4");
        empleado.setDisponible(true);
        empleado.setDepartamento(new SADepartamentoImp().mostrarDepartamento(1));
        
        sa.altaEmpleado(empleado);
                */
        sa.bajaEmpleado(2);
        System.out.println("BABABUUIIII");
    }
    
}
