package cn.edu.bjfu.pattern.decorator;

/**
 * @author chaos
 * @date 2022-09-23 21:36
 * 抽象构建
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
