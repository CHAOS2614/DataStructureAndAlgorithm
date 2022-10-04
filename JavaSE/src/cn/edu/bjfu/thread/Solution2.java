package cn.edu.bjfu.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chaos
 * @date 2022-09-05 19:52
 */
public class Solution2 {
    public static int i = 0;

    public static void main(String[] args) {
        String s = "chaos is hello";
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                2,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                new ThreadPoolExecutor.AbortPolicy()
        );
        poolExecutor.execute(() -> {
            while (i < s.length()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s) {
                    System.out.println(Thread.currentThread().getName() + ":" + s.charAt(i++));
                    s.notify();
                    if(i < s.length()){
                        try {
                            s.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        poolExecutor.execute(() -> {
            while (i < s.length()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s) {
                    System.out.println(Thread.currentThread().getName() + ":" + s.charAt(i++));
                    s.notify();
                    if(i < s.length()){
                        try {
                            s.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        poolExecutor.shutdown();
    }
}
