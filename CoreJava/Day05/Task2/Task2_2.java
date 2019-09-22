/**
* @项目名称: Javacore
* @文件名称: Task2_2.java
* @Date: 2019年5月1日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 控制台接收张浩的 Java成绩，音乐成绩。
 * 当张浩Java成绩大于98分，而且音乐成绩大于80分，老师奖励他；或者Java成绩等于100分，音乐成绩大于70分，老师也可以奖励他
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_2 {
    /** Java成绩 */
    private int javaScore;
    /** 音乐成绩 */
    private int musicScore;

    public Task2_2() {
        super();
    }

    public Task2_2(int javaScore, int musicScore) {
        super();
        this.javaScore = javaScore;
        this.musicScore = musicScore;
    }

    public int getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(int javaScore) {
        this.javaScore = javaScore;
    }

    public int getMusicScore() {
        return musicScore;
    }

    public void setMusicScore(int musicScore) {
        this.musicScore = musicScore;
    }

    /**
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        Task2_2 zhanghao = new Task2_2();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入张浩的Java成绩：");
        zhanghao.setJavaScore(sc.nextInt());
        System.out.println("请输入张浩的音乐成绩：");
        zhanghao.setMusicScore(sc.nextInt());

        if ((zhanghao.getJavaScore() > 98 && zhanghao.getMusicScore() > 80)
                || (zhanghao.getJavaScore() == 100 && zhanghao.getMusicScore() > 70)) {
            System.out.println("恭喜你获得一个MP4作为奖励!");
        } else {
            System.out.println("你的成绩还不够获得奖励，继续努力哟`");
        }
    }

}
