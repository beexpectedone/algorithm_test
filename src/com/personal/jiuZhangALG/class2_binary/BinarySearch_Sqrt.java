package com.personal.jiuZhangALG.class2_binary;


/**
 * Sqrt(x)
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * Example
 * sqrt(3) = 1
 * sqrt(4) = 2
 * sqrt(5) = 2
 * sqrt(10) = 3
 *
 * Challenge==================> 这里是关键点需要保证时间复杂度是 O(log(x))
 * O(log(x))
 *
 */
public class BinarySearch_Sqrt {

    /**
     *
     * @param number 传入的要开根号的数
     * @return 返回开根结果
     */
    public static double sqrt(int number) {

        /**
         * 使用到的公式：
         * sqrt_n+1 = (sqrt_n + num / sqrt_n) / 2.0
         *
         * */

        /* 当number的值为0或者1时，直接返回传入的值，
         否则下面的循环会陷入到死循环当中 */
        if (number == 0 || number == 1){
            return number;
        }
        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);
        return squareRoot;
    }

    /** 如果要求输出的值类型为int，则方法简单的多，只需要不断循环执行n^2,
     * 找到n^2大于传入的数的n，再返回前一个数即为所求解 =====》 这种方法
     * 的问题在于时间复杂度是O(n)，而不O(log(n)) */

    /**
     * 使用二分法获取平方根，时间复杂度为O(log(n))
     * */
    public static int mySqrt(int x) {
        long X = (long) x;
        long l = 1, r = X; /** 构造一个从1 ~  x 的连续数组，在这个数组上进行二分折半查找*/
        while (l + 1 < r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == X) {
                return (int) mid;
            } else if (mid * mid < X) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (r * r == X) return (int) r;
        return (int) l;
    }
}
