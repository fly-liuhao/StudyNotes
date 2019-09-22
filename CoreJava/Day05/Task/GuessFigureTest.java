/**
* @项目名称: Javacore
* @文件名称: GuessFigureTest.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class GuessFigureTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 统计猜测次数
        int count = 0;
        Scanner sc = new Scanner(System.in);
        GuessFigure gFigure = new GuessFigure();

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
