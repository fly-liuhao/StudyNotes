/**
* @项目名称: Javacore
* @文件名称: Task2_24.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 循环输入商品编号和购买数量，当输入 n 时结账，结账时计算应付金额并找零
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_24 {

    public void selectGoods() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择购买的商品编号：");
        System.out.println("1. T恤" + '\t' + "2.网球鞋" + '\t' + "3.网球拍");
        System.out.println("*********************************");
        // 总消费金额
        double totalMoney = 0;
        // 打折率
        double discount = 0.8;
        // 打折后应付金额
        double discountMoney = 0;

        while (true) {
            System.out.print("请选择商品编号：");
            int key = sc.nextInt();
            System.out.print("请输入购买数量：");
            int count = sc.nextInt();
            double money = 0;

            switch (key) {
            case 1:
                money = 245.0 * count;
                System.out.println("T恤 ￥245.0" + '\t' + "数量：" + count + '\t' + "合计 ￥" + money);
                break;
            case 2:
                money = 950.0 * count;
                System.out.println("网球鞋 ￥950.0" + '\t' + "数量：" + count + '\t' + "合计 ￥" + money);
                break;
            case 3:
                money = 550.0 * count;
                System.out.println("网球拍 ￥550.0" + '\t' + "数量：" + count + '\t' + "合计 ￥" + money);
                break;
            default:
                System.out.println("输入错误！");
                break;
            }
            // 总共金额（累加）
            totalMoney += money;

            System.out.print("是否继续？（y/n）");
            String result = sc.next();
            if (result.equals("n")) {

                // 计算打折后的应付金额
                discountMoney = totalMoney * discount;
                System.out.println();
                System.out.println("折扣：0.8");
                System.out.println("应付金额：" + discountMoney);
                System.out.print("实付金额：");
                double userMoney = sc.nextDouble();
                System.out.println("找零：" + (userMoney - discountMoney));
                break;
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_24 test = new Task2_24();
        test.selectGoods();

    }

}
