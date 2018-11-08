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

    /**
     *
     * @param arr 源数组
     * @param low 最低位角标
     * @param high 最高位角标
     * @return 返回最后标兵位角标
     *
     *
     * 启发：标兵位可以选择 low 位置，也可以选择 high 位置 ，如果选择的是 low 位置的则while循环要先从high执行
     * 如果选择的是 high 位置，则while循环要从低位开始执行
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  //数轴记录
        /** 中间的循环一定要先从high开始，如果从low开始就无法正确排序 */
        while (low < high) {
            while (low < high && arr[low] <= pivot){ //
                ++low;
            }
            arr[high] = arr[low];
            while (low < high && arr[high] >= pivot){
                --high;
            }
            arr[low] = arr[high]; //
        }
        arr[high] =pivot;
        return high;
    }
}
