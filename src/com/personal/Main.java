package com.personal;

import com.personal.playWithAlg.class1_3.Permutation;
import personal.playWithAlg.class1_3.MergeSort;

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
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        MergeSort.mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));

    }
}
