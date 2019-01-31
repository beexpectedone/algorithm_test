package com.personal.programmerMath.lesson3;

public class Lesson3_1 {
    /**
     * @Description: 算算舍罕王给了多少粒麦子
     * @param: grid- 放到第几格
     * @return: long- 麦粒的总数
     */

    public static long getNumberOfWheat(int grid) {
        long sum = 0; // 麦粒总数
        long numberOfWheatInGrid = 0; // 当前格子里麦粒的数量

        numberOfWheatInGrid = 1;// 第一个格子里麦粒的数量
        sum += numberOfWheatInGrid;
        for (int i = 2; i <= grid; i++) {
            /** 当前变量是上一次变量的演化，之前的值不断递推出新的值 */
            numberOfWheatInGrid *= 2;// 当前格子里麦粒的数量是前一格的 2 倍
            sum += numberOfWheatInGrid; // 累积麦粒总数
        }

        return sum;
    }
}
