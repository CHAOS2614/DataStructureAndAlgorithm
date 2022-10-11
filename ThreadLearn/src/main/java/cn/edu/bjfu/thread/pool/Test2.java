package cn.edu.bjfu.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chaos
 * @date 2022-10-08 20:09
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new MyTask());
        }
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("start1");
        System.out.println("start2");
        System.out.println("start3");
    }
}
