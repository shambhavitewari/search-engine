package com.springboot.project.searchengine;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {



    public int max =10;
         LinkedHashMap<String, String> hash_map = new LinkedHashMap<String, String>(max+1,0.75f,true)
         {
             @Override
             public boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                 return size()>max;
             }
         };

        public void mapAdd (String tech, String fname)
        {

            hash_map.put(tech, fname);
        }

        public String mapGet (String tech){

            return hash_map.get(tech);

        }

}
