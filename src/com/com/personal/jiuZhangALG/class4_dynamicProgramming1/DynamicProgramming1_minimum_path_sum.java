package com.personal.jiuZhangALG.class4_dynamicProgramming1;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * note:
 *      You can only move either down or right at any point in time.
 * 给一个矩阵坐标点，求从左上角到右下角最短路径和
 *
 *感悟： 本质上还是让数组每一个位置的值都等于之前最小值总和加上该点的值
 *
 */
public class DynamicProgramming1_minimum_path_sum {
    public int minPathSum(int[][] grid) {
        //illegal
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        sum[0][0] = grid[0][0];

        /** 这两个for循环先将数组从左上角起两边的点的值求出来
         * 因为数组最两边的值都只有一条路径可以选择 */
        for (int i = 1; i < M; i++) { //第0列的值
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < N; i++) { //第0行的值
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < M ; i++) { //刨除掉 0 行
            for (int j = 1; j < N; j++ ) { //刨除掉 0 列
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[M - 1][N - 1];
    }

    public int minPathSum_with_print_path(int[][] A){
        //illegal
        if (A == null || A.length == 0 || A[0].length == 0){
            return 0;
        }

        int m = A.length, n = A[0].length; //m, n 分别为A数组的行列值
        int[][] f = new int[m][n];
        int[][] pi = new int[m][n];
        int i, j;
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                if (i == 0 && j == 0) { //初始化数组A
                    f[0][0] = A[0][0];
                }

                f[i][j] = Integer.MAX_VALUE; //先将f[i][j]赋值为最大Integer值
                if (i > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + A[i][j]); //从上方路径到该点的值
                    if (f[i][j] == f[i - 1][j] + A[i][j]){ //如果该步骤是从上方下来的路径之更小的话就记录该标签
                        pi[i][j] = 0;
                    }
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + A[i][j]); //从左方路径到该点的值
                    if (f[i][j] == f[i][j - 1] + A[i][j]){
                        pi[i][j] = 1;
                    }
                }
            }
        }

        //reverse order
        //m - 1, n - 1
        int[][] path = new int[m + n - 1][2]; //新建一个宽度为两列高度为 长加宽的二维数组
        int p;
        i = m - 1;
        j = n - 1;
        for (p = m + n -2; p >= 0; --p) {
            path[p][0] = i;
            path[p][j] = j;
            if (p == 0) break;
            if (pi[i][j] == 0) {
                --i;
            }
            else {
                --j;
            }
        }
        for (p = 0; p < m + n - 1; ++p) {
            System.out.println("{" + path[p][0] + ", " + path[p][1] + "):" + A[path[p][0]][path[p][1]]);
        }
        return f[m - 1][n - 1];
    }
}
