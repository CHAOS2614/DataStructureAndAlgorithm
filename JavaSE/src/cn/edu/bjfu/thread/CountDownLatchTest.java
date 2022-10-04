package cn.edu.bjfu.thread;

import java.util.concurrent.*;

/**
 * @author chaos
 * @date 2022-09-05 13:58
 */
public class CountDownLatchTest {
    private static final int threadCount = 6;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（推荐使用构造方法创建）
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.AbortPolicy());
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始文件处理");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "完成文件处理");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //表示一个文件已经被完成
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPoolExecutor.shutdown();
        System.out.println("finish");
    }
}
