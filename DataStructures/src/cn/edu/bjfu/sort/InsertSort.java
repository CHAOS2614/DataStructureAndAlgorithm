package cn.edu.bjfu.sort;

/**
 * @author chaos
 * @date 2021-12-10 14:37
 */
public class InsertSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] <= nums[i]) {
                    break;
                }
            }
            if (j != i - 1) {
                int temp = nums[i];
                if (i - 1 - j >= 0) {
                    System.arraycopy(nums, j + 1, nums, j + 2, i - j - 1);
                }
                nums[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 5, 4, 1, 2, 9, 6, 3};
        sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
