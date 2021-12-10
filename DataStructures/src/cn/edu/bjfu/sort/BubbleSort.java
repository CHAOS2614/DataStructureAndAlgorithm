package cn.edu.bjfu.sort;

import org.junit.Test;

/**
 * @author chaos
 * @date 2021-12-10 14:53
 */
public class BubbleSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }


    public int quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
        }
        int temp = nums[left];
        while (left < right) {
            while (nums[right] >= temp && left < right) {
                right--;
            }
            nums[left] = nums[right];
            while (nums[left] <= temp && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    public void doQuickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = quickSort(nums, left, right);
            doQuickSort(nums, left, pos - 1);
            doQuickSort(nums, pos + 1, right);
        }
    }

    @Test
    public void quickSortTest() {
        int[] nums = new int[]{7, 8, 5, 4, 1, 2, 9, 6, 3};
        doQuickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
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
