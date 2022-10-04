package cn.edu.bjfu.leetcode.fg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author chaos
 * @date 2022-08-31 19:01
 */
public class GoodSmall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();
            int[][] mn = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    int jl = scanner.nextInt();
                    mn[j][l] = jl;
                }
            }
            List<Integer>[][] dp = new ArrayList[n][m];
            dp[0][0] = new ArrayList<>(1);
            dp[0][0].add(mn[0][0]);
            for (int j = 1; j < m; j++) {
                dp[0][j] = new ArrayList<>(1);
                dp[0][j].add(dp[0][j - 1].get(0) + mn[0][j]);
            }
            for (int j = 1; j < n; j++) {
                dp[j][0] = new ArrayList<>(1);
                dp[j][0].add(dp[j - 1][0].get(0) + mn[j][0]);
            }
            for (int j = 1; j < n; j++) {
                for (int l = 1; l < m; l++) {
                    dp[j][l] = new ArrayList<>();
                    for (Integer integer : dp[j - 1][l]) {
                        for (Integer integer1 : dp[j][l - 1]) {
                            dp[j][l].add(integer + integer1);
                        }
                    }
                }
            }
            String res = "no";
            for (Integer integer : dp[n - 1][m - 1]) {
                if (integer == x) {
                    res = "yes";
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
