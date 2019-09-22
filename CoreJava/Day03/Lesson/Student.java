/**
* @项目名称: Javacore
* @文件名称: Student.java
* @Date: 2019年4月18日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava03;

/**
 * 任务一：设计学生类
 * 
 * @author: liuhao-fly
 * @version 1.0
 */
public class Student {
    /** 学生姓名 */
    private String studentName;
    /** 学生学号 */
    private String studentID;
    /** 性别 */
    private String sex;
    /** 学生籍贯 */
    private String nation;
    /** 学生年龄 */
    private int age;

    /**
     * 默认构造方法
     */
    public Student() {
        System.out.println("这里是默认构造函数");
    }

    /**
     * 带参构造方法
     * @param studentName
     * @param age
     */
    public Student(String studentName, int age) {
        this.studentName = studentName;
        this.age = age;
    }

    /**
     * 带参构造方法
     * @param studentName
     * @param studentID
     * @param sex
     * @param nation
     * @param age
     */
    public Student(String studentName, String studentID, String sex, String nation, int age) {
        System.out.println("这里是默认构造函数");
        this.studentName = studentName;
        this.studentID = studentID;
        this.sex = sex;
        this.nation = nation;
        this.age = age;
    }
    
    /**
     * 说话方法
     * @param words 学生说的话
     */
    public void speak(String words) {
        System.out.println("" + words);
    }

    /**
     * 吃饭方法
     * @param food 吃的食物
     * @return “好吃”
     */
    public String eat(String food) {
        System.out.println("我在吃：" + food);
        return "好吃！";
    }

    /**
     * 完成两个int类型数加法运算
     * @param num1 加数一
     * @param num2 加数二
     * @return 两数之和
     */
    public int add(int num1, int num2) {
        System.out.println();
        return num1 + num2;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

}
