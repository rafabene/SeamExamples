package br.com.example.domain.repository;

import java.util.List;

import javax.ejb.Local;

import br.com.example.domain.entity.Person;

@Local
public interface PersonRepository {
    
    public List<Person> getAllPersons();
    
    public Person findById(Long id);

}
