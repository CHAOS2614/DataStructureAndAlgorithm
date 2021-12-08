package cn.edu.bjfu.thread.basic.ticket;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chaos
 * @date 2021-12-07 20:56
 */
public class Ticket {

    private int number = 30;

    Lock lock = new ReentrantLock();

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票，还剩" + number + "张票。");
        }
    }

    public void lockSale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票，还剩" + number + "张票。");
            }
        } finally {
            lock.unlock();
        }
    }

}

class TicketTest {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }, "窗口1").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }, "窗口2").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }, "窗口3").start();
        System.out.println("============================================");
        Ticket ticket2 = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket2.lockSale();
            }
        }, "窗口1").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket2.lockSale();
            }
        }, "窗口2").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket2.lockSale();
            }
        }, "窗口3").start();
    }

}
