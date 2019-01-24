package com.personal.jiuZhangALG.class4_dynamicProgramming1;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class DynamicProgramming1_minimum_path_sum_practice {

    public int minPathSum(int[][] grid) {
        //illegal
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length; // 二维数组的行数
        int N = grid[0].length; // 二维数组的列数
        int[][] sum = new int[M][N];

        sum[0][0] = grid[0][0]; //初始化二维数组的（0,0）点值

        for (int  i = 1; i < M; i++){ //初始化第i行第0列的值，它们只有一个方向的值
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < N; i++) { //初始化第0行第i列的值，它们也只有一个方向的值
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < M; i++) { // 其他位置上的点就包含两个方向上值的比较
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(" .... ");
        return sum[M - 1][N - 1]; // 返回最后一行最后一列的值，每一个位置值最小，最终加到这个位置的就是最短路径了
    }

    public int minPathSum_printPath(int[][] A) {
        //illegal
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int m = A.length, n = A[0].length;
        int[][] f = new int[m][n];
        int[][] pi = new int[m][n];
        int i,j;
        for (i = 0; i < m; ++i) {
            for (j = 0; j < 0; ++j) {
                if (i ==0 && j ==0) {
                    f[0][0] = A[0][0];
                    continue;
                }
                /** 将和上一行和上一列对比的操作分拆在两步里进行 */
                f[i][j] = Integer.MAX_VALUE; //初始化f[][]数组的时候,给其一个最大值
                if (i > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + A[i][j]); // 先和上一行的对比
                    if (f[i][j] == f[i - 1][j] + A[i][j]) {
                        pi[i][j] = 0;
                    }
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + A[i][j]); //再和上一列的对比
                    if (f[i][j] == f[i][j - 1] + A[i][j]) {
                        pi[i][j] = 1;
                    }
                }
            }
        }

        //reverse order
        //m-1,n-1
        int[][] path = new int[m + n -1][2];
        int p;
        i = m - 1;
        j = n - 1;
        for (p = m + n - 2; p >= 0; --p) {
            path[p][0] = i;
            path[p][1] = j;
            if (pi[i][j] == 0) {
                --i;
            }else {
                --j;
            }
        }
        for (p = 0; p < m + n - 1; ++p) {
            System.out.println("(" + path[p][0] + ", " + path[p][1] + "):" + A[path[p][0]][path[p][1]]);
        }
        return f[m - 1][n - 1];
    }
}
