package com.springboot.project.searchengine;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
    public List<String> retrievefromTech(@PathVariable String tech) {

        if(cac.hash_map.containsKey(tech))
        {
            System.out.println("through hashmap");
            System.out.println("no. of elements in the hashmap ="+cac.hash_map.size());
            return cac.mapGet(tech);
        }


        else
        {
            List<User> lsUser = repo.findByTech(tech);
            List<String> lsFname = new ArrayList<String>();
            Iterator iteratorUser = lsUser.iterator();
            //ListIterator iteratorFname;
            while(iteratorUser.hasNext()) {
                User user = (User) iteratorUser.next();
                //System.out.println(user.getFname());
                lsFname.add(user.getFname());
             }
                cac.hash_map.put(tech, lsFname);
                System.out.println(cac.mapGet(tech));
            }

            //cac.hash_map.put(tech,);
            System.out.println("through repo");
            //System.out.println(cac.mapGet(tech));
             return cac.mapGet(tech);
            //return "working";
        }

        //return repo.findByTech(tech);

    }
