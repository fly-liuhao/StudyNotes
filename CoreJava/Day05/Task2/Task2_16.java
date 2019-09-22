/**
* @项目名称: Javacore
* @文件名称: Task2_16.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 实现打印50份试卷“打印第几分，还剩几份”
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_16 {

    /**
     * 打印试卷，并显示剩余数量
     * @param number
     */
    public void printTestPaper(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println("正在打印第 " + i + "份卷子，还剩 " + (number - i) + " 份");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_16 test = new Task2_16();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入需要打印的试卷数量：");
        int number = sc.nextInt();

        // 打印
        test.printTestPaper(number);

    }

}
