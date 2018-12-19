package com.personal.jiuZhangALG.class4_dynamicProgramming1;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 *
 * 感悟：
 *      1.其和二叉树有一定的相似性，都是一分为二
 */
public class DynamicProgramming1_triangle {

    public int minimalTotal(int[][] triangle) {
        int best;
        best = Integer.MAX_VALUE; //初始值将best赋值成integer最大值
        dfs(triangle, 0, 0, 0,best);
        return best;
    }

    //sum = root -> x, y 但不包含 x，y的路径和
    //普通的递归方法，时间复杂度为 O(2^n)
    private void dfs(int[][] triangle, int x, int y, int sum, int best) {
        //illegal
        if (triangle == null || triangle.length == 0) {
            return;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return;
        }

        int n = triangle.length;

        if (x == n){
            best = Math.min(best, sum);
            return;
        }
        dfs(triangle, x + 1, y, sum + triangle[x][y], best);
        dfs(triangle, x + 1, y + 1, sum + triangle[x][y], best);
    }

    //使用分治方法，时间复杂度为n^2
    public int divideConquer(int[][] triangle, int x, int y) {
        //illegal
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        int n = triangle.length;
        if (x == n) {
            return 0;
        }

        return triangle[x][y] + Math.min(
                divideConquer(triangle,x + 1, y),
                divideConquer(triangle,x + 1, y + 1));
    }

    private int[][] minSum;
    public int memorizeSearch(int x, int y,int n, int[][] triangle) {
        if (x >= n){
            return 0;
        }
        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }
        minSum[x][y] = Math.min(memorizeSearch(x + 1, y, n,triangle),
                                memorizeSearch(x + 1, y + 1, n, triangle))
                                + triangle[x][y];
        return minSum[x][y];
    }


    public int minimumTotalMemorize(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return  -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        int n = triangle.length;
        for (int i = 0; i < n; i++){  //minSum 相当于一个哈希表（hashmap）
            for (int j = 0; j < n; j++){
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        return memorizeSearch(0,0, n, triangle);
    }

}
