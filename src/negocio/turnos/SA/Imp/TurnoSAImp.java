/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.turnos.SA.Imp;

import negocio.turnos.SA.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import negocio.empleados.Empleado;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import negocio.turnos.Turno;

/**
 *
 * @author Ruben
 */
public class TurnoSAImp implements Serializable {

    public TurnoSAImp(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        if (turno.getEmpleadosCollection() == null) {
            turno.setEmpleadosCollection(new ArrayList<Empleado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Empleado> attachedEmpleadosCollection = new ArrayList<Empleado>();
            for (Empleado empleadosCollectionEmpleadosToAttach : turno.getEmpleadosCollection()) {
                empleadosCollectionEmpleadosToAttach = em.getReference(empleadosCollectionEmpleadosToAttach.getClass(), empleadosCollectionEmpleadosToAttach.getIdEmpleado());
                attachedEmpleadosCollection.add(empleadosCollectionEmpleadosToAttach);
            }
            turno.setEmpleadosCollection(attachedEmpleadosCollection);
            em.persist(turno);
            for (Empleado empleadosCollectionEmpleados : turno.getEmpleadosCollection()) {
                empleadosCollectionEmpleados.getTurnoCollection().add(turno);
                empleadosCollectionEmpleados = em.merge(empleadosCollectionEmpleados);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getIdTurno());
            Collection<Empleado> empleadosCollectionOld = persistentTurno.getEmpleadosCollection();
            Collection<Empleado> empleadosCollectionNew = turno.getEmpleadosCollection();
            Collection<Empleado> attachedEmpleadosCollectionNew = new ArrayList<Empleado>();
            for (Empleado empleadosCollectionNewEmpleadosToAttach : empleadosCollectionNew) {
                empleadosCollectionNewEmpleadosToAttach = em.getReference(empleadosCollectionNewEmpleadosToAttach.getClass(), empleadosCollectionNewEmpleadosToAttach.getIdEmpleado());
                attachedEmpleadosCollectionNew.add(empleadosCollectionNewEmpleadosToAttach);
            }
            empleadosCollectionNew = attachedEmpleadosCollectionNew;
            turno.setEmpleadosCollection(empleadosCollectionNew);
            turno = em.merge(turno);
            for (Empleado empleadosCollectionOldEmpleados : empleadosCollectionOld) {
                if (!empleadosCollectionNew.contains(empleadosCollectionOldEmpleados)) {
                    empleadosCollectionOldEmpleados.getTurnoCollection().remove(turno);
                    empleadosCollectionOldEmpleados = em.merge(empleadosCollectionOldEmpleados);
                }
            }
            for (Empleado empleadosCollectionNewEmpleados : empleadosCollectionNew) {
                if (!empleadosCollectionOld.contains(empleadosCollectionNewEmpleados)) {
                    empleadosCollectionNewEmpleados.getTurnoCollection().add(turno);
                    empleadosCollectionNewEmpleados = em.merge(empleadosCollectionNewEmpleados);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = turno.getIdTurno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
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
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getIdTurno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Collection<Empleado> empleadosCollection = turno.getEmpleadosCollection();
            for (Empleado empleadosCollectionEmpleados : empleadosCollection) {
                empleadosCollectionEmpleados.getTurnoCollection().remove(turno);
                empleadosCollectionEmpleados = em.merge(empleadosCollectionEmpleados);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
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

    public Turno findTurno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
