package com.personal.jiuZhangALG.class4_dynamicProgramming1;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class DynamicProgramming1_jump_game {
    // version 1: Dynamic Programming
    public boolean canJumpByDynamic(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;

        for (int i = 1; i < A.length; i++) { // i 每增加一个数意味着前一个 i - 1 位置已经被验证为可以被之前的位置达到
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] >= i) { // i 位置能不能被前面的 某一个 j 位置达到
                    can[i] = true;
                    break;
                }
            }
        }
        return can[A.length - 1]; //返回最后一个位置，看起是否能被前面的某个位置达到
    }


}
