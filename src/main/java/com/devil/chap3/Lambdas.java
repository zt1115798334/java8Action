package com.devil.chap3;

import java.util.*;

public class Lambdas {
    public static void main(String... args) {


        Runnable r = () -> System.out.println("Hello!");
        r.run();


        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));


        List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples);

        Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        inventory.sort(c);
        System.out.println(inventory);

        inventory.set(1, new Apple(10, "red"));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    interface ApplePredicate {
        public boolean test(Apple a);
    }
}