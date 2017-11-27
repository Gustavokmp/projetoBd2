package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import model.Empresa;

@Service
public class EmpresaJpaDao {
	
	private static EmpresaJpaDao instance;
    protected EntityManager entityManager;
    
    public static EmpresaJpaDao getInstance(){
              if (instance == null){
                       instance = new EmpresaJpaDao();
              }
              
              return instance;
    }

    private EmpresaJpaDao() {
              entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public Empresa getById(final int id) {
              return entityManager.find(Empresa.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Empresa> findAll() {
              return entityManager.createQuery("FROM " + Empresa.class.getName()).getResultList();
    }

    public void persist(Empresa empresa) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(empresa);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void merge(Empresa empresa) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(empresa);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void remove(Empresa empresa) {
              try {
                       entityManager.getTransaction().begin();
                       empresa = entityManager.find(Empresa.class, empresa.getId());
                       entityManager.remove(empresa);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void removeById(final int id) {
              try {
                       Empresa empresa = getById(id);
                       remove(empresa);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }

}
