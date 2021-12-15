package cn.edu.bjfu.algorithm;

import org.testng.annotations.Test;

/**
 * @author chaos
 * @date 2021-12-13 13:21
 */
public class Offer13 {

    public int movingCount(int m, int n, int k) {

        int sum = 0;

        for (int i = 0; i < m && i <= k; i++) {

            if (k - i == 0) {
                sum += 1;
            } else {
                sum += Math.min(k - i + 2, n);
            }
        }
        return sum;

    }

    @Test
    public void movingCountTest() {
        System.out.println(movingCount(1, 2, 1));
    }


}
