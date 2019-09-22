/**
* @项目名称: Javacore
* @文件名称: Task2_26.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Random;
import java.util.Scanner;

import cn.edu.tit.corejava05.task.GuessFigure;

/**
 * 猜数字游戏，程序随机生成0-50之间的整数，用户在键盘输入猜测的数字，程序提示猜大了、猜小了、猜对了，并输出用户一共猜测的次数。
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_26 {

    /** 目标数字 */
    private int targetFigure;

    public Task2_26() {
        Random ra = new Random();
        targetFigure = ra.nextInt(50);
    }

    /**
     * 猜测数字，输出猜测结果，以及猜测次数
     */
    public int judgeFigure(int guessFigure) {

        if (guessFigure > targetFigure) {
            return 1;
        } else if (guessFigure > targetFigure) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_26 gFigure = new Task2_26();
        Scanner sc = new Scanner(System.in);

        // 统计猜测次数
        int count = 0;
        System.out.println("系统生成了一个数**，范围是0~50，请玩家进行猜测:");

        while (true) {
            int tempFigure = sc.nextInt();
            int result = gFigure.judgeFigure(tempFigure);
            count++;
            if (result == 1) {
                System.out.println("您猜大了！");
            } else if (result == -1) {
                System.out.println("您猜小了！");
            } else {
                System.out.println("您猜对了！" + "总猜测次数：" + count);
                break;
            }
        }
    }

}
