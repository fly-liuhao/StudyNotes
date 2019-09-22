/**
* @项目名称: Javacore
* @文件名称: Task1_7.java
* @Date: 2019年4月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.awt.geom.PathIterator;

/**
 * 某班第一次Java考试平均分81.29，第二次比第一次多2分，计算第二次考试平均分？
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_7 {
    // Java考试平均成绩
    private double javaScoreAvg = 81.29;

    public double comJavaScore(double diff) {
        return javaScoreAvg + diff;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task1_7 test = new Task1_7();

        // 因为第二次比记一次多两分
        double result = test.comJavaScore(2);
        System.out.println("第二次考试平均分：" + result);

    }

}
