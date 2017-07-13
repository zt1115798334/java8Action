package com.devil.interfaceDefault;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by zhangtong on 2017/7/13.
 */
public class MyTest {

    private interface Defaulable {
        // Interfaces now allow default methods, the implementer may or
        // may not implement (override) them.
        default String notRequired() {
            return "Default implementation";
        }
    }

    private static class DefaultableImpl implements Defaulable {

    }

    private static class OverridableImpl implements Defaulable {
        @Override
        public String notRequired() {
            return "Override implementation";
        }
    }

    private interface DefaulableFactory {
        static Defaulable create(Supplier<Defaulable> supplier) {
            return supplier.get();
        }
    }

    public static class Car {
        public static Car create(Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
    }

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.notRequired());
        defaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(defaulable.notRequired());

        Car car = Car.create(Car::new);
        List<Car> carList = Arrays.asList(car);
        carList.forEach(Car::collide);
        carList.forEach(Car::repair);

        final Car car1 = Car.create(Car::new);
        carList.forEach(car1::follow);
    }
}

