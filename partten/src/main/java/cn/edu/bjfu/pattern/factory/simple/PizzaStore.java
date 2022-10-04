package cn.edu.bjfu.pattern.factory.simple;

import cn.edu.bjfu.pattern.factory.Pizza;

/**
 * @author chaos
 * @date 2022-09-26 14:56
 */
public class PizzaStore {
    SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = simplePizzaFactory.createPizza(type);
        pizza.cook();
        return pizza;
    }

    public static void main(String[] args) {
        Pizza pizza = new PizzaStore(new SimplePizzaFactory()).orderPizza("clam");
    }
}
