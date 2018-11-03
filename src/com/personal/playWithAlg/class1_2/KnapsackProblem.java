package com.personal.playWithAlg.class1_2;

import java.util.List;

/**
 * Created by mingyue on 2018/10/1.
 */
public class KnapsackProblem {

    public void GreedyAlgo (List<Object> srcObjs, int totalC) {
        int idx; //去到的符合要求的物品
        int ndc = 0;  //包内现在的总重量

        while ((idx = chooseFunc(srcObjs,0)) != -1){
            if (ndc + srcObjs.get(idx).weight <= totalC){ //如果新选择的这个物品加上原来的重量总重量没有超过规定总重要
                ndc = ndc + srcObjs.get(idx).weight;
                srcObjs.get(idx).setStatus(1);  //当一个物体被添加进了包裹以后它的状态就要改为 1
            } else {
                srcObjs.get(idx).setStatus(2);
                break;  //如果包内的总重量已经超过规定的totalC的重量
            }

        }
    }


    private int chooseFunc(List<Object> srcObjs, int c){
        int index = -1; //
        int mp = 0; //
        for (int i = 0; i < srcObjs.size() - 1; i++){
            if (srcObjs.get(i).status == 0 && srcObjs.get(i).price > mp){
                mp = srcObjs.get(i).price;
                index = i;
            }
        }

        return index;
    }
}
