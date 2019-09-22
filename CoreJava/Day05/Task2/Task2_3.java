/**
* @项目名称: Javacore
* @文件名称: Task2_3.java
* @Date: 2019年5月1日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 控制台接收 Java 成绩，如果张浩Java考试成绩大于98分，老师就奖励他一个MP4，否则老师就罚他进行编码
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_3 {

    /** Java成绩 */
    private int javaScore;

    /**
     * 无参构造
     */
    public Task2_3() {
        super();
    }

    /**
     * 带参构造
     * 
     * @param javaScore Java成绩
     */
    public Task2_3(int javaScore) {
        super();
        this.javaScore = javaScore;
    }

    /**
     * 获取Java成绩
     * 
     * @return Java成绩
     */
    public int getJavaScore() {
        return javaScore;
    }

    /**
     * 设置Java成绩
     * 
     * @param javaScore Java成绩
     */
    public void setJavaScore(int javaScore) {
        this.javaScore = javaScore;
    }

    /**
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        Task2_3 zhanghao = new Task2_3();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入张浩的Java成绩：");
        zhanghao.setJavaScore(sc.nextInt());
        
        if (zhanghao.getJavaScore() > 98) {
            System.out.println("恭喜你获得一个MP4作为奖励!");
        } else {
            System.out.println("你的成绩还不够获得奖励，罚你进行编码~");
        }
    }

}
