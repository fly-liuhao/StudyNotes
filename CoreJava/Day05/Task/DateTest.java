/**
* @项目名称: Javacore
* @文件名称: DateTest.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

import java.util.Scanner;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class DateTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Date date = new Date();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个（1000~3000）年份：");
        date.setYear(sc.nextInt());
        boolean result = date.judgeBissextile();
        if (result) {
            System.out.println("判断结果：是闰年！");
        } else {
            System.out.println("判断结果：不是闰年！");
        }

        Date date2 = new Date();
        System.out.println("请输入一个（1000~3000）年份：");
        date2.setYear(sc.nextInt());
        System.out.println("请输入一个（1~12）月份：");
        date2.setMonth(sc.nextInt());
        int monthDayCount = date2.compMonthDayCount();
        System.out.println(date2.getYear() + "年" + date2.getMonth() + "月有：" + monthDayCount + "天！");

    }

}
