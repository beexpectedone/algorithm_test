package com.personal.jiuZhangALG.class4_dynamicProgramming1;

public class DynamicProgramming1_climbing_stairs_practice {
    int[] result = null;
    void f(int x) {
        if (result[x] != -1) return; //
        if (x ==0 || x ==  1) { //
            result[x] = 1;
            return;
        }
        f(x - 1);
        f(x - 2);
        System.out.println(" ");
        result[x] = result[x - 1] + result[x -2];
    }

    public int climbStairsOfMemorizeSearch(int n) {
        if (n == 0) {
            return 0;
        }
        result = new int[n + 1]; //定义一个全局数组
        for (int i = 0; i <= n; ++i) {  //初始化result[]数组
            result[i] = -1;
        }
        f(n); //调用f函数（功能函数）
        System.out.println("  ");
        return result[n];
    }

    public int climbStairs(int n) {
        if (n <= 1) { // 对特殊情况的处理，当 n 等于 1 的时候处理一步
            return n;
        }
        int last = 1, lastLast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) { // 执行 n - 1 次
            now = last + lastLast;
            lastLast = last;
            last = now;
        }
        System.out.println("  ");
        return now;
    }
}
