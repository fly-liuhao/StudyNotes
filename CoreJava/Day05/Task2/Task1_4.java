/**
* @项目名称: Javacore
* @文件名称: Task1_4.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_4 {
    private int stbScore;
    private int javaScore;
    private int sqlScore;

    public int getStbScore() {
        return stbScore;
    }

    public void setStbScore(int stbScore) {
        this.stbScore = stbScore;
    }

    public int getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(int javaScore) {
        this.javaScore = javaScore;
    }

    public int getSqlScore() {
        return sqlScore;
    }

    public void setSqlScore(int sqlScore) {
        this.sqlScore = sqlScore;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task1_4 wangHao = new Task1_4();
        Scanner sc = new Scanner(System.in);

        System.out.print("STB的成绩是：");
        wangHao.setStbScore(sc.nextInt());

        System.out.print("Java的成绩是：");
        wangHao.setJavaScore(sc.nextInt());

        System.out.print("SQL的成绩是：");
        wangHao.setSqlScore(sc.nextInt());

        System.out.println("-----------------------------");
        System.out.println("STB      JAVA      SQL");
        System.out.println(
                wangHao.getStbScore() + "       " + wangHao.getJavaScore() + "        " + wangHao.getSqlScore());
        System.out.println("-----------------------------");

        int scoreDifference = wangHao.getJavaScore() - wangHao.getSqlScore();
        System.out.println("Java和SQL的成绩差：" + scoreDifference);

        double scoreAvg = (wangHao.getStbScore() + wangHao.getJavaScore() + wangHao.getSqlScore()) / 3.0;
        System.out.println("3门课的平均分数是：" + scoreAvg);

    }

}
