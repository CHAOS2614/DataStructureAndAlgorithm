package cn.edu.bjfu.thread.juc;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chaos
 * @date 2022-09-29 19:32
 */
public class CopyOnWriteList {
    private static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        new Thread(() -> {
            for (int i = 100; ; i++) {
                list.add(i);
            }
        }, "add").start();

        new Thread(() -> {
            for (Integer integer : list) {
                System.out.println(integer);
            }
            list.clear();
            System.out.println("******************");
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }).start();
    }
}
