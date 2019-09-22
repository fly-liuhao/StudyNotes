/**
* @项目名称: Javacore
* @文件名称: Task2_19.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 求1~100之间不能被3整除的数之和
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_19 {

    /**
     * 计算1~100之间不能被3整除的数之和
     * 
     * @param number 范围最大值
     * @return 求和结果
     */
    public int getResult(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            if (i % 3 != 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_19 test = new Task2_19();
        Scanner sc = new Scanner(System.in);
        System.out.println("请问计算到少以内不能被3整除的数之和？");

        int number = sc.nextInt();
        int sum = test.getResult(number);
        System.out.println(number + "以内不能被3整除的数之和为：" + sum);
    }

}
