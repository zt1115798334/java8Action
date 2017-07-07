package com.devil.chap8;

import java.util.function.Consumer;

/**
 * 模板方法
 * Created by zhangtong on 2017/7/7.
 */
public class OnlineBankingLambda {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(10,(Customer a)->System.out.println("123"));
    }

    public void processCustomer(int i, Consumer<Customer> makeCustomerHappy){
        Customer customer = Database.getCustomerWithId(i);
        makeCustomerHappy.accept(customer);
    }

    static private class Customer{}

    static private class Database{
       static Customer getCustomerWithId(int i ){
           return  new Customer();
       }
    }
}
