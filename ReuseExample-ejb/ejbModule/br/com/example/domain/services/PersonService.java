package br.com.example.domain.services;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.example.domain.entity.Person;
import br.com.example.domain.exception.IllegalPersonNumberException;

@Local
@Path("/people")
public interface PersonService {

    @GET
    @Path("/")
    @Produces("application/xml")
    public List<Person> getAllPerson();
    
    @GET
    @Path("/{personId}")
    @Produces("application/json")
    public Person getPersonById(@PathParam("personId") Long id) throws IllegalPersonNumberException;
    
    
    public String getPersonNameById(Long id) throws IllegalPersonNumberException;
    
}
