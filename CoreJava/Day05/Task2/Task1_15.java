/**
* @项目名称: Javacore
* @文件名称: Task1_15.java
* @Date: 2019年4月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.xml.stream.events.StartDocument;

/**
 * 用户输入开始年月日和结束年月日，输出该时间段的天数
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_15 {

    /**
     * 判断输入日期是否合法
     * 
     * @param startYear  开始日期年份
     * @param startMonth 开始日期月份
     * @param startDay   开始日期天
     * @param endYear    结束日期年份
     * @param endMonth   结束日期月份
     * @param endDay     结束日期天
     * @return true 数据合法， false 数据不合法
     */
    public boolean isLegit(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        if (endYear - startYear < 0) {
            return false;
        } else {
            if (endMonth - startMonth < 0) {
                return false;
            } else {
                if (endDay - startDay < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断是否是闰年
     * 
     * @param year 输入年份
     * @return true 是闰年，false 不是闰年
     */
    public boolean judgeBissextile(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算当前日期在这一年已经过去的天数
     * 
     * @param year  年份
     * @param month 月份
     * @param day   天
     * @return 这一年已经过去多少天
     */
    public int compPassDay(int year, int month, int day) {
        int passDay = 0;
        for (int i = 1; i <= month - 1; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                passDay += 31;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                passDay += 30;
            } else if (judgeBissextile(year)) {
                passDay += 29;
            } else {
                passDay += 28;
            }
        }
        passDay += day;
        return passDay;
    }

    /**
     * 计算两日期之间的天数
     * 
     * @param start 开始日期
     * @param end   结束日期
     * @return 该段时间总共天数
     * @throws ParseException Date异常
     */
    public int compDayNum(String start, String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 将字符串日期转化为Date类型
        Date startData = sdf.parse(start);
        Date endDate = sdf.parse(end);

        // 获得起始日期、结束日期的年月日
        Calendar cal = Calendar.getInstance();
        cal.setTime(startData);
        int startYear = cal.get(Calendar.YEAR);// 获取年份
        int startMonth = cal.get(Calendar.MONTH) + 1;// 获取月份
        int startDay = cal.get(Calendar.DATE);// 获取日

        cal.setTime(endDate);
        int endYear = cal.get(Calendar.YEAR);// 获取年份
        int endMonth = cal.get(Calendar.MONTH) + 1;// 获取月份
        int endDay = cal.get(Calendar.DATE);// 获取日

        // 判断输入数据是否合法
        if (!isLegit(startYear, startMonth, startDay, endYear, endMonth, endDay)) {
            System.out.println("数据不合法！");
            System.exit(0);
        }

        // 计算最终的结果：两日期之间的时间
        int dayNum = 0;
        if (startYear - endYear != 0) {
            // 计算起始时间在这一年已经过去的天数
            int passDay1 = compPassDay(startYear, startMonth, startDay);

            // 计算起始时间距离这一年结束还剩多少天
            int surplusDay = 0;
            if (judgeBissextile(startYear)) {
                surplusDay = 366 - passDay1;
            } else {
                surplusDay = 365 - passDay1;
            }

            // 计算结束时间在这一年已经过去的天数
            int passDay2 = compPassDay(endYear, endMonth, endDay);

            // 计算度过的完整一年的天数
            int passDay3 = 0;
            for (int i = startYear + 1; i <= endYear - 1; i++) {
                if (judgeBissextile(i)) {
                    passDay3 += 366;
                } else {
                    passDay3 += 365;
                }
            }

            // 计算最后开始日期到结束日期该时间段的天数
            dayNum = surplusDay + passDay2 + passDay3;
        } else {
            // 计算起始时间在这一年已经过去的天数
            int passDay1 = compPassDay(startYear, startMonth, startDay);

            // 计算结束时间在这一年已经过去的天数
            int passDay2 = compPassDay(endYear, endMonth, endDay);

            // 计算开始日期到结束日期该时间段的天数
            dayNum = passDay2 - passDay1;
        }

        return dayNum;
    }

    /**
     * @param args 主函数参数
     * @throws ParseException 异常
     */
    public static void main(String[] args) throws ParseException {
        Task1_15 test = new Task1_15();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入开始日期（格式为xxxx-xx-xx）：");
        String start = sc.next();
        System.out.println("请输入结束日期（格式为xxxx-xx-xx）：");
        String end = sc.next();

        int dayNum = test.compDayNum(start, end);
        System.out.println("该时间段的天数为：" + dayNum);

    }

}
