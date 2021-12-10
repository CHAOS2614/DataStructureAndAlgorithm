package cn.edu.bjfu.sort;

/**
 * @author chaos
 * @date 2021-12-10 14:17
 */
public class SelectSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 7, 5, 4, 1, 2, 9, 6, 3};
        sort(nums);
        for (int num : nums) {
            System.out.println(num + " ");
        }
    }

}
