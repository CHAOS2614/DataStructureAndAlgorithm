package cn.edu.bjfu.bishi.baidu;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chaos
 * @date 2022-09-13 21:06
 */
public class Solution3 {
    public static void main(String[] args) throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get("D:\\Java\\project\\DataStructureAndAlgorithm\\DataStructures\\resource\\1.java"));
        String s = new String(bytes);
        char[] chars = s.toCharArray();
        int res = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i <; i++) {
            for (int j = 0; j <; j++) {
                for (int k = 0; k <; k++) {
                    for (int l = 0; l <; l++) {

                    }
                    for (int l = 0; l <; l++) {

                    }
                    for (int l = 0; l <; l++) {

                    }
                }
                for (int k = 0; k <; k++) {

                }
                for (int k = 0; k <; k++) {

                }
            }
            for (int j = 0; j <; j++) {

            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'f') {
                if (chars[i + 1] == 'o') {
                    if (chars[i + 2] == 'r') {
                        if (res == stack.size()) {
                            res++;
                        }
                    }
                }
            }
            if (chars[i] == '{') {
                stack.push('{');
            }
            if (chars[i] == '}') {
                stack.pop();
            }
        }
        System.out.println(res);
    }
}
