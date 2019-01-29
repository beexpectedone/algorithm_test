package com.personal.jiuZhangALG.class4_dynamicProgramming1;

/**
 * Given a sequence of integers, find the longest increasing subSequence (LIS).
 * You code should return the length of the LIS.
 *
 * What's the definition of longest increasing subSequence?
 * The longest increasing subSequence problem is to find a subSequence of a given sequence
 * in which the subSequence's elements are in sorted order, lowest to highest,
 * and in which the subSequence is as long as possible.
 * This subSequence is not necessarily contiguous, or unique.
 *
 * Example
 * For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
 */
/**
 * 如果程序看不懂，就带数据到这个程序当中去运算，看程序具体的运行步骤
 * */
public class DynamicProgramming1_longest_increasing_subsequence {
    public int longestIncreasingSubsequence(int[] nums) { //源数组
        int[] f = new int[nums.length]; // 作为统计数组，从之前的位置到该点最大的
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1; // 为每个 f 数组的数都进行初始化
            for (int j = 0; j < i; j++) { // 从 j 位置到 i 位置，在这个区间中找到有多少个数符合“逐渐递增”的概念
                if (nums[j] < nums[i]) { // 当发现 i 位置的数比 j 的大时 （打擂台算法）
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;  // 每次发现一个大的数就给 f[i] 增加 1
                }
            }
            if (f[i] > max) {
                max = f[i];  // 获取到每个位置上的最大的连续数组
            }
        }
        return max;
    }

    /**
     * 该写法是将上面的拆分开来，成三个部分
     * state initialize function
     */
    public int longestIncreasingSubsequence2(int[] nums) {
        //state
        int len = nums.length;
        int[] lis = new int[len];

        //initialize
        for (int i = 0; i < len; i++) {
            lis[i] = 1;
        }

        //function
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    /** 每次都将 i 值作为数组的最后一个来看待，
                     * 以求出该位置上最大可能对的 */
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        //answer
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, lis[i]);
        }

        return max;
    }
}
