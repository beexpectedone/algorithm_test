package com.personal.jiuZhangALG.class2_binary;

/** 找到螺旋数组开始产生螺旋的位置，
 * 转换为找到第二段函数中最小值
 * 这里面去的target值就是选择了
 * 数组末尾最后一个数*/
public class BinarySearch_RotatedArray_Practice {
    public int findMin(int[] nums) {
        //illegal
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int target = nums[nums.length - 1]; //

        //
        while (start + 1 < end) {
            System.out.println(" ");
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target){
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] <= target) {
            return nums[start];
        }
        else {
            return nums[end];
        }
    }
}
