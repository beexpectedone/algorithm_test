package com.personal.jiuZhangALG.class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mingyue on 2018/9/24.
 */
public class Recursion {

    public ArrayList<ArrayList<Integer>> subsets(int[] nums){
        //recursion -> 程序的一种实现方式
        //函数自己调用自己
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        /** 对提供的数据集进行异常检测 */
        if (null == nums){
            return results;
        }

        ArrayList<Integer> subset = new ArrayList<>();

        //find all possible subsets, put them into results
        //把以 空集 开头的所有集合找到放到results集合当中
        Arrays.sort(nums); //先对集合进行排序，保证提供的数据源是按照顺序排列的
        subsetHelper(results, subset, nums, 0);

        return results;

    }

    /** 递归的三个要素之1， 定义和分解问题：
     *  把以subset 开头的所有的子集，全部找到，并放到results里面
     * */
    private void subsetHelper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> subset, int[] nums, int fromIndex) {

        /** 递归三要素之2： 极端小的状态
         * if xxx {
         *  return
         * }
         * */
        //refrence -> 每次生成一个和subset值相同的但是为新的subset，存储到内存当中
        results.add(new ArrayList<>(subset)); /* 保证原始的数据源一直能被影响和操作 */

        /** 递归三要素之3：如何变为更小的状态 */
        for (int i = fromIndex; i < nums.length; i++){
            subset.add(nums[i]);
            subsetHelper(results, subset, nums, i + 1); /* 如何进入更内层的纬度 */
            //以 {1} 开头的多找到，再回到空集从 {2} 开始
            subset.remove(subset.size() - 1);  /* 退回到上一个纬度是保证程序能继续运行 */
        }
    }

    private void subsetHelper2(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> subset, int[] nums, int fromIndex){

        //将和subset值相同的，一个新的集合添加到results集合当中
        results.add(new ArrayList<>(subset));

        for (int i = fromIndex; i < nums.length; i++){ /** fromIndex 和 i 相同的时候只是第一次进来的时候是相同，之后i都是大于from Index的 */
            if( i != fromIndex && nums[i] == nums[i - 1]){
                /*如果发现这一次轮询到的数和上一次相同这一次下面的语句就不继续执行*
                /比如：取到{1,2} 以后， {1,2,2} 就不取了
                 再往回退一级，因为取过了{1,2} 那么另一个生成的{1,2}也就不用去了
                 */
                continue;
            }
            subset.add(nums[i]);
            subsetHelper2(results, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    private void subsetHelper3(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> subset, int[] nums, int fromIndex){

        results.add(new ArrayList<>(subset));

        for (int i = fromIndex; i < nums.length; i++){
            if (i != fromIndex && nums[i - 1] == nums[i]){
                continue;
            }
            subset.add(nums[i]);
            subsetHelper2(results, subset, nums, i + 1);
            subset.remove(subset.size() - 1); /** 为了去到另一个分支上，要将添加到subset中的元素删除掉 */
        }
    }

    private void subsetHelper4(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> subset, int[] nums, int fromIndex){
        results.add(new ArrayList<>(subset));

        for (int i = fromIndex; i < nums.length; i++){
            subset.add(nums[i]);
            subsetHelper4(results, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    private void subsetHelper5(List<List<Integer>> result, List<Integer> subset, int[] nums, int fromIndex){
        //====================>这里给result结果集添加的不应该是subset集合而应该是一个值和subset相同的新的集合  切记！！！ 切记！！！
        result.add(new ArrayList<>(subset));

        for (int i = fromIndex; i < nums.length; i++){
            if (i != fromIndex && nums[i - 1] == nums[i]){
                continue;
            }

            subset.add(nums[i]);
            subsetHelper5(result, subset, nums, i + 1);  /** 放在这里递归可以实现沿着一个数一直往下延伸的功能 */
            subset.remove(subset.size() - 1);
        }
    }
}
