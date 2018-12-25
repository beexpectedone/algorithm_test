package com.personal.jiuZhangALG.class4_dynamicProgramming1;


/**
 * 感悟：
 *      转化成找出一个每一位置都是“最短路径”的题，每个位置上的数的值都是到上个位置的最短路径加上
 *      该位置的triangle值
 * */
public class DynamicProgramming1_triangle_practice {


    public int minimumTotal_top_down(int[][] triangle) {
        //illegal
        if (null == triangle || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        int n = triangle.length;
        int[][] f = new int[n][n];
        //先把两个边列的值求出来, 最边上的两列的值都只有一种情况
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n ; i++) {
            f[i][0] = triangle[i][0] + f[i - 1][0]; //最左边的一列，行一直在增加，列不变
            f[i][i] = triangle[i][i] + f[i - 1][i - 1]; //最右边的一列
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) { // 这里面比较的是去除了 “最左边”、“最右边”两列的值
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j];
            }
        }
        //answer
        int best = f[n - 1][0];
        //最后，比较最后一行的值，获取到整个二维数组中最大的值
        for (int i = 1; i < n; i++) {
            best = Math.max(best, f[n -1][i]);
        }
        return best;
    }

    public int minimumTotal_bottom_up(int[][] triangle) {
        //illegal
        if (null == triangle || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }//

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
        /**
         * 最后一排位置的值等于triangle最后一排的值
         * */
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
        /*先初始化一个每个位置都是
        Integer.MAX_VALUE值的二维数组*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        return memorizeSearch(0, 0);
    }
}
