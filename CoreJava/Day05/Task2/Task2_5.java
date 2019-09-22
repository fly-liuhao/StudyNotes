/**
* @项目名称: Javacore
* @文件名称: Task2_5.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Random;
import java.util.Scanner;

/**
 * 抽奖活动，控制台接收4位数会员号，会员号的百位数字等于产生的随机数字即为幸运会员
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_5 {
    /** 会员卡号 */
    private int cardNum;

    /**
     * 判断用户是否是幸运用户
     * 
     * @return true 是幸运用户 false 不是幸运用户
     */
    public boolean isLuck() {
        // 产生随机数[0,9]
        Random random = new Random();
        int tempNum = random.nextInt(9);

        // 获取会员卡号百位数字
        int hundredNum = this.cardNum / 100;
        hundredNum = hundredNum % 10;

        // 会员卡号百位数字与随机数数字比较
        if (this.cardNum == tempNum) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获得会员卡号
     * 
     * @return
     */
    public int getCardNum() {
        return cardNum;
    }

    /**
     * 设置会员卡号
     * 
     * @param cardNum
     */
    public void setCardNum(int cardNum) {
        if (cardNum >= 1000 && cardNum <= 9999) {
            this.cardNum = cardNum;
        } else {
            System.out.println("数据不合法~");
            System.exit(0);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_5 test = new Task2_5();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("请输入你的会员号（4位）：");
        int cardNum = sc.nextInt();

        test.setCardNum(cardNum);
        if (test.isLuck()) {
            System.out.println("您真幸运~您是幸运会员用户");
        }else {
            System.out.println("您不是幸运会员用户");
        }

    }

}
