package com.personal.playWithAlg.class1_3;

import java.util.Arrays;

/***
 * 归并排序算法
 *
 * 分治法：
 * 1.将要排序的数组分解到最小的情况  （递归法则之如何不断变小）
 * 2.以最小情况下的排序为起点，扩展到最小情况的上一级情况，再次进行排序，依次往外
 *
 * 感悟：
 * 1.处理特殊情况（超越边界、极值等）
 * 1. 先推到最小可执行的情况去理解
 * 2.从具体（最小情况）再尝试到一般情况
 */
public class MergeSort {

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high){
            temp[k++] = a[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++){
            a[low + k2] = temp[k2];
        }
    }

    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid); /** 次级拆分 */
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);  /** 同级组合Merge */
            System.out.println(Arrays.toString(a));
        }
    }
}
