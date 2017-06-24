package com.devil.chap4;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Devil on 2017/5/23.
 */
public class StreamBasic {


    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        List<String> threeHighCaloriesDishName = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(threeHighCaloriesDishName);

        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println(vegetarianMenu);
        List<Integer> numbers = Arrays.asList(1, 5, 6, 6, 4, 5, 8, 1, 3, 5, 45, 6, 315, 45, 88, 88);
        numbers.stream().filter(integer -> integer % 2 == 0).distinct().forEach(System.out::print);
        menu.stream().map(Dish::getName).map(String::length).forEach(System.out::print);
        String[] arraysWord = {"java8 index", "word"};
        Stream<String> stringStream = Arrays.stream(arraysWord);
        stringStream.map(word->word.split("")).map(Arrays::stream).distinct().forEach(System.out::print);



    }

}
