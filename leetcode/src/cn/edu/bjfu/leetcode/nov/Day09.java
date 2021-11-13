package cn.edu.bjfu.leetcode.nov;

import java.util.stream.LongStream;

/**
 * @author chaos
 * @date 2021-11-10 10:05
 */
public class Day09 {
    public static void main(String[] args) {

        long reduce = LongStream.rangeClosed(0, 1_0000_0000).parallel().reduce(Long::sum).orElse(0L);
        System.out.println(reduce);

    }
}
