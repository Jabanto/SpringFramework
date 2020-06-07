package com.javanto.services.calculator.standard;

import com.javanto.services.calculator.Process;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Organization implements Process {


    @Override
    public Object execute() {

        List<Integer> integerList = new ArrayList<Integer>();

        integerList.add(9);
        integerList.add(3);
        integerList.add(2);
        integerList.add(8);
        integerList.add(7);
        integerList.add(10);

        Collections.sort(integerList);

        return integerList;
    }
}
