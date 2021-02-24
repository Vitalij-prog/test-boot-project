package org.vital.bootproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vital.bootproject.model.User;

import java.util.Optional;

@Repository("mysql_db")
public interface UserRepository extends CrudRepository<User, Integer> {
}
