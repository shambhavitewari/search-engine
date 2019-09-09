package com.springboot.project.searchengine;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserRepo repo;

    public Cache cac = new Cache();
    JSONParser parser = new JSONParser();

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repo.findAll();

    }

    @GetMapping("/jpa/{tech}/users")
    public String retrievefromTech(@PathVariable String tech) {

        if(cac.hash_map.containsKey(tech))
        {
            System.out.println("through hashmap");
            System.out.println("no. of elements n the hashmap ="+cac.hash_map.size());
          return cac.mapGet(tech);
        }


        else
        {

                    cac.hash_map.put(tech, repo.findByTech(tech).getFname());

                System.out.println("through repo");
          return cac.mapGet(tech);
        }

        //return repo.findByTech(tech);

    }
}
