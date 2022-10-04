package cn.edu.bjfu.pattern.factory.method;

import cn.edu.bjfu.pattern.factory.Pizza;

/**
 * @author chaos
 * @date 2022-09-26 15:34
 *
 * 工厂方法模式定义了一个创建对象的接口，
 * 但由子类决定要实例化的类时哪个。
 * 工厂方法让类把实例化推迟到子类。
 *
 * 该类相当于抽象Creator，在此类中定义了工厂方法，由子类实现。
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.cook();
        return pizza;
    }

    /**
     * 工厂方法，此方法就如同一个工厂，负责穿件pizza实例
     * 工厂方法是抽象的，依赖字类进行处理
     *
     * @param type 披萨类型
     * @return 相应工厂生产的相应类型披萨
     */
    protected abstract Pizza createPizza(String type);
}
