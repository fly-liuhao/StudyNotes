/**
* @项目名称: Javacore
* @文件名称: Task1_12.java
* @Date: 2019年4月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.LinkedList;
import java.util.List;

/**
 * 需求说明：结算时打印购物小票计算此次购物获得的会员积分
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_12 {

    /** 商品名称 */
    private String commodityName;
    /** 商品原价 */
    private double univalence;
    /** 购买个数 */
    private int count;

    public Task1_12() {
        super();
    }

    public Task1_12(String commodityName, double univalence, int count) {
        super();
        this.commodityName = commodityName;
        this.univalence = univalence;
        this.count = count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // T恤
        Task1_12 shirt = new Task1_12("T恤", 245, 2);
        // 网球鞋
        Task1_12 sandShoes = new Task1_12("网球鞋", 570, 1);
        // 网球拍
        Task1_12 tennisRacket = new Task1_12("网球拍", 320, 1);
        // 折扣
        int discount = 8;
        // 消费总金额
        double totalMoney = discount * 0.1 * (shirt.count * shirt.univalence + sandShoes.count * sandShoes.univalence
                + tennisRacket.count * tennisRacket.univalence);
        // 实际消费
        double trueMoney = 1500;
        // 找零
        double residue = trueMoney - totalMoney;
        // 积分
        int integral = 33;

        List<Task1_12> goods = new LinkedList<>();
        goods.add(shirt);
        goods.add(sandShoes);
        goods.add(tennisRacket);

        System.out.println("***********消费单***********");
        System.out.println("购买物品    单价    个数        金额");
        for (Task1_12 str : goods) {
            System.out.println(
                    str.commodityName + "\t￥" + str.univalence + " \t" + str.count + "\t" + str.univalence * str.count);
        }
        System.out.println("折扣            " + discount + "折");
        System.out.println("消费总金额 ￥" + totalMoney);
        System.out.println("实际消费    ￥" + trueMoney);
        System.out.println("找钱           ￥" + residue);
        System.out.println("本次购物的积分是：" + integral);

    }

}
