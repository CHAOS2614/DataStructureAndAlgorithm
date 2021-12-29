package cn.edu.bjfu.test.statictest.method;

/**
 * @author chaos
 * @date 2021-12-29 10:17
 */
public class Son extends Father{

    public static void staticMethod(){
        System.out.println("son static method");
    }

    public static void main(String[] args) {
        // 如果将Son中的staticMethod方法去掉依旧可以运行，调用Father中的方法
        // 并不是重写，而是将父类的隐藏了
        Son.staticMethod();
        Father father = new Son();
        // 如果是非静态方法重写应该是调用子类的重写方法
        // 但这里确调用的是父类的方法
        father.staticMethod();
    }
}
