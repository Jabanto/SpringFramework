package com.collections;

import com.collections.service.CollectionManage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        /**
         * DI injection
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.collections");
        CollectionManage collectionManage = applicationContext.getBean("collectionManage",CollectionManage.class);
        collectionManage.showList();
        collectionManage.showArray();
        collectionManage.showTotally();
        collectionManage.showMap();
        collectionManage.showProperties();
    }


}
