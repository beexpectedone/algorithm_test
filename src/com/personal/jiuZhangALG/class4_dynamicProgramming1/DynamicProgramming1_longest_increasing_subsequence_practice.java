package com.personal.jiuZhangALG.class4_dynamicProgramming1;

public class DynamicProgramming1_longest_increasing_subsequence_practice {
    public int longestIncreasingSubsequence(int[] nums) {
        int[] f = new int[nums.length - 1]; //
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1; // initialize
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) { //function   /* 这里的条件是保证筛选出来的是 递增条件 */
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(f[i], max); // answer
        }
        return max;
    }
}
