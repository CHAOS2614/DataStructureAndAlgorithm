package cn.edu.bjfu.pattern.factory.simple;

import cn.edu.bjfu.pattern.factory.CheesePizza;
import cn.edu.bjfu.pattern.factory.ClamPizza;
import cn.edu.bjfu.pattern.factory.Pizza;

/**
 * @author chaos
 * @date 2022-09-26 14:50
 * 简单工厂模式，不能算是一个设计模式，更像是一种编程习惯
 */
public class SimplePizzaFactory {

    public static final String CHEESE_PIZZA = "cheese";
    public static final String CLAM_PIZZA = "clam";

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (CHEESE_PIZZA.equals(type)) {
            pizza = new CheesePizza();
        } else if (CLAM_PIZZA.equals(type)) {
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
