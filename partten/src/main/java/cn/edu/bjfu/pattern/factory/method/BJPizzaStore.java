package cn.edu.bjfu.pattern.factory.method;

import cn.edu.bjfu.pattern.factory.BJStyleCheesePizza;
import cn.edu.bjfu.pattern.factory.Pizza;
import cn.edu.bjfu.pattern.factory.simple.SimplePizzaFactory;

/**
 * @author chaos
 * @date 2022-09-26 20:30
 */
public class BJPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (SimplePizzaFactory.CHEESE_PIZZA.equals(type)) {
            return new BJStyleCheesePizza();
        }
        return null;
    }

    public static void main(String[] args) {
        PizzaStore pizzaStore = new BJPizzaStore();
        Pizza cheese = pizzaStore.orderPizza("cheese");
        System.out.println(cheese.getClass());
    }
}
