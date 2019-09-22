/**
* @项目名称: Javacore
* @文件名称: Task1_10.java
* @Date: 2019年4月28日
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
public class Task1_10 {

    /**
     * 验证用户是否抽奖成功
     * 
     * @param cardNumber 用户卡号
     * @return true 成功 false 失败
     */
    public boolean isPrizeWinner(int cardNumber) {
        if (cardNumber > 9999 || cardNumber < 1000) {
            System.out.println("error:卡号不正确！");
            System.exit(0);
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += cardNumber % 10;
            cardNumber = cardNumber / 10;
        }
        System.out.println("会员卡号" + cardNumber + "各位之和:" + sum);
        if (sum > 20) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task1_10 test = new Task1_10();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入4位会员卡号：");
        int cardNumber = sc.nextInt();
        if (test.isPrizeWinner(cardNumber)) {
            System.out.println("是幸运用户吗？true");
        } else {
            System.out.println("是幸运用户吗？false");
        }
    }

}
