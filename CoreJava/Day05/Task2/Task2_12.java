/**
* @项目名称: Javacore
* @文件名称: Task2_12.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 控制台接收名次，根据名次的不同给予不同奖励，
 *            第一名：参加麻省理工大学组织的1个月夏令营
 *            第二名：奖励惠普笔记本电脑一部
 *            第三名：奖励移动硬盘一个
 *            其他：没有任何奖励
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_12 {

    /** 名次 */
    private String rank;

    /**
     * 依据名次给予不同的奖励
     */
    public void giveAward() {
        if (rank.equals("一")) {
            System.out.println("恭喜你获得：“参加麻省理工大学组织的1个月夏令营”的奖励！");
        } else if (rank.equals("二")) {
            System.out.println("恭喜你获得：“奖励惠普笔记本电脑一部”的奖励！");
        } else if (rank.equals("三")) {
            System.out.println("恭喜你获得：“奖励移动硬盘一个”的奖励！");
        } else if (rank.equals("其他")) {
            System.out.println("很遗憾，你没有任何奖励！");
        } else {
            System.out.println("输入错误！");
            System.exit(0);
        }
    }

    /**
     * 获取名次
     * 
     * @return 名次
     */
    public String getRank() {
        return rank;
    }

    /**
     * 设置名次
     * 
     * @param rank 名次
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_12 test = new Task2_12();
        Scanner sc = new Scanner(System.in);
        System.out.println("请告诉我名次（一、二、三、其他）：");
        test.setRank(sc.next());
        test.giveAward();

    }

}
