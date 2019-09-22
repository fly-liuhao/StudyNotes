/**
* @项目名称: Javacore
* @文件名称: Task2_14.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

import cn.edu.tit.corejava05.Test1;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_14 {
    /** 消费金额 */
    private double shoppingMoney;

    /**
     * 消费换购
     * 
     * @param key 用户选择
     */
    public void discountShopping(int key) {
        switch (key) {
        case 0:
            shoppingMoney += 0;
            System.out.println("本次消费总金额为：" + shoppingMoney);
            System.out.println("未参与购换");
            break;
        case 1:
            if (shoppingMoney >= 50) {
                shoppingMoney += 2;
                System.out.println("本次消费总金额为：" + shoppingMoney);
                System.out.println("成功购换：百事可乐饮料1瓶");
            } else {
                System.out.println("您消费金额不支持此次换购！");
                System.out.println("本次消费总金额为：" + shoppingMoney);
            }
            break;
        case 2:
            if (shoppingMoney >= 100) {
                shoppingMoney += 3;
                System.out.println("本次消费总金额为：" + shoppingMoney);
                System.out.println("成功购换：500ml可乐一瓶");
            } else {
                System.out.println("您消费金额不支持此次换购！");
                System.out.println("本次消费总金额为：" + shoppingMoney);
            }
            break;
        case 3:
            if (shoppingMoney >= 100) {
                shoppingMoney += 10;
                System.out.println("本次消费总金额为：" + shoppingMoney);
                System.out.println("成功购换：5公斤面粉");
            } else {
                System.out.println("您消费金额不支持此次换购！");
                System.out.println("本次消费总金额为：" + shoppingMoney);
            }
            break;
        case 4:
            if (shoppingMoney >= 200) {
                shoppingMoney += 10;
                System.out.println("本次消费总金额为：" + shoppingMoney);
                System.out.println("成功购换：1个苏泊尔炒菜锅");
            } else {
                System.out.println("您消费金额不支持此次换购！");
                System.out.println("本次消费总金额为：" + shoppingMoney);
            }
            break;
        case 5:
            if (shoppingMoney >= 200) {
                shoppingMoney += 20;
                System.out.println("本次消费总金额为：" + shoppingMoney);
                System.out.println("成功购换：欧莱雅爽肤水一瓶");
            } else {
                System.out.println("您消费金额不支持此次换购！");
                System.out.println("本次消费总金额为：" + shoppingMoney);
            }
            break;

        default:
            System.out.println("输入错误！");
            break;
        }
    }

    public double getShoppingMoney() {
        return shoppingMoney;
    }

    public void setShoppingMoney(double shoppingMoney) {
        this.shoppingMoney = shoppingMoney;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_14 test = new Task2_14();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入消费金额：");
        int money = sc.nextInt();
        int key = 0;
        test.setShoppingMoney(money);
        if (money > 50) {
            System.out.println("您有资格参加优惠换购活动！");
            System.out.println("1：满50元，加2元换购百事可乐饮料1瓶");
            System.out.println("2：满100元，加3元换购500ml可乐一瓶");
            System.out.println("3：满200元，加10元换购5公斤面粉");
            System.out.println("4：满200元，加10元可换购1个苏泊尔炒菜锅");
            System.out.println("5：满200元，加20元可换购欧莱雅爽肤水一瓶");
            System.out.println("0：不换购");
            System.out.println("请选择：");
            key = sc.nextInt();
        }

        test.discountShopping(key);

    }

}
