package com.personal.playWithAlg.class1_3;

/**
 * Created by mingyue on 2018/11/6.
 *
 * 快速排序算法
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int low, int high){
        if (low < high) {
            int pivot = partition(arr, low, high);/** 先在全数组取枢轴，在进行遍历循环 */
            qSort(arr, low, pivot - 1);  //递归排序左子数组
            qSort(arr, pivot + 1, high); //递归排序又数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];  //数轴记录
        /** 中间的循环一定要先从high开始，如果从low开始就无法正确排序 */
        while (low < high) {
            while (low < high && arr[high] >= pivot){
                --high;
            }
            arr[low] = arr[high]; //
            while (low < high && arr[low] <= pivot){ //
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] =pivot;
        return low;
    }


}
