package cn.edu.bjfu.thread;

import java.util.Scanner;

/**
 * @author chaos
 * @date 2022-09-05 19:43
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < m; j++) {
                stringBuilder.append((j + i) % 3);
            }
            System.out.println(stringBuilder);
        }
    }
}
