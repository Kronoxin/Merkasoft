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
import javax.persistence.Persistence;
import negocio.turnos.SA.SATurno;
import negocio.turnos.Turno;

/**
 *
 * @author Ruben
 */
public class SATurnoImp implements SATurno {

    
    public SATurnoImp() {
       }

   

    @Override
    public int altaTurno(Turno turno) {       
        EntityManager em = null;
        try 
        {
           
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
        
            em.getTransaction().begin();
                        
            
            em.persist(turno);            
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return turno.getIdTurno(); 
    }

    @Override
    public boolean bajaTurno(int id) {
        EntityManager em = null;
        boolean correcto = true;
        try {
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, id);
            
            persistentTurno.setDisponible(false); 
            em.merge(persistentTurno);
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

    @Override
    public boolean modificarTurno(Turno turno) {
        EntityManager em = null;
        boolean ret = true;
        try 
        {
           
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();      
            em.getTransaction().begin();            
            em.merge(turno);            
            em.getTransaction().commit();
        } finally {
            ret = false;
            if (em != null) {
                em.close();
            }
        }
        return ret; 
    }

    @Override
    public Turno mostrarTurno(int id) 
    {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        
        try 
        {
            return em.find(Turno.class, id);
        } 
        finally 
        {
            em.close();
        }
    }

    @Override
    public ArrayList<Turno> mostrarListaTurnos() {
        return new ArrayList<Turno>(findTurnoEntities(true, -1, -1));
    }
    
    
    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
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


    
}
