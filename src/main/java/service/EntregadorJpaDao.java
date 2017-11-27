package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import model.Entregador;


@Service
public class EntregadorJpaDao {
	
	private static EntregadorJpaDao instance;
    protected EntityManager entityManager;
    
    public static EntregadorJpaDao getInstance(){
              if (instance == null){
                       instance = new EntregadorJpaDao();
              }
              
              return instance;
    }

    private EntregadorJpaDao() {
              entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public Entregador getById(final int id) {
              return entityManager.find(Entregador.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Entregador> findAll() {
              return entityManager.createQuery("FROM " + Entregador.class.getName()).getResultList();
    }

    public void persist(Entregador entregador) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(entregador);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void merge(Entregador entregador) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(entregador);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void remove(Entregador entregador) {
              try {
                       entityManager.getTransaction().begin();
                       entregador = entityManager.find(Entregador.class, entregador.getId());
                       entityManager.remove(entregador);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void removeById(final int id) {
              try {
            	  Entregador entregador = getById(id);
                       remove(entregador);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }


}
