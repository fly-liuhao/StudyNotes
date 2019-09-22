/**
* @项目名称: Javacore
* @文件名称: Task1_11.java
* @Date: 2019年4月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 用户从键盘接收商品折扣，并判断商品享受此折扣后价格是否低于100
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_11 {

    /** 商品名称 */
    private String commodityName;
    /** 商品原价 */
    private double originalPrice;

    public Task1_11() {
        super();
    }

    public Task1_11(String commodityName, double originalPrice) {
        super();
        this.commodityName = commodityName;
        this.originalPrice = originalPrice;
    }

    /**
     * 计算商品折扣后价格
     * 
     * @param rate 折扣率
     * @return 商品折扣后金额
     */
    public double compDiscountPrice(double rate) {
        return originalPrice * rate;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // T恤价格
        Task1_11 shirt = new Task1_11("T恤", 245);
        // 网球鞋价格
        Task1_11 sandShoes = new Task1_11("网球鞋", 570);
        // 网球拍价格
        Task1_11 tennisRacket = new Task1_11("网球拍", 320);
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入折扣：");
        double rate = sc.nextDouble();

        System.out.print(shirt.commodityName + "折扣价低于100吗？");
        if (shirt.compDiscountPrice(rate) < 100) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.print(sandShoes.commodityName + "折扣价低于100吗？");
        if (sandShoes.compDiscountPrice(rate) < 100) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.print(tennisRacket.commodityName + "折扣价低于100吗？");
        if (tennisRacket.compDiscountPrice(rate) < 100) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
