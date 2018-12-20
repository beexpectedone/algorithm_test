package com.personal.jiuZhangALG.class4_dynamicProgramming1;

public class DynamicProgramming1_triangle_practice {





    public int minimumTotal_bottom_to_up(int[][] triangle) {
        //illegal
        if (null == triangle || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        int n = triangle.length;
        int[][] f = new int[n][n]; //初始化最终结果的二维数组
        // 先遍历出最后一行f的值, 从下往上遍历的话，最后一行每个位置的数值都是最小的
        for (int k = 0; k < n; k++) {
            f[n - 1][k] = triangle[n - 1][k];
        }

        //使用双层for循环，是的f二维数组每个位置上都是从下往上来看，路径最小
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j]  = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return f[0][0];
    }


    private int[][] minSum;
    private int n;
    private int[][] triangle;
    private int memorizeSearch(int x, int y) {
        //边界
        if (x >= n) {
            return 0;
        }

        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }

        minSum[x][y] = Math.min(memorizeSearch(x + 1, y), memorizeSearch(x + 1, y + 1))
                        + triangle[x][y];
        return minSum[x][y];
    }

    public int minimumTotal(int[][] triangle) {
        //illegal
        if (null == triangle || triangle.length == 0) {
            return -1;
        }
        System.out.println();
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        return memorizeSearch(0, 0);
    }
}
