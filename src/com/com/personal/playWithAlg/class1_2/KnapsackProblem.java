package com.personal.playWithAlg.class1_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyue on 2018/10/1.
 *
 * 模仿课程中 C++ 代码的写法，只是自己默认把List中的数据有序排列
 *
 * 如果是给定的为无序的list集合，则需要先对数组中的物品排序
 */
public class KnapsackProblem {

    public void GreedyAlgo (List<com.personal.playWithAlg.class1_2.Object> srcObjs, int totalC) {
        int idx; //去到的符合要求的物品
        int ndc = 0;  //包内现在的总重量
        while ((idx = chooseFunc(srcObjs)) != -1){
            if (ndc + srcObjs.get(idx).weight <= totalC){ //如果新选择的这个物品加上原来的重量总重量没有超过规定总重要
                ndc = ndc + srcObjs.get(idx).weight;
                srcObjs.get(idx).setStatus(1);  //当一个物体被添加进了包裹以后它的状态就要改为 1
            } else {
                srcObjs.get(idx).setStatus(2);
                break;  //如果包内的总重量已经超过规定的totalC的重量
            }
        }
        for (int i = 0; i < srcObjs.size(); i++) {
            int status = srcObjs.get(i).getStatus();
            if (status == 1) {// 只有被塞入包中的物品再把质量打印出来
                int price = srcObjs.get(i).getPrice();
                System.out.println("包中物品的质量为：......." + price);
            }
            System.out.println("包中物品的状态为：" + status);
        }
        System.out.println("包中物品总质量为：   " + ndc );
    }


    private int chooseFunc(List<com.personal.playWithAlg.class1_2.Object> srcObjs){
        int index = -1; //
        int mp = 0; //
        /** 如果完全模仿套用算法怎么玩文章中的实例代码（c++写的）会有问题 */
        /** 这里改成：默认为srcObjs源数据列表物品是按照从小到大的顺序塞入包中，从质量最大的
         *  物品开始取 */
        for (int i = srcObjs.size() - 1; i < srcObjs.size(); i--){
            if (i < 0) {
                break;
            }
            if (srcObjs.get(i).status == 0 && srcObjs.get(i).price > mp){
                mp = srcObjs.get(i).price;
                index = i;
            }
        }
        return index;
    }

    /**
     * 新建源数据源的数据
     * @return 源数据集合
     */
    public static List<com.personal.playWithAlg.class1_2.Object>  initDate(){
        List<com.personal.playWithAlg.class1_2.Object> srcObjs = new ArrayList<>();
        com.personal.playWithAlg.class1_2.Object object1 = new com.personal.playWithAlg.class1_2.Object();
        com.personal.playWithAlg.class1_2.Object object2 = new com.personal.playWithAlg.class1_2.Object();
        com.personal.playWithAlg.class1_2.Object object3 = new com.personal.playWithAlg.class1_2.Object();
        com.personal.playWithAlg.class1_2.Object object4 = new com.personal.playWithAlg.class1_2.Object();
        com.personal.playWithAlg.class1_2.Object object5 = new com.personal.playWithAlg.class1_2.Object();
        com.personal.playWithAlg.class1_2.Object object6 = new com.personal.playWithAlg.class1_2.Object();
        com.personal.playWithAlg.class1_2.Object object7 = new com.personal.playWithAlg.class1_2.Object();

        object1.setStatus(0); object1.setPrice(10);object1.setWeight(35);
        object2.setStatus(0); object2.setPrice(40);object2.setWeight(30);
        object3.setStatus(0); object3.setPrice(30);object3.setWeight(60);
        object4.setStatus(0); object4.setPrice(50);object4.setWeight(50);
        object5.setStatus(0); object5.setPrice(35);object5.setWeight(40);
        object6.setStatus(0); object6.setPrice(40);object6.setWeight(10);
        object7.setStatus(0); object7.setPrice(30);object7.setWeight(25);

        srcObjs.add(object1);
        srcObjs.add(object3);
        srcObjs.add(object7);
        srcObjs.add(object5);
        srcObjs.add(object2);
        srcObjs.add(object6);
        srcObjs.add(object4);

        return srcObjs;
    }
}
