/**
* @项目名称: Javacore
* @文件名称: Task1_6.java
* @Date: 2019年4月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

/**
 * 已知圆的半径 radius= 1.5，求其面积
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_6 {
    // 常量PI
    static final double PI = 3.141592653;

    /**
     * 计算圆的面积
     * 
     * @param r 半径
     * @return 面积
     */
    public double compArea(double r) {
        return PI * r * r;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task1_6 test = new Task1_6();

        double radius = 1.5;
        double result = test.compArea(radius);
        System.out.println("计算半径为" + radius + "的圆的面积为：" + result);
    }

}
