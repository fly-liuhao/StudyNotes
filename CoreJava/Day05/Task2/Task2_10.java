/**
* @项目名称: Javacore
* @文件名称: Task2_10.java
* @Date: 2019年5月1日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 根据优惠，结算折后购物金额
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_10 {

    /** 购物消费金额 */
    private double shoppingMoney;
    /** 折扣 */
    private double discount;
    /** 是否是会员 */
    boolean member;

    /**
     * 带参构造函数
     * 
     * @param shoppingMoney 购物消费金额
     * @param member        是否是是会员
     */
    public Task2_10(double shoppingMoney, boolean member) {
        super();
        this.shoppingMoney = shoppingMoney;
        this.member = member;
    }

    /**
     * 计算顾客购物实际消费金额
     * 
     * @return 实际消费金额
     */
    public double compDiscountMoney() {
        if (member) {
            if (shoppingMoney < 200) {
                discount = 0.8;
            } else {
                discount = 0.75;
            }
        } else {
            if (shoppingMoney < 100) {
                discount = 1;
            } else {
                discount = 0.9;
            }
        }
        return shoppingMoney * discount;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入顾客的消费金额：");
        double shoppingMoney = sc.nextDouble();
        System.out.println("顾客是会员吗？(y/n)");
        boolean member = false;
        String result = sc.next();
        if (result.equals("y")) {
            member = true;
        } else if (result.equals("n")) {
            member = false;
        }else {
            System.out.println("输入错误！");
            System.exit(0);
        }

        Task2_10 test = new Task2_10(shoppingMoney, member);
        double trueMoney = test.compDiscountMoney();
        System.out.println("顾客打完折后的消费金额为：" + trueMoney + "元");
    }

}
