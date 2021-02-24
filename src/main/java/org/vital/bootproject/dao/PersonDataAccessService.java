package org.vital.bootproject.dao;

import org.springframework.stereotype.Repository;
import org.vital.bootproject.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("mysql")
public class PersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(int id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectPeople() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(1, "from mysql"));
        return list ;
    }

    @Override
    public Optional<Person> selectPersonById(int id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(int id) {
        return 0;
    }

    @Override
    public int updatePersonById(int id, Person person) {
        return 0;
    }
}
