/**
* @项目名称: Javacore
* @文件名称: Task2_6.java
* @Date: 2019年5月1日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 对学员的结业考试成绩评测， 成绩>=80 ：良好， 成绩>=60 ：中等， 成绩<60 ：差
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_6 {
    
    /** 结业考试成绩 */
    private int score;

    /**
     * 对学员的结业考试成绩评测
     */
    public void scoreGrade() {
        if (this.score >= 80) {
            System.out.println("成绩良好！");
        } else if (this.score >= 60) {
            System.out.println("成绩中等！");
        }else {
            System.out.println("成绩差！");
        }
    }

    /**
     * 获取结业考试成绩
     * 
     * @return 结业考试成绩
     */
    public int getScore() {
        return score;
    }

    /**
     * 设置结业考试成绩
     * 
     * @param score 结业考试成绩
     */
    public void setScore(int score) {
        this.score = score;
    }

    
    
    /**
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        Task2_6 test = new Task2_6();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学员结业考试成绩：");
        test.setScore(sc.nextInt());
        test.scoreGrade();
    }

}
