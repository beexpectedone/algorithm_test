package com.personal.jiuZhangALG.class4_dynamicProgramming1;

public class DynamicProgramming1_jump_game_ll_practice {

    public int jumpPractice(int[] A) {
        //state
        int[] steps = new int[A.length];

        //initialize
        steps[0] = 0;
        for (int i = 0; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        //function
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }

        return steps[A.length - 1];
    }
}
