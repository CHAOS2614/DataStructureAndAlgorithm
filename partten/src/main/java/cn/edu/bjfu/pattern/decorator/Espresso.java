package cn.edu.bjfu.pattern.decorator;

import java.beans.beancontext.BeanContextChildSupport;

/**
 * @author chaos
 * @date 2022-09-23 21:42
 */
public class Espresso extends Beverage {

    public Espresso(){
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
