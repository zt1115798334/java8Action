package com.devil.chap2;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Devil on 2017/5/17.
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        List<Apple> greenApples = filter(inventory,new AppleGreenPredicate());
        System.out.println(greenApples);

        List<Apple> heavyApples = filter(inventory,new AppleWeightPredicate());
        System.out.println(heavyApples);

        List<Apple> greenAndHeavyAppls = filter(inventory,new AppleGreenAndHeavyPredicate());
        System.out.println(greenAndHeavyAppls);
    }

    public  static  List<Apple> filter(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = Lists.newArrayList();
        for (Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate {
        public boolean test(Apple p);
    }

    static class AppleWeightPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple p) {
            return p.getWeight() > 150;
        }
    }

    static class AppleGreenPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple p) {
            return "green".equals(p.getColor());
        }
    }

    static class AppleGreenAndHeavyPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple p) {
            return "green".equals(p.getColor()) && p.getWeight() > 150;
        }
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
