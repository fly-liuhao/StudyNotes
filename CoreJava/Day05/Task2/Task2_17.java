/**
* @项目名称: Javacore
* @文件名称: Task2_17.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 计算100以内（包括100）的偶数之和
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_17 {

    public int compEvenNum(int endNum) {
        int sum = 0;
        for (int i = 0; i <= endNum; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_17 test = new Task2_17();
        Scanner sc = new Scanner(System.in);

        System.out.println("请问计算到少以内的偶数之和？");
        int number = sc.nextInt();

        // 计算偶数之和
        int sum = test.compEvenNum(number);
        System.out.println(number + "以内的偶数之和为：" + sum);

    }

}
