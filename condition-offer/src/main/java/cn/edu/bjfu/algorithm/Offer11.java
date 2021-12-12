package cn.edu.bjfu.algorithm;

/**
 * @author chaos
 * @date 2021-12-12 11:06
 * <a href="https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/">旋转数组的最小数字</a>
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 * </p>
 */
public class Offer11 {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0, right = numbers.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            // 如果右边单调，则最小值在左区间（包括mid）
            if (numbers[mid] < numbers[right]) {
                right = mid;
                // 如果左边单调且右边不单调，则在右区间（mid也可以舍弃）
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
                // 如果中间值与right相等，则只是能舍弃right；
            } else {
                right -= 1;
            }
        }
        return numbers[left];
    }


}
