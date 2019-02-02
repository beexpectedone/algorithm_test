package com.personal.jiuZhangALG.class2_binary;

/**
 * 迭代法：看不断更新变量值或者是不断缩小搜索的区间范围，是否可以获得最终的解
 *
 *
 */
public class BinarySearch_WoodCut_Practice {
    public int woodCut(int[] L, int k) {
        int l = 1, res = 0;
        int r = 0;
        for (int item : L) {
            r = Math.max(r, item); //
        }

        while (l <= r) {
            int mid = l + (r - l) / 2; //
            if (count(L, mid) >= k) { //
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public int woodCut2(int[] L, int k) {
        int l = 1;
        int r = 0;
        for (int item : L) {
            r = Math.max(r, item);
        }

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (count(L, mid) >=k){
                l = mid;
            } else {
                r = mid;
            }
        }

        if (count(L, l) >= k) {
            return l;
        }
        if (count(L,r) >= k){
            return r;
        }

        return 0;
    }

    private int count(int[] L, int len) {
        int sum = 0;
        for (int item : L) {
            sum += item / len;
        }
        return sum;
    }
}
