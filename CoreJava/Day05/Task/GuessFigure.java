/**
* @项目名称: Javacore
* @文件名称: GuessFigure.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

import java.util.Random;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class GuessFigure {

    private int targetFigure;

    public GuessFigure() {
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

}
