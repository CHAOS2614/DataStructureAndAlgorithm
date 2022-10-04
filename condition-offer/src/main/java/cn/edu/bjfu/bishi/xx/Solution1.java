package cn.edu.bjfu.bishi.xx;

import java.util.List;
import java.util.Scanner;

/**
 * @author chaos
 * @date 2022-09-29 16:02
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        char[] chars = split[0].substring(1, split[0].length() - 1).toCharArray();
        int n = Integer.parseInt(split[1]);
        List<Integer>[] res = new List[n];
    }
}
