package cn.edu.bjfu.pattern.factory;

/**
 * @author chaos
 * @date 2022-09-26 14:52
 */
public abstract class Pizza {

    String pizzaName;

    public void cook() {
        System.out.println("cook " + pizzaName + "\npreparing...\nbake...\ncut...\nbox...");
    }
}
