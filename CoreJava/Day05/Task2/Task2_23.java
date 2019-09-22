/**
* @项目名称: Javacore
* @文件名称: Task2_23.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 循环输入商品编号，显示对应的商品价格，输入“n”结束循环
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_23 {

    /**
     * 根据商品编号选择商品
     */
    public void selectGoods() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择购买的商品编号：");
        System.out.println("1. T恤" + '\t' + "2.网球鞋" + '\t' + "3.网球拍");
        System.out.println("*********************************");

        while (true) {
            System.out.print("请选择商品编号：");
            int key = sc.nextInt();
            switch (key) {
            case 1:
                System.out.println("T恤" + '\t' + "￥245.0");
                break;
            case 2:
                System.out.println("网球鞋" + '\t' + "￥950.0");
                break;
            case 3:
                System.out.println("网球拍" + '\t' + "￥550.0");
                break;

            default:
                System.out.println("输入错误！");
                break;
            }
            System.out.println();
            System.out.print("是否继续？（y/n）");
            String result = sc.next();
            if (result.equals("n")) {
                System.out.println("程序结束");
                break;
            }
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_23 test = new Task2_23();
        test.selectGoods();
    }

}
