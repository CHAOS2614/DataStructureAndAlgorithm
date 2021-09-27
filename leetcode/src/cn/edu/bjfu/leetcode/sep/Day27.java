package cn.edu.bjfu.leetcode.sep;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * @author chaos
 * @date 2021-09-27 10:22
 */
public class Day27 {

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int par = par(nums, left, right);
            quickSort(nums, left, par - 1);
            quickSort(nums, par + 1, right);
        }
    }

    public int par(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (right > left && nums[right] >= temp) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left < right && nums[left] <= temp) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        nums[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{8, 9, 5, 4, 7, 3, 2, 1, 6};
        new Day27().quickSort(a, 0, 8);
        for (int i : a) {
            System.out.println(i);
        }
    }


}


class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

class TestThread{
//    public static void main(String[] args) {
//
//        System.out.println("abc" == "abc");
//        String s1 = "abc";
//        String s2 = "abc";
//        System.out.println(s1 == s2);
//        String s3 = new String("abc");
//        System.out.println(s1 == s3);
//        System.out.println(Long.MAX_VALUE);
//        String javaVersion = System.getProperty("java.version");
//        System.out.println("java的version:" + javaVersion);
//        String javaHome = System.getProperty("java.home");
//        System.out.println("java的home:" + javaHome);
//        String osName = System.getProperty("os.name");
//        System.out.println("os的name:" + osName);
//        String osVersion = System.getProperty("os.version");
//        System.out.println("os的version:" + osVersion);
//        String userName = System.getProperty("user.name");
//        System.out.println("user的name:" + userName);
//        String userHome = System.getProperty("user.home");
//        System.out.println("user的home:" + userHome);
//        String userDir = System.getProperty("user.dir");
//        System.out.println("user的dir:" + userDir);
//    }

    public static void main(String[] args) {
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        // System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, RoundingMode.HALF_UP));
        System.out.println(bd.divide(bd2, 15, RoundingMode.HALF_UP));
    }



}
