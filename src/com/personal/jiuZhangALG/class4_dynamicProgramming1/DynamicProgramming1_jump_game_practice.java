package com.personal.jiuZhangALG.class4_dynamicProgramming1;

public class DynamicProgramming1_jump_game_practice {

    public boolean canJump(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] >= i) { // j 可以代表“从 0 到 j 位置”是可以跳成功的
                    can[i] = true;
                    break;
                }
            }
        }
        return can[A.length - 1];
    }
}
