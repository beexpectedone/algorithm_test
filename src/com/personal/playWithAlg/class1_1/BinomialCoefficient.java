package com.personal.playWithAlg.class1_1;

/**
 * Created by mingyue on 2018/9/27.
 */
public class BinomialCoefficient {

    /**	 * 计算二项式系数
     * @param recode
     * @param n
     * @param k
     * @return
     */
    public static int binomial(int[][] recode, int n, int k) {
        for (int i = 0; i <= n; i++) {
            int nc = i + 1; //每一阶的项数

            for (int j = nc - 2; j > 0; j--){
                if (j == i || j == 0){
                    recode[i][j] = 1;
                }
                else{
                    recode[i][j] = recode[i - 1][j] + recode[i - 1][j - 1];
                }
            }
        }
        return recode[n][k];
    }


}
