package com.collections.configuration;

import com.collections.beans.Person;
import com.collections.service.CollectionManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class ConfigurationBeans {

@Autowired
private CollectionManage collectionManage;

    @Bean
    public Person person1(){

        Person person = new Person();
        person.setAge(19);
        person.setName("magdalena");
        return person;
    }

    @Bean
    public Person person2(){

        Person person = new Person();
        person.setAge(25);
        person.setName("alejandro");
        return person;
    }

    @Bean
    public Person person3(){

        Person person = new Person();
        person.setAge(10);
        person.setName("neue");
        return person;
    }


    @Bean
    public CollectionManage collectionManageM(){

        //List
        List<Person> list = new ArrayList<Person>();
        list.add(person1());
        list.add(person2());

        //Array
        Person[] personArray = new Person[3];
        personArray[0] = person1();
        personArray[1] = person2();
        personArray[2] = person3();

        //Set
        Set totallySet = new HashSet();
        totallySet.add(person2());
        totallySet.add(person1());
        totallySet.add(person1());
        totallySet.add(person2());
        //Map

        Map<Object,String> map = new HashMap<Object, String>();
        map.put(person1(),"person1");
        map.put(person2(),"another Person");
        map.put("","another Person");
        map.put(person1(),"person2");

        //Property

        Properties properties = new Properties();
        properties.put("person1",person1().toString());
        properties.put(person2().toString(),"another Person");
        properties.put("without Person","any Person");
        properties.put(person1().toString(),person2().toString());


        //Add in Service
        collectionManage.setProperties(properties);
        collectionManage.setMap(map);
        collectionManage.setTotally(totallySet);
        collectionManage.setList(list);
        collectionManage.setPersonsArray(personArray);

        return collectionManage;
    }



}
