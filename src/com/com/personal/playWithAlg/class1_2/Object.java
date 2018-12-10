package com.personal.playWithAlg.class1_2;

/**
 * Created by mingyue on 2018/10/1.
 */
public class Object {

    /**
     * Object 对象定义每一个物品对象包含的属性
     */

    int weight; //每个物品的质量
    int price; //每个物品的价格
    int status; // 0：未选中  1：已选中 2：已经不可选


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
