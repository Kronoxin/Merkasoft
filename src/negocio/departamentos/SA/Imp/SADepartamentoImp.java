/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.departamentos.SA.Imp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import negocio.departamentos.Departamento;
import negocio.departamentos.SA.SADepartamento;
import negocio.empleados.Empleado;
import negocio.turnos.SA.exceptions.NonexistentEntityException;


public class SADepartamentoImp implements SADepartamento {

  
    @Override
    public int altaDepartamento(Departamento departamento) 
    {
        if (departamento.getEmpleadosCollection() == null) {
            departamento.setEmpleadosCollection(new ArrayList<Empleado>());
        }
        EntityManager em = null;
        try 
        {
           
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("merkasoft");
            em = ef.createEntityManager();
        
            em.getTransaction().begin();
            Collection<Empleado> attachedEmpleadosCollection = new ArrayList<Empleado>();
            for (Empleado empleadosCollectionEmpleadosToAttach : departamento.getEmpleadosCollection()) {
                empleadosCollectionEmpleadosToAttach = em.getReference(empleadosCollectionEmpleadosToAttach.getClass(), empleadosCollectionEmpleadosToAttach.getIdEmpleado());
                attachedEmpleadosCollection.add(empleadosCollectionEmpleadosToAttach);
            }
            departamento.setEmpleadosCollection(attachedEmpleadosCollection);
            em.persist(departamento);
            for (Empleado empleadosCollectionEmpleados : departamento.getEmpleadosCollection()) {
                Departamento oldDepartamentoOfEmpleadosCollectionEmpleados = empleadosCollectionEmpleados.getDepartamento();
                empleadosCollectionEmpleados.setDepartamento(departamento);
                empleadosCollectionEmpleados = em.merge(empleadosCollectionEmpleados);
                if (oldDepartamentoOfEmpleadosCollectionEmpleados != null) {
                    oldDepartamentoOfEmpleadosCollectionEmpleados.getEmpleadosCollection().remove(empleadosCollectionEmpleados);
                    oldDepartamentoOfEmpleadosCollectionEmpleados = em.merge(oldDepartamentoOfEmpleadosCollectionEmpleados);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return departamento.getIdDepartamento();
    }

    @Override
    public boolean modificarDepartamento(Departamento departamento)
    {
        boolean correcto = true;
        EntityManager em = null;
        try {
           
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("merkasoft");
            em = ef.createEntityManager();
        
            em.getTransaction().begin();
            Departamento persistentDepartamento = em.find(Departamento.class, departamento.getIdDepartamento());
            Collection<Empleado> empleadosCollectionOld = persistentDepartamento.getEmpleadosCollection();
            Collection<Empleado> empleadosCollectionNew = departamento.getEmpleadosCollection();
            Collection<Empleado> attachedEmpleadosCollectionNew = new ArrayList<Empleado>();
            for (Empleado empleadosCollectionNewEmpleadosToAttach : empleadosCollectionNew) {
                empleadosCollectionNewEmpleadosToAttach = em.getReference(empleadosCollectionNewEmpleadosToAttach.getClass(), empleadosCollectionNewEmpleadosToAttach.getIdEmpleado());
                attachedEmpleadosCollectionNew.add(empleadosCollectionNewEmpleadosToAttach);
            }
            empleadosCollectionNew = attachedEmpleadosCollectionNew;
            departamento.setEmpleadosCollection(empleadosCollectionNew);
            departamento = em.merge(departamento);
            for (Empleado empleadosCollectionOldEmpleados : empleadosCollectionOld) {
                if (!empleadosCollectionNew.contains(empleadosCollectionOldEmpleados)) {
                    empleadosCollectionOldEmpleados.setDepartamento(null);
                    empleadosCollectionOldEmpleados = em.merge(empleadosCollectionOldEmpleados);
                }
            }
            for (Empleado empleadosCollectionNewEmpleados : empleadosCollectionNew) {
                if (!empleadosCollectionOld.contains(empleadosCollectionNewEmpleados)) {
                    Departamento oldDepartamentoOfEmpleadosCollectionNewEmpleados = empleadosCollectionNewEmpleados.getDepartamento();
                    empleadosCollectionNewEmpleados.setDepartamento(departamento);
                    empleadosCollectionNewEmpleados = em.merge(empleadosCollectionNewEmpleados);
                    if (oldDepartamentoOfEmpleadosCollectionNewEmpleados != null && !oldDepartamentoOfEmpleadosCollectionNewEmpleados.equals(departamento)) {
                        oldDepartamentoOfEmpleadosCollectionNewEmpleados.getEmpleadosCollection().remove(empleadosCollectionNewEmpleados);
                        oldDepartamentoOfEmpleadosCollectionNewEmpleados = em.merge(oldDepartamentoOfEmpleadosCollectionNewEmpleados);
                    }
                }
            }
            em.getTransaction().commit();
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
                    System.out.println("The departamento with id " + id + " no longer exists.");
                }
            }
           
        } 
        finally 
        {
            if (em != null) 
            {
                em.close();
            }
        }
        return correcto;
    }
    
    
    @Override
    public boolean bajaDepartamento(int id)
    {
        EntityManager em = null;
        boolean correcto = true;
        try {
            EntityManagerFactory ef = Persistence.createEntityManagerFactory("merkasoft");
            em = ef.createEntityManager();
            em.getTransaction().begin();
            Departamento persistentDepartamento = em.find(Departamento.class, id);
            
            persistentDepartamento.setDisponible(false);
            em.merge(persistentDepartamento);
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
    public ArrayList<Departamento> mostrarListaDepartamentos() 
    {
        return new ArrayList<Departamento>(findDepartamentoEntities(true, -1, -1));
    }

    private List<Departamento> findDepartamentoEntities(int maxResults, int firstResult) {
        return findDepartamentoEntities(false, maxResults, firstResult);
    }

    private List<Departamento> findDepartamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("merkasoft");
        
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
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("merkasoft");
        em = ef.createEntityManager();
        
        try 
        {
            return em.find(Departamento.class, id);
        } 
        finally 
        {
            em.close();
        }
    }

    public int getDepartamentoCount() 
    {
        EntityManager em = null;
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("merkasoft");
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
        
        Departamento dep = new Departamento();
        dep.setNombre("Bababuiiii");
        dep.setDescripcion("MUYY BABABUUUII");
        dep.setDisponible(true);
        sa.altaDepartamento(dep);
        System.out.println("SASASASASA");
    }
    
}
