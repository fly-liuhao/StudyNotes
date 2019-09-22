/**
* @项目名称: Javacore
* @文件名称: Task2_20.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 商场对顾客的年龄层次进行调查，计算各年龄层次的顾客比例
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_20 {

    /**
     * 对年龄层次进行调查
     */
    public void survey() {
        int sum1 = 0;
        int sum2 = 0;
        int length = 10;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            System.out.print("请输入第" + (i + 1) + "位顾客的年龄：");
            int age = sc.nextInt();
            if (age <= 30) {
                sum1++;
            } else {
                sum2++;
            }
        }
        System.out.println("30以下的比例是：" + (sum1 / (double) length * 100) + "%");
        System.out.println("30以上的比例是：" + (sum2 / (double) length * 100) + "%");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_20 test = new Task2_20();

        test.survey();
    }

}
