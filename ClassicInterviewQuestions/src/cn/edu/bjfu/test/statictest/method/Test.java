package cn.edu.bjfu.test.statictest.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chaos
 * @date 2022-09-14 18:56
 */
public class Test {
    public static void main(String[] args) {

        Order o = new Order(1,"order1");
        Order o2 = new Order(2,"order2");
        Order o3 = new Order(3,"order3");
        Order o4 = new Order(3,"order4");
        Order o5 = new Order(3,"order5");

        List<Order> orders = new ArrayList<>();
        orders.add(o);
        orders.add(o2);
        orders.add(o3);
        orders.add(o4);
        orders.add(o5);

        Map<Integer, Order> collect = orders.stream().collect(Collectors.toMap(Order::getId, Function.identity()));

        new A();
        int[] nums = new int[100000];
        int a = 0xfffffff1;
        System.out.println(a);
        int b = ~a;
        System.out.println(b);
    }
}

class Order{
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


class B {
    static {
        System.out.println("b static");
    }

    public B() {
        System.out.println("b gouzao");
    }
}

class A extends B {
    static {
        System.out.println("a static");
    }

    public A() {
        System.out.println("a");
    }
}
