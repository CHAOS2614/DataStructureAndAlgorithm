package cn.edu.bjfu.thread.practice;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chaos
 * @date 2022-10-08 15:49
 */
public class ProducerConsumer2 {
    Lock lock = new ReentrantLock();
    Condition conditionP = lock.newCondition();
    Condition conditionC = lock.newCondition();
    private List<String> resource = new ArrayList<>(10);
    private int maxSize = 10;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor producerExecutor = new ThreadPoolExecutor(
                3, 5, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("生产者" + "-%d").setDaemon(true).build(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        ThreadPoolExecutor consumerExecutor = new ThreadPoolExecutor(
                3, 5, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("消费者" + "-%d").setDaemon(true).build(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        ProducerConsumer2 producerConsumer = new ProducerConsumer2();
        for (int i = 1; i < 6; i++) {
            producerExecutor.execute(producerConsumer.new Producer());
            consumerExecutor.execute(producerConsumer.new Consumer());
        }
        Thread.sleep(10000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("********");
            System.out.println(threadInfo.getThreadName());
        }
        producerExecutor.shutdownNow();
        consumerExecutor.shutdownNow();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (resource.size() == maxSize) {
                        conditionP.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "生产：" + resource.add("资源" + (int) (Math.random() * 10)));
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (resource.isEmpty()) {
                        conditionC.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "消费：" + resource.remove(resource.size() - 1));
                    conditionP.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
