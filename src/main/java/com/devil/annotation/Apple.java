package com.devil.annotation;

/**
 * Created by zhangtong on 2017/7/13.
 */
public class Apple {
    @FruitName("Apple")
    private String name;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public void displayName() {
        System.out.println("水果的名字是：" + name);
        System.out.println("水果的颜色是：" + appleColor);
    }
}
