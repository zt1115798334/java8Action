package com.devil.chap8;

/**
 * Created by zhangtong on 2017/7/7.
 */
abstract class OnlineBanking {
    public void processCustomer(int i ){
        Customer customer = Database.getCustomerWithId(i);
        makeCustomerHappy(customer);
    }

    abstract void makeCustomerHappy(Customer customer);

    static class Customer{}
    static private class Database{
        static Customer getCustomerWithId(int i ){
            return  new Customer();
        }
    }
}
