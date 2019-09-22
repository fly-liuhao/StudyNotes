/**
* @项目名称: Javacore
* @文件名称: Task1_2.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 从控制台输入张三同学的成绩，与李四的成绩（80分）比较，输出“张三的成绩比李四的成绩高吗?” 的判断结果
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_2 {

    // 成绩
    private int grade;

    public Task1_2() {
        super();
    }

    public Task1_2(int grade) {
        super();
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task1_2 zhangSan = new Task1_2();
        Task1_2 liSi = new Task1_2(80);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入张三同学的成绩：");
        zhangSan.setGrade(sc.nextInt());
        if (zhangSan.getGrade() > liSi.getGrade()) {
            System.out.println("张三同学的成绩比李四同学的高！");
        } else if (zhangSan.getGrade() < liSi.getGrade()) {
            System.out.println("张三同学的成绩比李四同学的低！");
        } else
            System.out.println("张三同学的成绩和李四同学的成绩相同！");
    }

}
