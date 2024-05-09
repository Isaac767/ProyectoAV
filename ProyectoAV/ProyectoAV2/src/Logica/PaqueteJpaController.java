/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Clases.Entrega;
import Clases.Paquete;
import Logica.exceptions.NonexistentEntityException;
import Logica.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class PaqueteJpaController implements Serializable {

    public PaqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paquete paquete) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrega entrega = paquete.getEntrega();
            if (entrega != null) {
                entrega = em.getReference(entrega.getClass(), entrega.getCodigo());
                paquete.setEntrega(entrega);
            }
            em.persist(paquete);
            if (entrega != null) {
                Paquete oldPaqueteOfEntrega = entrega.getPaquete();
                if (oldPaqueteOfEntrega != null) {
                    oldPaqueteOfEntrega.setEntrega(null);
                    oldPaqueteOfEntrega = em.merge(oldPaqueteOfEntrega);
                }
                entrega.setPaquete(paquete);
                entrega = em.merge(entrega);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaquete(paquete.getIdpaq()) != null) {
                throw new PreexistingEntityException("Paquete " + paquete + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete paquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete persistentPaquete = em.find(Paquete.class, paquete.getIdpaq());
            Entrega entregaOld = persistentPaquete.getEntrega();
            Entrega entregaNew = paquete.getEntrega();
            if (entregaNew != null) {
                entregaNew = em.getReference(entregaNew.getClass(), entregaNew.getCodigo());
                paquete.setEntrega(entregaNew);
            }
            paquete = em.merge(paquete);
            if (entregaOld != null && !entregaOld.equals(entregaNew)) {
                entregaOld.setPaquete(null);
                entregaOld = em.merge(entregaOld);
            }
            if (entregaNew != null && !entregaNew.equals(entregaOld)) {
                Paquete oldPaqueteOfEntrega = entregaNew.getPaquete();
                if (oldPaqueteOfEntrega != null) {
                    oldPaqueteOfEntrega.setEntrega(null);
                    oldPaqueteOfEntrega = em.merge(oldPaqueteOfEntrega);
                }
                entregaNew.setPaquete(paquete);
                entregaNew = em.merge(entregaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paquete.getIdpaq();
                if (findPaquete(id) == null) {
                    throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete paquete;
            try {
                paquete = em.getReference(Paquete.class, id);
                paquete.getIdpaq();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.", enfe);
            }
            Entrega entrega = paquete.getEntrega();
            if (entrega != null) {
                entrega.setPaquete(null);
                entrega = em.merge(entrega);
            }
            em.remove(paquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete> findPaqueteEntities() {
        return findPaqueteEntities(true, -1, -1);
    }

    public List<Paquete> findPaqueteEntities(int maxResults, int firstResult) {
        return findPaqueteEntities(false, maxResults, firstResult);
    }

    private List<Paquete> findPaqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete.class));
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

    public Paquete findPaquete(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete> rt = cq.from(Paquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
