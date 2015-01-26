/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.empleados.SA.Imp;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import negocio.departamentos.Departamento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import negocio.empleados.Empleado;
import negocio.empleados.SA.SAEmpleado;


public class SAEmpleadoImp implements SAEmpleado {

    

    public SAEmpleadoImp() 
    {
    }

   
    @Override
    public int altaEmpleado(Empleado empleado) 
    {
        empleado.setIdEmpleado(-1);
        
        EntityManager em = null;
        EntityManagerFactory ef = null;
        try 
        {
            ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
            
            em.getTransaction().begin();
            
            Empleado empleadoAux = null;
            
            List results = em.createNamedQuery("Empleado.findByDni")
            .setParameter("dni", empleado.getDni())
            .getResultList();
            
            if (results.size() > 0)
                empleadoAux = (Empleado)results.get(0);
            
            if (empleadoAux != null)
            {
                if (!empleadoAux.getDisponible())
                {
                    empleadoAux.setDisponible(true);
                    em.merge(empleadoAux);
                    empleado.setIdEmpleado(empleadoAux.getIdEmpleado());
                    em.getTransaction().commit();
                }
                else
                {
                    System.out.println("Ya existe el empleado");
                    em.getTransaction().rollback();
                }
            }            
            else
            {
                em.persist(empleado);
                em.getTransaction().commit();
            }
            
           
        } 
        finally 
        {
            if (em != null)             
                em.close();           
            if (ef != null)
                ef.close();
        }
        
        return empleado.getIdEmpleado();
    }

    @Override
    public boolean modificarEmpleado(Empleado empleado)
    {
         boolean correcto = true;
        EntityManager em = null;
        EntityManagerFactory ef =null;
        try {
           
            ef= Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
        
            em.getTransaction().begin();
            Empleado d= em.find(Empleado.class, empleado.getIdEmpleado(),LockModeType.OPTIMISTIC);
            
            if (d!=null)
            {
                em.lock(d, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
                
                em.merge(empleado);
                em.getTransaction().commit();
                
            }
          
        } 
        catch (Exception ex) 
        {
            correcto = false;
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) 
            {
                Integer id = empleado.getIdEmpleado();
                if (mostrarEmpleado(id) == null) 
                {
                    System.out.println("El empleado con id " + id + " no existe.");
                }
            }
           
        } 
        finally 
        {
            if (em != null) 
            {
                em.close();
            }
           
            if (ef!=null) ef.close();
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
            if (em != null)             
                em.close();           
            if (ef != null)
                ef.close();
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
        EntityManagerFactory ef = null;
        boolean correcto = true;        
        try {
             ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
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
            if (em != null)             
                em.close();           
            if (ef != null)
                ef.close();
        }
        return correcto;
    }
    

    
   

    private List<Empleado> findEmpleadosEntities(int maxResults, int firstResult) 
    {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        try 
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        }
        
        finally 
        {
            if (em != null)             
                em.close();           
            if (ef != null)
                ef.close();
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
}
