package com.example.devSecOps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ServiceWeb {

    ArrayList<car>cars = new ArrayList<car>();

    public ServiceWeb() {
        car car = new car("AA11BB", "ferrari", 2000);
        cars.add(car);
        car = new car("BB22CC", "porsche", 1000);
        cars.add(car);
        car = new car("CC33DD", "peugeot", 500);
        cars.add(car);
    }


    @GetMapping("/cars/{plateNumber}")
    public car disBonjour(@PathVariable("plateNumber") String plaque){
        int i=0;
        while(i<cars.size() && !cars.get(i).getPlateNumber().equals(plaque)){
            i++;
        }
        if(i < cars.size()){
            return cars.get(i);
        } else {
            return null;
        }
    }
}