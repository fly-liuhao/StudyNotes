/**
* @项目名称: Javacore
* @文件名称: MyDate.java
* @Date: 2019年6月7日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava11;

import java.util.Calendar;

/**
 * 获取当前的日期和时间
 * 
 * @author: liuhao
 * @version 1.0
 */
public class CurrentDate {

    /**
     * 得到当前的 年 月 日
     * 
     * @return String 年 月 日
     */
    public static String getMyDate() {
        Calendar calendar = Calendar.getInstance();// 工厂模式的使用
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + "-" + month + "-" + day;
    }

    /**
     * 得到当前的 时 分 秒
     * 
     * @return String 时 分 秒
     */
    public static String getTime() {
        Calendar calendar = Calendar.getInstance();// 工厂模式的使用
        int hour = calendar.get(Calendar.HOUR_OF_DAY);// 24小时制
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return hour + ":" + minute + ":" + second;
    }

    /**
     * 主方法调用测试
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(CurrentDate.getMyDate());
        System.out.println(CurrentDate.getTime());
    }
}
