package com.devil.interfaceDefault;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by zhangtong on 2017/7/13.
 */
public class ParallelArrays {
    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];
        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
        Integer[] integers = {30, 20, 50, 30, 40, 50};
        System.out.println(Arrays.binarySearch(integers, 50));
        Arrays.parallelSort(integers);
        Arrays.stream(integers).forEach(System
        .out::println);
    }
}
