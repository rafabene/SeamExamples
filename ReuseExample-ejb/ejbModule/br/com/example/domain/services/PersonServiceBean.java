package br.com.example.domain.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import br.com.example.domain.entity.Person;
import br.com.example.domain.exception.IllegalPersonNumberException;
import br.com.example.domain.repository.PersonRepository;

@Stateless
@Name("personService")
@AutoCreate
@WebService(name="PersonService", serviceName="PersonService")
public class PersonServiceBean implements PersonService{

    @In
    private PersonRepository personRepository;


    public List<Person> getAllPerson(){
        return personRepository.getAllPersons();
    }

    public Person getPersonById(Long id) throws IllegalPersonNumberException{
        Person p = personRepository.findById(id);
        if (p!= null){
            return p;
        }else{
            throw new IllegalPersonNumberException("No person with this id");
        }
    }

    @WebMethod
    public String getPersonNameById(Long id) throws IllegalPersonNumberException {
        Person p = getPersonById(id);
        return p.getName();
    }

}
