package com.devil.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Devil on 2017/5/31.
 */
public class ReduceTest {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 6, 6, 4, 5, 8, 1, 3, 5, 45, 6, 315, 45, 88, 88);

        int sum = numbers.stream().reduce(0, (a, b) -> a+b);
        System.out.println(sum);

        int sum1 = numbers.stream().reduce(1, Integer::sum);
        System.out.println(sum1);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("max = " + max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("min = " + min);

        List<Dish> menu = Dish.menu;
        int countDish = menu.stream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println("countDish = " + countDish);

    }
}
