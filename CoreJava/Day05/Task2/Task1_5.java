/**
* @项目名称: Javacore
* @文件名称: Task1_5.java
* @Date: 2019年4月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 根据天数（46）计算周数和剩余的天数
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_5 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int dayNum = 46;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个天数：");
        dayNum = sc.nextInt();

        int week = dayNum / 7;
        int remainDay = dayNum % 7;
        System.out.println(dayNum + "天一共有" + week + "周，剩余" + remainDay + "天");
    }

}
