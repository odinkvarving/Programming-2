package no.ntnu.idata2001.contacts.model;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Iterator;

public interface AddressBook {

    void addContact(ContactDetails contact);

    void removeContact(String phoneNumber);

    Collection<ContactDetails> getAllContacts();

    Iterator<ContactDetails> iterator();

    void close(EntityManager em);
}
