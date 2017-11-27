package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import model.Entrega;


@Service
public class EntregaJpaDao {
	
	private static EntregaJpaDao instance;
    protected EntityManager entityManager;
    
    public static EntregaJpaDao getInstance(){
              if (instance == null){
                       instance = new EntregaJpaDao();
              }
              
              return instance;
    }

    private EntregaJpaDao() {
              entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public Entrega getById(final int id) {
              return entityManager.find(Entrega.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Entrega> findAll() {
              return entityManager.createQuery("FROM " + Entrega.class.getName()).getResultList();
    }

    public void persist(Entrega entrega) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(entrega);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void merge(Entrega entrega) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(entrega);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void remove(Entrega entrega) {
              try {
                       entityManager.getTransaction().begin();
                       entrega = entityManager.find(Entrega.class, entrega.getId());
                       entityManager.remove(entrega);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void removeById(final int id) {
              try {
            	  Entrega entrega = getById(id);
                       remove(entrega);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }

}
