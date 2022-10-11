package cn.edu.bjfu.thread.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chaos
 * @date 2022-10-07 21:45
 * <p>
 * 编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC…
 */
public class Abc {

    private int num = 1;

    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (num != 1) {
                conditionA.await();
            }
            System.out.println("A");
            num = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printB() {
        lock.lock();
        try {
            while (num != 2) {
                conditionB.await();
            }
            System.out.println("B");
            num = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (num != 3) {
                conditionC.await();
            }
            System.out.println("C");
            num = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Abc abc = new Abc();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                abc.printA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                abc.printB();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                abc.printC();
            }
        }).start();
    }
}
