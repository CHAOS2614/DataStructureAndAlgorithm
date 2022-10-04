package cn.edu.bjfu.pattern.decorator;

/**
 * @author chaos
 * @date 2022-09-23 21:38
 * 抽象装饰类
 */
public abstract class CondimentDecorator extends Beverage {
    @Override
    public abstract String getDescription();

}
