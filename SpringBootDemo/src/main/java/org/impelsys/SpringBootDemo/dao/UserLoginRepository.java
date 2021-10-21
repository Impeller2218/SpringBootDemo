package org.impelsys.SpringBootDemo.dao;

import org.impelsys.SpringBootDemo.model.userLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserLoginRepository extends CrudRepository<userLogin, Integer> {
}
