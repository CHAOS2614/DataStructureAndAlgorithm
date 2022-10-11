package cn.edu.bjfu.thread.practice;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author chaos
 * @date 2022-10-08 14:37
 */
public class ProducerConsumer {
    private BlockingQueue<Integer> resource = new ArrayBlockingQueue<Integer>(10);
    private boolean isWorking = true;

    public void setWorking(boolean working) {
        isWorking = working;
    }

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
        ProducerConsumer producerConsumer = new ProducerConsumer();
        for (int i = 1; i < 6; i++) {
            producerExecutor.execute(producerConsumer.new Producer());
            consumerExecutor.execute(producerConsumer.new Consumer());
        }
        Thread.sleep(2000);
        producerExecutor.shutdown();
        consumerExecutor.shutdown();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (isWorking) {
                try {
                    resource.put((int) (Math.random() * 10));
                    System.out.println(Thread.currentThread().getName() + "生产一个资源, 当前资源量：" + resource.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (isWorking) {
                try {
                    Integer take = resource.take();
                    System.out.println(Thread.currentThread().getName() + "消费一个资源：" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


