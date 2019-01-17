package com.personal.jiuZhangALG.class4_dynamicProgramming1;

/**
 * Created by mingyue on 2019/1/17.
 *
 * You are climbing a stair case. It takes n steps to reach to the top.

   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * 斐波那契数列问题： f[i] = f[i - 1] + f[i - 2]
 *
 */
public class DynamicProgramming1_climbing_stairs {

    public static int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int last = 1, lastLast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastLast; //  求出当前楼梯位置
            lastLast = last; //前一级台阶当成"前前"一级
            last = now; // 当前台阶当成 "前"一级
        }
        return now;
    }



    int[] result = null;
    void f(int X) {
        if (result[X] != -1) return;
        if (X == 0 || X == 1) {
            result[X] = 1;
            return;
        }

        f(X -1);
        f(X - 2);
        result[X] = result[X - 1] + result[X -2];
    }

    public int climbStairs2(int n) {
        if (n == 0) {
            return 0;
        }

        result = new int[n + 1];
        for (int i = 0; i<= n; ++i) {
            result[i] = -1;
        }
        f(n);
        return result[n];
    }
}
