package com.personal.jiuZhangALG.class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mingyue on 2018/9/25.
 */
public class NonRecursion {

    public List<List<Integer>> subset(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        // 1 << n is 2^n
        // each subset equals to a binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1, 2, 3]
        for (int i = 0; i < (1 << n); i++){
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++){
                // check whether the jth digit in i's binary representation is 1 第j为的数值是否为 "1" ，为 "1" 说明是有效的数值可以存到集合当中
                /** 本质上就是试，试这个数到底在那个"位"上有值（不为0而为1），然后这个位置就认为是对应一个数字的 */
                if((i & (1 << j)) != 0){
                    subset.add(nums[i]);
                }
                System.out.println('.');
            }
            result.add(subset);
        }
        return result;
    }

    public List<List<Integer>> subset2(int[] nums){
        List<List<Integer>> result = new ArrayList<>(); //储存子集的结果集
        int n = nums.length;
        Arrays.sort(nums); //先对nums进行排序

        // each subset equals to a binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // ..
        // 7 -> 111 -> [1, 2, 3]
        for (int i = 0; i < (1 << n); i++){ //假设每个子集nums个元素，只是有的子集里面的有些位上是null的。那么这个组合一共又多少种呢，答案是 2^n 个
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++){
                /** 这里的每一个i值都被当作是二进制的数，这样 （1 << j）就是为了判断它在 j 位置上是否是有值 */
                if ((i & (1 << j)) != 0){
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }


}
