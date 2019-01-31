package com.personal.programmerMath.lesson3;

public class Lesson3_2 {
    /**
     * @Description: 计算大于 1 的正整数之平方根
     * @param: n- 待求的数， deltaTreshold- 误差的阈值(用来控制解的精度)， maxTry- 二分查找的最大次数
     * @return: double- 平方根的解
     */
    public static double getSqureRoot(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0;
        }

        double min = 1.0, max = (double) n;
        for (int i = 0; i < maxTry; i++) {
            double middle = max / 2;
            double square = middle * middle;
            double delta = Math.abs((square / n) - 1); //
            if (delta <= deltaThreshold) { //delta 与 误差的阈值（deltaThreshold） 相比较，
                return middle;
            } else {
                if (square > n) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }
        return -2.0;
    }
}
