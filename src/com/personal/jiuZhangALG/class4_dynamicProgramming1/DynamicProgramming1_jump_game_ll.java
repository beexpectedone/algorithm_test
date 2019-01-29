package com.personal.jiuZhangALG.class4_dynamicProgramming1;

/**
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2.
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class DynamicProgramming1_jump_game_ll {
    public int jump(int[] A) {
        //state
        int[] steps = new int[A.length];

        //initialize
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        //function
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) { /** 对于 j 来说，将每一个给出的 i 都当做是终点 */
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) { /* j + A[j] >= i 表示取 就 可以保证从 0 跳至最后一位 i*/
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                    // 因为从 j 到 i 最短的也就是一条路径，那么 step[j] + 1
                    // 也就是代表着从 j 位置到 i 位置最短的路径
                }
            }
        }
        return steps[A.length - 1];
    }
}
