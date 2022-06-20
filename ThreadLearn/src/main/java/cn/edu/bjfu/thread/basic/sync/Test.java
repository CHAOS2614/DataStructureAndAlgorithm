package cn.edu.bjfu.thread.basic.sync;

/**
 * @author chaos
 * @date 2021-12-30 15:52
 */
public class Test {
    public void test(){
        synchronized (this){
            synchronized (this){
                System.out.println(" ");
            }
        }
    }
}
