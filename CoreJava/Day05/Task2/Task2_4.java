/**
* @项目名称: Javacore
* @文件名称: Task2_4.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Random;

/**
 * 买彩票，如果体彩中了500万，我买车、资助希望工程、去欧洲旅游如果没中，我买下一期体彩，继续烧高香
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_4 {

    /**
     * 判断的是否中奖
     * 
     * @return true 中奖 false 未中奖
     */
    public boolean isWinning() {
        Random random = new Random();
        double tempRandom = random.nextDouble();
        if (tempRandom > 0.9) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        Task2_4 test = new Task2_4();

        if (test.isWinning()) {
            System.out.println("我买车、资助希望工程、去欧洲旅游~");
        } else {
            System.out.println("我买下一期体彩，继续烧高香!");
        }
    }

}
