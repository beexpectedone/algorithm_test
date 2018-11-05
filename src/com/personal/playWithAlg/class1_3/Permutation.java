package com.personal.playWithAlg.class1_3;

/**
 * Created by mingyue on 2018/10/21.
 */
public class Permutation {



    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c'};
        permutation(s, 0, 2);
    }

        /*

    * 1.如何进入更内层的纬度
    * 2.退回到上一层纬度的时候，保证程序正常进行
    * 3.如何一直让原始的数据源一直被操作
    *
    * */

    /** 递归三要素之一： 定义和分解 */
    public static void permutation(char[] s, int from, int to) {
        if (to <= 1) {
            return;  //如果只包含一个元素，就返回
        }
        if (from == to) {/** 递归三要素之二：退出机制，如果from == to 则表示分解到了最后一个元素，此时直接输出就好 */
            System.out.println(s); //如果begin位置和to位置相同则说明是分解到最后一个元素，直接输出即可
        } else {
            for (int i = from; i <= to; i++) {
                swap(s, i, from);       //交换前缀，使其产生下一个前缀
                permutation(s, from + 1, to);  /** 递归三要素之三：如何变成更小的状态，这里from每次+1，使得要分解的字符串越来越小 */
                swap(s, from, i);       //将前缀换回，继续做上一个前缀的排序
            }
        }
    }

    public static void permutation2(char[] s, int from, int to){
        System.out.println("  ");

        if (to <= 1){
            return; //如果char数组只包含一个元素那么就直接返回
        }
        if (from == to){
            System.out.println(s);  //当from == to时，说明循环到了最后的一个元素此时直接输出该元素即可
        } else {
            for (int i = from; i <= to; i++){
                swap(s, from, i);   //交换前缀使其产生下一个前缀，from即使被固定的那个begin位置元素
                permutation2(s, from + 1, to); //
                swap(s, i, from); //将前缀换回，继续做此层前缀下或许的排列
            }
        }

    }
}
