package no.ntnu.idata2001.contacts.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Iterator;

public class AddressBookDBHandler implements AddressBook {

    private EntityManagerFactory entityManagerFactory;

    // When you create an EntityManager, you can specify the persistenceUnitName, which can be used to define what database you want to communicate with
    //In our case, we have three different persistence-units
    public AddressBookDBHandler(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("contacts_pu_mysql_db");
    }

    public void addContact(ContactDetails contact){
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            em.persist(contact);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(em);
        }
    }

    public void removeContact(String phoneNumber){
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            ContactDetails contact = em.find(ContactDetails.class, phoneNumber);
            em.remove(contact);
            em.getTransaction().commit();
        }finally {
            close(em);
        }
    }

    public Collection<ContactDetails> getAllContacts(){
        EntityManager em = getEM();
        try{
            Query q = em.createQuery("select object(o) from ContactDetails o");
            return q.getResultList();
        }finally {
            close(em);
        }
    }

    @Override
    public Iterator<ContactDetails> iterator() {
        EntityManager em = getEM();
        try{
            Query q = em.createQuery("select object(o) from ContactDetails o");
            return q.getResultList().iterator();
        }finally {
            close(em);
        }
    }

    public EntityManager getEM(){
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void close(EntityManager em){
        if(em != null && em.isOpen()){
            em.close();
        }
    }
}
