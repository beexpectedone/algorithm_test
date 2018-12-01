package com.personal;

import com.personal.jiuZhangALG.class2_binary.BinarySearch_2DMatrix;
import com.personal.playWithAlg.class1_2.Object;
import personal.jiuZhangALG.class2_binary.BinarySearch_Sqrt;
import personal.jiuZhangALG.class2_binary.BinarySearch_WoodCut;
import personal.jiuZhangALG.class2_binary.BinarySearch_findPeak;

import java.util.List;

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

        /** 0 - 1 背包问题 */
//        List<Object> srcObjs = com.personal.playWithAlg.class1_2.KnapsackProblem.initDate();
//        new com.personal.playWithAlg.class1_2.KnapsackProblem().GreedyAlgo(srcObjs, 150);


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
//        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
//        QuickSort.quickSort(a);
//        System.out.println("排序结果：" + Arrays.toString(a));

        /** Karatsuba */
//        long result = Karatsuba.karatsuba(1515, 1616);
//        System.out.println("计算结果为：.........................." + result);

        /** 二分法变种----二维数组 */
//        int intArray[ ][ ]={{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
//        BinarySearch_2DMatrix.searchMatrixOnce(intArray, 3);

        /** 求平方根的情况 */
//        int number = 10;
////       double result =  BinarySearch_Sqrt.sqrt(number);
//        int result = BinarySearch_Sqrt.mySqrt(number);
//        System.out.println("结果是：..........." + result);

        /** 二分法变体---二分答案 */
//       int[] L = {232, 124, 456}; int k = 7;
//       int len = BinarySearch_WoodCut.woodCut2(L, k);
//        System.out.println("结果是：..........." + len);

        /** 二分法变体---寻找波峰*/
        int[] A = {1, 2, 1, 3, 4, 5, 7, 6};
        int index_result = BinarySearch_findPeak.findPeak2(A);
        System.out.println("结果是：............" + index_result);
    }
}
