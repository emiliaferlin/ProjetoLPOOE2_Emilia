/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.estacione.dao;

import br.edu.ifsul.cc.lpoo.estacione.model.Carro;
import br.edu.ifsul.cc.lpoo.estacione.model.Estacionamento;
import br.edu.ifsul.cc.lpoo.estacione.model.Ticket;
import br.edu.ifsul.cc.lpoo.estacione.model.Vaga;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mili
 */
public class PersistenciaJPA implements InterfacePersistencia{
    
    public EntityManagerFactory factory;    //fabrica de gerenciadores de entidades
    public EntityManager entity;            //gerenciador de entidades JPA

    public PersistenciaJPA() {
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory = Persistence.createEntityManagerFactory("pu_Estacione2");
        //conecta no bd e executa a estratégia de geração.
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        EntityManager em = getEntityManager();
        return em.find(c, id);//encontra um determinado registro 
    }

    @Override
    public void persist(Object o) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    /*
    Todos os métodos agora chamam getEntityManager() para garantir que o EntityManager esteja sempre aberto e pronto para uso.
     */
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }
    
    

    public void update(Object o) throws Exception {
        
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        //No método remover, antes de chamar remove, usamos merge se o objeto não estiver gerenciado.
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(o)) {
                o = em.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            }
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }
    
    public List<Vaga> listaVagas() {
        EntityManager em = getEntityManager();
         try {
           return em.createNamedQuery("Vaga.orderbyid").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       
    }
    
    public List<Carro> listaCarros() {
        EntityManager em = getEntityManager();
         try {
           return em.createNamedQuery("Carro.orderbyid").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       
    }
    
    public List<Ticket> listaTicktes() {
        EntityManager em = getEntityManager();
         try {
           return em.createNamedQuery("Ticket.orderbyid").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       
    }
    
    public List<Estacionamento> getEstacione() {
        EntityManager em = getEntityManager();
         try {
           return em.createNamedQuery("Estacionamento.orderbyid").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       
    }
    
}
