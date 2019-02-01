package com.personal.jiuZhangALG.class2_binary;

/**
 * 相较而言这一题破解的点在于： 需要先让被二分的区间在一个单调区间上
 */
public class BinarySearch_RotatedArrayPractice {
    public int search(int[] A, int target) {
        //illegal
        if (A == null || A.length == 0) {
            return  -1;
        }

        int start = 0, end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            /* 不写成 (start + end) /2 可以避免出现
            例如 end = Integer.MAX_VALUE 之后出现
             溢出的情况，大部分情况下是为了装逼*/
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }

            /** 这一部分是先判断是否target值已经在前一个后者是后一个的单调区间上 */
            if (A[start] <= A[mid]) { // 如果满足该条件说明已经落在了前一个单调区间上
                if (A[start] <= target && target <= A[mid]) { /* 这个时候表名target已经在前一个的单调区间上了 */
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= A[end] && target >= A[mid]) { /* 这个时候表名target已经在后一个单调区间上了 */
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }

        return -1;
    }
}
