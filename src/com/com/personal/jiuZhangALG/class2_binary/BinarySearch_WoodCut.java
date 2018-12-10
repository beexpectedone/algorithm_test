package com.personal.jiuZhangALG.class2_binary;

/***
 * Given n pieces of wood with length L[i] (integer array).
 * Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length.
 * What is the longest length you can get from the n pieces of wood? Given L & k,
 * return the maximum length of the small pieces.
 *
 * 解题思路：
 *      最长的那一根可以切成从 1，2，3 ~ n，这么多根，这里要实现的是满足的是
 *      把几根木头都切完了正好能切出来题意里面要求的 k 根木头，并且每根的长
 *      度是限定在 k 根时最大的长度。
 *
 * 感悟： 二分法中二分答案的问题
 */
public class BinarySearch_WoodCut {

    /***
     * @param L 源数组
     * @param k 切成极端
     * @return 每根切除的长度
     *
     * 感悟： 这里的二分法使用的是最长那根切出来最短的根数
     */
    public static int woodCut(int[] L, int k){
        int l = 1, res = 0;
        int r = 0;
        /* 这里的循环主要是为了得到最长的一根木头 */
        for (int item : L) {
            r = Math.max(r, item);
        }

        while (l <= r){  /** 这里的条件设置后，l 和 r 两个数就可能相等 */
            int mid = l + (r - l) / 2;
            if (count(L, mid) >= k){
                res = mid; /** 找到适合的条件以后还会继续执行 */
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    /**
     * @param L 源数组
     * @param len 每一段长度
     * @return 总共多少根
     */
    private static int count(int[] L, int len){

        int sum = 0;
        for (int item : L){
            sum +=  item / len;
        }
        return sum;
    }

    public static int woodCut2(int[] L, int k) {
        int l = 0;
        int r = 0;
        for (int item : L) {
            r = Math.max(r, item);
        }

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (count(L, mid) >= k) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (count(L, r) >= k) {
            return r;
        }
        if (count(L, l) >= k) {
            return l;
        }
        return 0;
    }

}
