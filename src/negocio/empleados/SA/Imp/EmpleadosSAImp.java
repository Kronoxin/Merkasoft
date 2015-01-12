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
import negocio.empleados.Empleados;
import negocio.turnos.SA.exceptions.NonexistentEntityException;
import negocio.turnos.Turno;

/**
 *
 * @author Ruben
 */
public class EmpleadosSAImp implements Serializable {

    public EmpleadosSAImp(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleados empleados) {
        if (empleados.getTurnoCollection() == null) {
            empleados.setTurnoCollection(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Departamento departamento = empleados.getDepartamento();
            if (departamento != null) {
                departamento = em.getReference(departamento.getClass(), departamento.getIdDepartamento());
                empleados.setDepartamento(departamento);
            }
            Collection<Turno> attachedTurnoCollection = new ArrayList<Turno>();
            for (Turno turnoCollectionTurnoToAttach : empleados.getTurnoCollection()) {
                turnoCollectionTurnoToAttach = em.getReference(turnoCollectionTurnoToAttach.getClass(), turnoCollectionTurnoToAttach.getIdTurno());
                attachedTurnoCollection.add(turnoCollectionTurnoToAttach);
            }
            empleados.setTurnoCollection(attachedTurnoCollection);
            em.persist(empleados);
            if (departamento != null) {
                departamento.getEmpleadosCollection().add(empleados);
                departamento = em.merge(departamento);
            }
            for (Turno turnoCollectionTurno : empleados.getTurnoCollection()) {
                turnoCollectionTurno.getEmpleadosCollection().add(empleados);
                turnoCollectionTurno = em.merge(turnoCollectionTurno);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleados empleados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados persistentEmpleados = em.find(Empleados.class, empleados.getIdEmpleado());
            Departamento departamentoOld = persistentEmpleados.getDepartamento();
            Departamento departamentoNew = empleados.getDepartamento();
            Collection<Turno> turnoCollectionOld = persistentEmpleados.getTurnoCollection();
            Collection<Turno> turnoCollectionNew = empleados.getTurnoCollection();
            if (departamentoNew != null) {
                departamentoNew = em.getReference(departamentoNew.getClass(), departamentoNew.getIdDepartamento());
                empleados.setDepartamento(departamentoNew);
            }
            Collection<Turno> attachedTurnoCollectionNew = new ArrayList<Turno>();
            for (Turno turnoCollectionNewTurnoToAttach : turnoCollectionNew) {
                turnoCollectionNewTurnoToAttach = em.getReference(turnoCollectionNewTurnoToAttach.getClass(), turnoCollectionNewTurnoToAttach.getIdTurno());
                attachedTurnoCollectionNew.add(turnoCollectionNewTurnoToAttach);
            }
            turnoCollectionNew = attachedTurnoCollectionNew;
            empleados.setTurnoCollection(turnoCollectionNew);
            empleados = em.merge(empleados);
            if (departamentoOld != null && !departamentoOld.equals(departamentoNew)) {
                departamentoOld.getEmpleadosCollection().remove(empleados);
                departamentoOld = em.merge(departamentoOld);
            }
            if (departamentoNew != null && !departamentoNew.equals(departamentoOld)) {
                departamentoNew.getEmpleadosCollection().add(empleados);
                departamentoNew = em.merge(departamentoNew);
            }
            for (Turno turnoCollectionOldTurno : turnoCollectionOld) {
                if (!turnoCollectionNew.contains(turnoCollectionOldTurno)) {
                    turnoCollectionOldTurno.getEmpleadosCollection().remove(empleados);
                    turnoCollectionOldTurno = em.merge(turnoCollectionOldTurno);
                }
            }
            for (Turno turnoCollectionNewTurno : turnoCollectionNew) {
                if (!turnoCollectionOld.contains(turnoCollectionNewTurno)) {
                    turnoCollectionNewTurno.getEmpleadosCollection().add(empleados);
                    turnoCollectionNewTurno = em.merge(turnoCollectionNewTurno);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleados.getIdEmpleado();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, id);
                empleados.getIdEmpleado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            Departamento departamento = empleados.getDepartamento();
            if (departamento != null) {
                departamento.getEmpleadosCollection().remove(empleados);
                departamento = em.merge(departamento);
            }
            Collection<Turno> turnoCollection = empleados.getTurnoCollection();
            for (Turno turnoCollectionTurno : turnoCollection) {
                turnoCollectionTurno.getEmpleadosCollection().remove(empleados);
                turnoCollectionTurno = em.merge(turnoCollectionTurno);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleados> findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
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

    public Empleados findEmpleados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
