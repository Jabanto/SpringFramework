package com.collections.service;

import com.collections.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

@Service
public class CollectionManage {

    //Werte die sich wiederholen mit bestimmte Ordnung
    private List list;
    //Kann Objekte beinhalten egal Typ
    private Person[] personsArray;
    //Werte die nicht dupliziert sein sollen
    private Set totally;
    //name(key) und Wert ,die von alle Arten sein könnten.
    private Map map;
    //name(key) und Wert, die nur von Typ String sein sollen.
    private Properties properties;


    public void showList(){

        System.out.println("----Showing List------");
        for (Object object: list) {
            System.out.println(object.getClass() + ": " + object);
        }
    }

    public void showArray(){
        System.out.println("----Showing Array-----");
        for (Object object: personsArray) {
            System.out.println(object.getClass() + ": " + object);
        }
    }

    public void showTotally(){
        System.out.println("------Showing Totally-----");
        for (Iterator iterator = totally.iterator();iterator.hasNext();) {

            Object object = iterator.next();
            System.out.println(object.getClass() + ": " + object);
        }
    }

    public void showMap(){
        System.out.println("------Showing Map----");
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();){
            Object object= iterator.next();
            System.out.println("[Key] " + object.getClass() + ": " + object + ", [Value]"+ map.get(object).getClass() + ":  " +map.get(object));
        }
    }

    public void  showProperties(){
        System.out.println("\n------Showing Properties------");
        for (Iterator it = properties.keySet().iterator();it.hasNext();){
            Object object = it.next();
            System.out.println("[Key] " + object.getClass() + ": " +  object + ", [Value]"+properties.get(object).getClass() + ": " + properties.get(object));
        }

    }


    /**
     * Region Setter
     * @param list
     */
    public void setList(List list) {
        this.list = list;
    }

    public void setPersonsArray(Person[] personsArray) {
        this.personsArray = personsArray;
    }

    public void setTotally(Set totally) {
        this.totally = totally;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


}
