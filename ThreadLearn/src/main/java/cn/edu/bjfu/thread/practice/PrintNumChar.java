package cn.edu.bjfu.thread.practice;

/**
 * @author chaos
 * @date 2022-10-07 21:33
 * <p>
 * 两线程，一个打印数字从1到52，另一个打印字母从A到Z，输出：12A34B56C...5152Z
 */
public class PrintNumChar {

    private static boolean isNum = true;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (PrintNumChar.class) {
                for (int i = 0; i < 52; ) {
                    while (!isNum) {
                        try {
                            PrintNumChar.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(++i);
                    System.out.print(++i);
                    isNum = !isNum;
                    PrintNumChar.class.notify();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (PrintNumChar.class) {
                for (int i = 0; i < 26; ) {
                    while (isNum) {
                        try {
                            PrintNumChar.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print((char)('a' + i++));
                    isNum = !isNum;
                    PrintNumChar.class.notify();
                }
            }
        }).start();
    }
}
