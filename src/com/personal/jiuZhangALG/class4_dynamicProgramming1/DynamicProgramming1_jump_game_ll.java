package com.personal.jiuZhangALG.class4_dynamicProgramming1;

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
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                    // 因为从 j 到 i 最短的也就是一条路径，那么 step[j] + 1
                    // 也就是代表着从 j 位置到 i 位置最短的路径
                }
            }
        }
        return steps[A.length - 1];
    }
}
