package com.springboot.project.searchengine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

 /*List<User> findbyFname(String Fname);*/
}
