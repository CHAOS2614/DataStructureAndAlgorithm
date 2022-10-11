package cn.edu.bjfu.thread.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chaos
 * @date 2021-12-06 23:27
 */
public class test1 {
    public static void main(String[] args) {
        MyResources myResources = new MyResources();
        new Thread(() -> myResources.printNumber(), "number").start();
        new Thread(() -> myResources.printChar(), "number").start();
        List<User> list = new ArrayList<>();
        Map<Integer, User> collect = list.stream().collect(Collectors.toMap(User::getUserId, Function.identity()));
    }


}

class User {
    private int userId;
    private int name;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}


class MyResources {

    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    boolean isNumber = true;

    public synchronized void printNumber() {
        Map<String, String> map = new HashMap<>(16);
        map.isEmpty();
        for (int i = 0; i < 26; ) {
            while (!isNumber) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(++i);
            isNumber = false;
            notify();
        }
    }

    public synchronized void printChar() {
        for (int i = 0; i < 26; i++) {
            while (isNumber) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println((char) (i + 'a'));
            isNumber = true;
            notify();
        }
    }

}
