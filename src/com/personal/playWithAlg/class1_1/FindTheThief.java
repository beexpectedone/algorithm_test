package com.personal.playWithAlg.class1_1;

/**
 * Created by mingyue on 2018/9/27.
 */
public class FindTheThief {


    /**
     *  A说：“我不是小偷。”    x !=0
        B说：“C 是小偷。”     x = 2
        C说：“小偷肯定是 D。”  x = 3
        D说：“C 是在冤枉人。”  x != 3
     * */
    public void whoIsThief(){

        String[] criminalSuspect = {"A", "B", "C", "D"};
        for (int x = 0; x < 4; x++){ //A, B, C, D 四个人分别用0 ～ 3 这四个数字代替

            int dis_a = (x != 0) ? 1 : 0; //如果A不是贼就输出1，否则就输出0
            int dis_b = (x == 2) ? 1 : 0;
            int dis_c = (x == 3) ? 1 : 0;
            int dis_d =  1 - dis_c;  //  这里表示 C 与 D 说的话是相反的，这种表示方式还是很厉害的

            if (dis_a + dis_b + dis_c + dis_d == 3){
                System.out.println(" " + criminalSuspect[x] + " " + "是小偷");
                break;
            }
        }
    }


}
