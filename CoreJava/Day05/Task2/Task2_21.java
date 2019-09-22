/**
* @项目名称: Javacore
* @文件名称: Task2_21.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

/**
 * 2012年培养学生25万人，每年增长25%，请问按此增长速度，到哪一年培养学生人数将达到100万人？
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_21 {

    public void compStuNum(double stuNum, double rate) {
        // 年数计数
        int count = 0;
        while (true) {
            count++;
            stuNum = stuNum * (1 + rate);
            System.out.println("第" + (2012 + count) + "年学生人数为：" + stuNum + "万人");
            if (stuNum >= 100) {
                System.out.println("第" + (2012 + count) + "年培养学生人数达到100万人");
                break;
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        Task2_21 test = new Task2_21();

        // 2012年培养学生人数
        double stuNum = 25;// 万人
        // 年增长率
        double rate = 0.25;

        test.compStuNum(stuNum, rate);

    }
}
