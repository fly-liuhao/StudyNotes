/**
* @项目名称: Javacore
* @文件名称: Date.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Date {

    private int year;
    private int month;

    /**
     * 判断用户输入的年份是否为闰年
     * 
     * @return 判断结果（String）
     */
    public boolean judgeBissextile() {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int compMonthDayCount() {
        if (month == 2) {
            if (judgeBissextile()) {
                return 29;
            } else {
                return 28;
            }
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else {
            return 30;
        }

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 3000 || year < 1000) {
            System.out.println("输入数据不合法！");
            System.exit(1);
        }
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 12 || month < 1) {
            System.out.println("输入数据不合法！");
            System.exit(1);
        }
        this.month = month;
    }

}
