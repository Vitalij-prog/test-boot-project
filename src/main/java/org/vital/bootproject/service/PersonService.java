package org.vital.bootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.vital.bootproject.dao.PersonDao;
import org.vital.bootproject.model.Person;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonDao dao;

    @Autowired
    public PersonService(@Qualifier("mysql") PersonDao dao) {
        this.dao = dao;
    }


    public int addPerson(Person person){
        return dao.insertPerson(person);
    }

    public List<Person> selectPeople() {
        return dao.selectPeople();
    }

    public Optional<Person> getPersonById(int id) {
        return dao.selectPersonById(id);
    }

    public int deletePersonById(int id) {
        return dao.deletePersonById(id);
    }

    public int updatePersonById(int id, Person newPerson) {
        return dao.updatePersonById(id, newPerson);
    }
}
