package com.devil.chap8;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 观察者模式
 * Created by zhangtong on 2017/7/7.
 */
public class ObserverMain {

    interface Observer{
        void inform(String tweet);
    }
    interface Subject{
        void registerObserver(Observer observer);
        void notifyObservers(String tweet);
    }

    static private class NYTimes implements Observer{

        @Override
        public void inform(String tweet) {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY!" + tweet);
            }
        }
    }

    static private class Guardian implements Observer{

        @Override
        public void inform(String tweet) {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet another news in London... " + tweet);
            }
        }
    }

    static private class LeMonde implements Observer{

        @Override
        public void inform(String tweet) {
            if(tweet != null && tweet.contains("wine")){
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        }
    }

    static private class Feed implements Subject{

        private List<Observer> list = Lists.newArrayList();

        @Override
        public void registerObserver(Observer observer) {
            this.list.add(observer);
        }

        @Override
        public void notifyObservers(String tweet) {
            this.list.forEach(observer -> observer.inform(tweet));
        }
    }

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");


        Feed feedLambda = new Feed();

        feedLambda.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet); }
        });
        feedLambda.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet another news in London... " + tweet); }
        });

        feedLambda.notifyObservers("Money money money, give me money!");
    }
}
