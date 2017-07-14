package com.devil.defaultmethods;

/**
 * Created by zhangtong on 2017/7/13.
 */
public class TestSimpleTimeClient {
    public static void main(String[] args) {
        TimeClient myTimeClient = new SimpleTimeClient();
        System.out.println("Current time: " + myTimeClient.toString());
        System.out.println("Time in California: " +
                myTimeClient.getZonedDateTime("Blah blah").toString());
    }
}
