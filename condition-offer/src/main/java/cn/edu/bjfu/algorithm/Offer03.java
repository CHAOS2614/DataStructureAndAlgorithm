package cn.edu.bjfu.algorithm;

/**
 * @author chaos
 * @date 2021-12-11 21:35
 */
public class Offer03 {

    public int findRepeatNumber(int[] nums) {

        int[] map = new int[100000];
        for (int num : nums) {
            if (map[num]++ > 0) {
                return num;
            }
        }
        return -1;

    }

}
