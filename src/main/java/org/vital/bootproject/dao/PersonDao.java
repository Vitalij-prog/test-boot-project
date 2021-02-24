package org.vital.bootproject.dao;

import org.vital.bootproject.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    int insertPerson(int id, Person person);

    default int insertPerson(Person person) {
        return insertPerson(person.getId(), person);
    }

    List<Person> selectPeople();

    Optional<Person> selectPersonById(int id);
    int deletePersonById(int id);
    int updatePersonById(int id, Person person);

}
