package cn.edu.bjfu.thread.practice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author chaos
 * @date 2022-10-08 12:27
 */
public class Sum2 {
    public static int total = 0;

    public static void main(String[] args) {
        CompletableFuture<Integer>[] all = new CompletableFuture[10];
        // 测试求总和不加锁会有线程安全问题，即结果不为5050
        for (int k = 0; k < 100; k++) {
            total = 0;
            for (int i = 0; i < 10; i++) {
                final int num = i;
                all[i] = CompletableFuture.supplyAsync(() -> {
                    int sum = 0;
                    int end = num * 10 + 11;
                    for (int j = num * 10 + 1; j < end; j++) {
                        sum += j;
                    }
                    // 注意线程安全
                    synchronized (all){
                        total += sum;
                    }
                    return sum;
                });
            }
            CompletableFuture.allOf(all).join();
            System.out.println(total);
        }
        int sum = 0;
        for (CompletableFuture<Integer> integerCompletableFuture : all) {
            try {
                sum += integerCompletableFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end" + sum);
    }
}
