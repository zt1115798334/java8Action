package com.devil.chap6;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static com.devil.chap6.Dish.dishTags;
import static com.devil.chap6.Dish.menu;
/**
 * Created by Devil on 2017/6/24.
 */
public class Grouping {
    enum CaloricLevel { DIET, NORMAL, FAT };
    public static void main(String ... args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType());
//        System.out.println("Dish names grouped by type: " + groupDishNamesByType());
//        System.out.println("Dish tags grouped by type: " + groupDishTagsByType());
//        System.out.println("Caloric dishes grouped by type: " + groupCaloricDishesByType());
        System.out.println("Dishes grouped by caloric level: " + groupDishesByCaloricLevel());
//        System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel());
        System.out.println("Count dishes in groups: " + countDishesInGroups());
//        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByType());
//        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByTypeWithoutOprionals());
//        System.out.println("Sum calories by type: " + sumCaloriesByType());
//        System.out.println("Caloric levels by type: " + caloricLevelsByType());
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType(){
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    private static Map<CaloricLevel,List<Dish>> groupDishesByCaloricLevel(){
        return menu.stream().collect(
                groupingBy(dish->{
                    if(dish.getCalories()<=400) return CaloricLevel.DIET;
                    else if(dish.getCalories()<=700) return CaloricLevel.NORMAL;
                    return CaloricLevel.FAT;
                })
        );
    }

    private static  Map<Dish.Type, Long> countDishesInGroups(){
        return menu.stream().collect(groupingBy(Dish::getType,counting()));
    }

}
