/**
* @项目名称: Javacore
* @文件名称: Task2_22.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 老师每天检查张浩的学习任务是否合格，如果不合格，则继续进行。老师给张浩安排的每天的学习任务为：上午阅读教材，学习理论部分，下午上机编程，掌握代码部分。
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_22 {

    /**
     * 老师检查任务
     */
    public void checkTask() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("合格了吗？（y/n）");
            String result = sc.next();

            if (result.equals("y")) {
                System.out.println("完成学习任务！");
                break;
            } else {
                System.out.println("上午阅读教材！");
                System.out.println("下午上机编程！");
                System.out.println();
            }
        }
    }

    /**
     * 主函数
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        Task2_22 test = new Task2_22();
        test.checkTask();
    }

}
