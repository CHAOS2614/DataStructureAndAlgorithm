package cn.edu.bjfu.extenda;

/**
 * @author chaos
 * @date 2022-10-09 15:23
 */
public class A {
    public A(){
        System.out.println("a");
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
    }
}

class B extends A{
    public B(){
        System.out.println("B");
    }
}
