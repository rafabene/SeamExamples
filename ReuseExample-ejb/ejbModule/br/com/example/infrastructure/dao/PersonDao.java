package br.com.example.infrastructure.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import br.com.example.domain.entity.Person;
import br.com.example.domain.repository.PersonRepository;

@Name("personRepository")
@AutoCreate
@Stateless
public class PersonDao implements PersonRepository {
    
    public static final String FIND_ALL_QUERY = "SELECT p FROM Person p";
    public static final String FIND_ALL_QNAME = "person.findAll";

    //@PersistenceContext
    @In
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {
        return entityManager.createNamedQuery(FIND_ALL_QNAME).getResultList();
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

}
