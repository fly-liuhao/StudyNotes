/**
* @项目名称: Javacore
* @文件名称: Task2_9.java
* @Date: 2019年5月1日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 输入小明的考试成绩， 显示所获奖励 成绩==100分，爸爸给他买辆车 成绩>=90分，妈妈给他买MP4
 * 90分>成绩>=60分，妈妈给他买本参考书成绩<60分，什么都不买
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_9 {

    /** 姓名 */
    private String name;
    /** 成绩 */
    private int score;

    /**
     * 无参构造函数
     */
    public Task2_9() {
        super();
    }

    /**
     * 带参构造函数
     * 
     * @param name
     * @param score
     */
    public Task2_9(String name) {
        super();
        this.name = name;
    }

    /**
     * 根据成绩显示奖励内容
     */
    public void showAward() {
        if (this.score == 100) {
            System.out.println("爸爸给你买辆车~");
        } else if (this.score >= 90) {
            System.out.println("妈妈给你买MP4~");
        } else if (this.score >= 60) {
            System.out.println("妈妈给你买本参考书！");
        } else {
            System.out.println("什么都不给你买！");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        Task2_9 test = new Task2_9("张三");
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入" + test.getName() + "的成绩：");
        test.setScore(sc.nextInt());
        test.showAward();
    }

}
