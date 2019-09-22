/**
* @项目名称: Javacore
* @文件名称: Task2_11.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 会员购物时，根据积分的不同享受不同的折扣，计算会员购物时获得的折扣
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_11 {
    /** 购物消费金额 */
    private double shoppingMoney;
    /** 折扣 */
    private double discount;
    /** 积分 */
    int integral;

    /**
     * 无参构造函数
     */
    public Task2_11() {
        super();
    }

    /**
     * 带参构造函数
     * 
     * @param shoppingMoney 购物消费金额
     * @param integral      积分
     */
    public Task2_11(double shoppingMoney, int integral) {
        super();
        this.shoppingMoney = shoppingMoney;
        this.integral = integral;
    }

    /**
     * 计算顾客购物实际消费金额
     * 
     * @return 实际消费金额
     */
    public double compDiscountMoney() {
        if (this.integral < 2000) {
            discount = 0.9;
        } else if (this.integral < 4000) {
            discount = 0.8;
        } else if (this.integral < 8000) {
            discount = 0.7;
        } else {
            discount = 0.6;
        }
        return shoppingMoney * discount;
    }

    /**
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入顾客的消费金额：");
        double shoppingMoney = sc.nextDouble();
        System.out.println("请输入顾客的积分：");
        int integral = sc.nextInt();

        Task2_11 test = new Task2_11(shoppingMoney, integral);
        double trueMoney = test.compDiscountMoney();
        System.out.println("顾客打完折后的消费金额为：" + trueMoney + "元");

    }

}
