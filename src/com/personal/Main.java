package com.personal;

import com.personal.playWithAlg.class1_3.QuickSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    // write your code

        /** 集合所有子集问题 */
//        int[] nums = new int[]{1,2,3};
//        ArrayList<ArrayList<Integer>> subsets =  new Recursion().subsets(nums);
//
//        if (subsets.size() > 0){
//            for (int i = 0; i < subsets.size(); i++){
//                System.out.println(subsets.get(i));
//            }
//        }


        /** 字符串全排问题 */
//        char[] s = {'a','b','c'};
//        Permutation.permutation3(s, 0, s.length - 1);

        /** 合并/归并 排序 */
//        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
//        MergeSort.mergeSort(a, 0, a.length - 1);
//        System.out.println("排序结果：" + Arrays.toString(a));


        /** 二分法查找 */
//        int[] arr = {1, 3, 5, 7, 9, 11};
//        int key = 5;
//        int position = BinarySearch.binarySearchByRecursion(arr, key, 0, arr.length - 1);
//
////        int position = BinarySearch.binarySearchWithoutRecursion(arr,5);
//        if (position == -1){
//            System.out.println("查找的是" + key + ",序列中没有该数！");
//        } else {
//            System.out.println("查找的是" + key + ",找到位置为："+position);
//        }

        /** 快速排序 */
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        QuickSort.quickSort(a);
        System.out.println("排序结果：" + Arrays.toString(a));

    }
}
