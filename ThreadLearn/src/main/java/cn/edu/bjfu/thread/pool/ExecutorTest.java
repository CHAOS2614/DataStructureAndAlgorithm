package cn.edu.bjfu.thread.pool;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author chaos
 * @date 2021-12-29 15:22
 */
public class ExecutorTest {

    public static int count = 1;

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS,
                arrayBlockingQueue,
                r -> new Thread(r, "my-thread-" + (count++)),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 100; i++) {
            try {
                executorService.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
        System.out.println("******************************");

    }


}
