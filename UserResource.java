package com.springboot.project.searchengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserResource {

@Autowired
 private UserRepo repo;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return repo.findAll();

    }

   /* @GetMapping("/jpa/fname/users")
    public void retrievefromFname(){
        System.out.println( repo.findbyFname("Diksha"));*/

}
