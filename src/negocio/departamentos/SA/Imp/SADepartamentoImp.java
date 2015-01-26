/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.departamentos.SA.Imp;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import negocio.departamentos.Departamento;
import negocio.departamentos.SA.SADepartamento;
import negocio.empleados.Supervisor;
import negocio.empleados.Trabajador;


public class SADepartamentoImp implements SADepartamento {

  
    @Override
    public int altaDepartamento(Departamento departamento) 
    {
        departamento.setIdDepartamento(-1);
        
        EntityManager em = null;
        EntityManagerFactory ef = null;
        try 
        {
            ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
            
            em.getTransaction().begin();
            
            Departamento departamentoAux = null;
            
            List results = em.createNamedQuery("Departamento.findByNombre")
            .setParameter("nombre", departamento.getNombre())
            .getResultList();
            
            if (results.size() > 0)
                departamentoAux = (Departamento)results.get(0);
            
            if (departamentoAux != null)
            {
                if (!departamentoAux.getDisponible())
                {
                    departamentoAux.setDisponible(true);
                    em.merge(departamentoAux);
                    departamento.setIdDepartamento(departamentoAux.getIdDepartamento());
                    em.getTransaction().commit();
                }
                else
                {
                    System.out.println("Ya existe el departamento");
                    em.getTransaction().rollback();
                }
            }            
            else
            {
                em.persist(departamento);
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
        
        return departamento.getIdDepartamento();
    }

    @Override
    public boolean modificarDepartamento(Departamento departamento)
    {
        boolean correcto = true;
        EntityManager em = null;
        EntityManagerFactory ef =null;
        try {
           
            ef= Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
        
            em.getTransaction().begin();
            Departamento d= em.find(Departamento.class, departamento.getIdDepartamento(),LockModeType.OPTIMISTIC);
            
            if (d!=null)
            {
                em.lock(d, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
                
                em.merge(departamento);
                em.getTransaction().commit();
                
            }
          
        } 
        catch (Exception ex) 
        {
            correcto = false;
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) 
            {
                Integer id = departamento.getIdDepartamento();
                if (mostrarDepartamento(id) == null) 
                {
                    System.out.println("El departamento con id " + id + " no existe.");
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
    public boolean bajaDepartamento(int id)
    {
        EntityManager em = null;
        boolean correcto = false;
        try {
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
            em = ef.createEntityManager();
            em.getTransaction().begin();
            Departamento persistentDepartamento = em.find(Departamento.class, id);
            
            List results = em.createNamedQuery("Empleado.findByDepartamento")
            .setParameter("dep", persistentDepartamento)
            .getResultList();
            
            if (results.size() == 0 && persistentDepartamento.isDisponible())
            {
                persistentDepartamento.setDisponible(false);
                em.merge(persistentDepartamento);
                em.getTransaction().commit();
                correcto = true;
            }
            else
            {
                System.out.println("No se puede dar de baja un departamento con empleados asociados");
                em.getTransaction().rollback();
            }
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
    public ArrayList<Departamento> mostrarListaDepartamentos() 
    {
        return new ArrayList<Departamento>(findDepartamentoEntities(true, -1, -1));
    }

    private List<Departamento> findDepartamentoEntities(int maxResults, int firstResult) {
        return findDepartamentoEntities(false, maxResults, firstResult);
    }

    private List<Departamento> findDepartamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Departamento.class));
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

    @Override
    public Departamento mostrarDepartamento(int id) 
    {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        
        try 
        {
            
            Departamento d= em.find(Departamento.class, id);
            em.detach(d);
            return d;
        } 
        finally 
        {
            em.close();
            ef.close();
        }
    }
    
    @Override
    public double nominaPorDepartamento(int id) {
        List<Trabajador> trabajadores = findTrabajadoresEntities(true, -1, -1);
        List<Supervisor> supervisores = findSupervisorEntities(true, -1, -1);
        double ret = 0.0;                      
        for (Trabajador t : trabajadores )
        {
            if (t.getDisponible() && t.getDepartamento().getIdDepartamento() == id)
            {                
                ret += t.getSueldo() * t.getHoras_trabajadas();
            }
        }
        for (Supervisor s : supervisores)
        {
            if (s.getDisponible()&& s.getDepartamento().getIdDepartamento() == id)
            {
                ret += s.getSueldo() * s.getFactor_productividad();
            }
        }
        return ret;                                                  
    }
    
    private List<Trabajador> findTrabajadoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Trabajador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            if (em != null)             
                em.close();           
            if (ef != null)
                ef.close();
        }
    }
    
    private List<Supervisor> findSupervisorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Supervisor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            if (em != null)             
                em.close();           
            if (ef != null)
                ef.close();
        }
    }

    public int getDepartamentoCount() 
    {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("MerkaSoftPU");
        em = ef.createEntityManager();
        
        try 
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Departamento> rt = cq.from(Departamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } 
        finally 
        {
            em.close();
        }
    }
    
    public static void main(String args[])
    {
        SADepartamentoImp sa = new SADepartamentoImp();
        
        System.out.println(sa.nominaPorDepartamento(1));        
        /*
        Departamento dep = new Departamento();
        dep.setNombre("Bababuiiii2");
        dep.setDescripcion("MUYY BABABUUUII");
        dep.setDisponible(true);
        sa.altaDepartamento(dep);
                
        
        
        Departamento dep = new Departamento();
        dep.setIdDepartamento(1);
        dep.setNombre("BABABUIIIII3");
        sa.modificarDepartamento(dep);
        System.out.println("BABABUUUUUIII");*/
                
        
    }
    
}
