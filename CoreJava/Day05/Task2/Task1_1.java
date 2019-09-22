/**
* @项目名称: Javacore
* @文件名称: Task1_1.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

/**
 * 学生李丽的Java成绩是80分，学员张萌的 Java 成绩与李丽的相同，输出张萌的成绩。
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_1 {
    // Java成绩
    private int grade;

    public Task1_1() {
        super();
    }

    public Task1_1(int grade) {
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
        Task1_1 liLi = new Task1_1(80);
        Task1_1 zhagnMeng = new Task1_1();

        // 学员张萌的 Java 成绩与李丽的相同
        zhagnMeng.setGrade(liLi.getGrade());

        // 输出张萌的成绩
        System.out.println("张萌的Java成绩：" + zhagnMeng.getGrade());
    }

}
