package org.vital.bootproject.dao;

import org.springframework.stereotype.Repository;
import org.vital.bootproject.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(int id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(int id) {
        return DB.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }

    @Override
    public int deletePersonById(int id) {
        Optional<Person> personMaybe  = selectPersonById(id);
        if(personMaybe.isPresent()) {
            DB.remove(personMaybe.get());
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updatePersonById(int id, Person newPerson) {
        return selectPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if(indexOfPersonToUpdate>= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id,  newPerson.getName()));
                        return 1;
                    } else {
                        return 0;
                    }
                }).orElse(0);
    }

}
