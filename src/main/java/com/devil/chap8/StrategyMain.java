package com.devil.chap8;

/**
 * 策略模式
 * Created by zhangtong on 2017/7/7.
 */
public class StrategyMain {


    interface ValidationStrategy {
        boolean execute(String s);
    }

    static private class IsAllLowerCase implements ValidationStrategy {

        @Override
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    static private class IsNumeric implements ValidationStrategy {

        @Override
        public boolean execute(String s) {
            return false;
        }
    }

    static private class Validator {
        private ValidationStrategy strategy;

        public Validator(ValidationStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean validate(String s) {
            return strategy.execute(s);
        }
    }

    public static void main(String[] args) {
        Validator v1 = new Validator(new IsAllLowerCase());
        System.out.println(v1.validate("aaa"));
        Validator v2 = new Validator(new IsNumeric());
        System.out.println(v2.validate("bbb"));
    }
}
