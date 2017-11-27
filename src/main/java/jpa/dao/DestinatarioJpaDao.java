package jpa.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import model.Destinatario;

@Service
public class DestinatarioJpaDao {
	
	private static DestinatarioJpaDao instance;
    protected EntityManager entityManager;
    
    public static DestinatarioJpaDao getInstance(){
              if (instance == null){
                       instance = new DestinatarioJpaDao();
              }
              
              return instance;
    }

    private DestinatarioJpaDao() {
              entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public Destinatario getById(final int id) {
              return entityManager.find(Destinatario.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Destinatario> findAll() {
              return entityManager.createQuery("FROM " + Destinatario.class.getName()).getResultList();
    }

    public void persist(Destinatario destinatario) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(destinatario);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void merge(Destinatario destinatario) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(destinatario);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void remove(Destinatario destinatario) {
              try {
                       entityManager.getTransaction().begin();
                       destinatario = entityManager.find(Destinatario.class, destinatario.getId());
                       entityManager.remove(destinatario);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void removeById(final int id) {
              try {
                       Destinatario destinatario = getById(id);
                       remove(destinatario);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }

}
