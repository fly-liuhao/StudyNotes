/**
* @项目名称: Javacore
* @文件名称: DateUtil.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期实用类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class DateUtil {
    /**
     * 使用Date类获取当前日期时间
     * 
     * @return 当前日期时间
     */
    public static String getCurrentDate() {
        Date date = new Date();
        return date.toLocaleString();
    }

    /**
     * 使用Calendar类获取当前日期时间
     * 
     * @return 当前日期时间
     */
    public static String getCurrentDateByCalendar() {
        Calendar date = Calendar.getInstance();
        return "" + date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH) + 1) + "-"
                + date.get(Calendar.DAY_OF_MONTH) + " " + date.get(Calendar.HOUR_OF_DAY) + ":"
                + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
    }

    /**
     * @param args 主方法参数
     */
    public static void main(String[] args) {
        
        //输出但当前日期时间
        System.out.println(DateUtil.getCurrentDate());
        System.out.println(DateUtil.getCurrentDateByCalendar());
    }

}
