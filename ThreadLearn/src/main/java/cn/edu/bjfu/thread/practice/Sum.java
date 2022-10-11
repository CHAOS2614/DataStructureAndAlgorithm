package cn.edu.bjfu.thread.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author chaos
 * @date 2022-10-07 22:12
 */
public class Sum {
    public static long allSum = 0L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int max = Integer.MAX_VALUE / 15;
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(max * i);
        }
        List<CompletableFuture<Long>> futures = list.stream().map(integer -> CompletableFuture.supplyAsync(() -> {
            long sum = 0;
            for (int i = 0, j = integer; i < max; i++, j++) {
                sum += j;
            }
            return sum;
        })).collect(Collectors.toList());
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).whenComplete((v, throwable) -> {
            for (CompletableFuture<Long> future : futures) {
                try {
                    allSum += future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).join();
        System.out.println(allSum);
    }


    public void testCountDownLatch() {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        List<Future> futures = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            final int num = i;
            futures.add(threadPool.submit(() -> sum(num)));
        }
    }

    private int sum(int i) {
        int sum = 0;
        int end = i * 11 + 1;
        for (int j = i * 10 + 1; j < end; j++) {
            sum += 10;
        }
        return sum;
    }

}
