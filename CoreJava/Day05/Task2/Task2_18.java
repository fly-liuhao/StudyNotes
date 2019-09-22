/**
* @项目名称: Javacore
* @文件名称: Task2_18.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 循环输入某同学S1结业考试的5门课成绩，并计算平均分
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_18 {

    /**
     * 录入成绩计算出平均分
     */
    public void recordScore() {
        int sum = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入第 " + (++count) + " 门成绩：");
            sum += sc.nextInt();
            if (count == 5)
                break;
        }
        double scoreAvg = sum / 5.0;
        System.out.println("平均分为：" + scoreAvg);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        Task2_18 test = new Task2_18();
        test.recordScore();

    }

}
