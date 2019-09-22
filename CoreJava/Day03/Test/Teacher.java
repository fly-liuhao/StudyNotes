/**
* @项目名称: Javacore
* @文件名称: Teacher.java
* @Date: 2019年4月26日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava03.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Teacher类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Teacher {

    // 教师工号
    private String tId;

    // 教师姓名
    private String tName;

    // 教师年龄
    private String tAge;

    // 教师学历
    private String tDegree = "硕士";

    // 教师职称
    private String tTitle = "讲师";

    // 月薪
    private double tMonthSal = 3000.0;

    /**
     * 默认构造函数
     */
    public Teacher() {
        super();
    }

    /**
     * 带参构造函数
     * 
     * @param tId   教师工号
     * @param tName 教师姓名
     * @param tAge  教师年龄
     */
    public Teacher(String tId, String tName, String tAge) {
        super();
        this.tId = tId;
        this.tName = tName;
        this.tAge = tAge;
    }

    /**
     * 带参构造函数
     * 
     * @param tId       教师工号
     * @param tName     教师姓名
     * @param tAge      教师年龄
     * @param tDegree   教师学历
     * @param tTitle    教师职称
     * @param tMonthSal 月薪
     */
    public Teacher(String tId, String tName, String tAge, String tDegree, String tTitle, double tMonthSal) {
        super();
        this.tId = tId;
        this.tName = tName;
        this.tAge = tAge;
        this.tDegree = tDegree;
        this.tTitle = tTitle;
        this.tMonthSal = tMonthSal;
    }

    /**
     * 根据给出的出生年份计算教师年龄
     * 
     * @param birthYear 教师出生年份
     * @return 教师年龄
     */
    public Integer compAge(int tBirthYear) {
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        // 获取系统日期年份
        String newYearString = df.format(new Date());
        // 转化为int数据类型
        int nowYearInt = Integer.parseInt(newYearString);

        return nowYearInt - tBirthYear;
    }

    /**
     * 计算教师工龄
     * 
     * @param entryYear 教师入职年份
     * @return 教师工龄
     */
    public Integer compWorkAge(int entryYear) {
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        // 获取系统日期年份
        String newYearString = df.format(new Date());
        // 转化为int数据类型
        int nowYearInt = Integer.parseInt(newYearString);

        return nowYearInt - entryYear;
    }

    /**
     * 计算教师年薪
     * 
     * @param performanceSalary 教师月薪
     * @return 教师年薪
     */
    public double compYearSal(double performanceSalary) {
        return 12 * tMonthSal + performanceSalary;
    }

    /**
     * 给学生打分
     * 
     * @param stu 学生
     */
    public void mark(Student stu) {
        Random ra = new Random();
        double grade = ra.nextInt(99) + ra.nextDouble();
        BigDecimal bg = new BigDecimal(grade).setScale(2, RoundingMode.UP);
        stu.setGrade(bg.doubleValue());
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettAge() {
        return tAge;
    }

    public void settAge(String tAge) {
        this.tAge = tAge;
    }

    public String gettDegree() {
        return tDegree;
    }

    public void settDegree(String tDegree) {
        this.tDegree = tDegree;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    public double gettMonthSal() {
        return tMonthSal;
    }

    public void settMonthSal(double tMonthSal) {
        this.tMonthSal = tMonthSal;
    }

}
