package com.devil.chap5;


import com.devil.chap4.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.devil.chap4.Dish.menu;
/**
 * Created by Devil on 2017/5/31.
 */
public class NumericStreams {

    public static void main(String[] args) {

        int calories = menu.stream().mapToInt(dish -> dish.getCalories()).sum();
        System.out.println("calories = " + calories);

        OptionalInt maxCalories = menu.stream().mapToInt(dish -> dish.getCalories()).max();
        int max =0;
        if (maxCalories.isPresent()){
            max = maxCalories.getAsInt();
        }
        System.out.println("maxCalories = " + maxCalories);
        System.out.println("max = " + max);

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> integerStream = intStream.boxed();
        
        IntStream evenNumber = IntStream.rangeClosed(0,100).filter(num -> num %2 ==0);
        System.out.println("evenNumber.count() = " + evenNumber.count());
    }
}
