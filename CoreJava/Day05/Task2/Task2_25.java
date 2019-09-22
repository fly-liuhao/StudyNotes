/**
* @项目名称: Javacore
* @文件名称: Task2_25.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 经过几天的学习，老师给张浩一道测试题，让他先上机编写程序完成，然后老师检查是否合格。如果不合格，则继续编写。
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_25 {

    /**
     * 对测试题进行评价
     */
    public void evaluate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("是否合格？（是/否）:");
            String result = scanner.next().trim();
            if (result.equals("是")) {
                System.out.println("合格");
                break;
            }
            if (result.equals("否")) {
                System.out.println("不合格，继续编写。");
            }
        }
    }

    /**
     * 主方法
     * 
     * @param args
     */
    public static void main(String[] args) {
        Task2_25 test = new Task2_25();
        System.out.println("张浩提交测试题。");
        test.evaluate();

    }

}
