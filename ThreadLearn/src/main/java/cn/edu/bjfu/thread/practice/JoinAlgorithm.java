package cn.edu.bjfu.thread.practice;

/**
 * @author chaos
 * @date 2022-10-05 10:48
 * <p>
 * 要求线程a执行完才开始线程b, 线程b执行完才开始线程c
 * <a href="https://blog.csdn.net/qq_18505715/article/details/79795728">join() 解释</a>
 * <a href="https://blog.csdn.net/chaozhi_guo/article/details/50249177">wait()  和  notify()  解释</a>
 * join()的作用：主要作用是同步，它可以使得线程之间的并行执行变为串行执行。在A线程中调用了B线程的join()方法时，表示只有当B线程执行完毕时，A线程才能继续执行。
 */
public class JoinAlgorithm {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }, "a");
        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }, "b");
        Thread c = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }, "c");
        a.start();
        synchronized (a){
            while (a.isAlive()) {
                a.wait(0);
                System.out.println("wait0");
            }
        }
        // a.join();
        System.out.println("a finish");

        b.start();
        b.join();
        System.out.println("b finish");

        c.start();
        System.out.println("c started");
    }
}
