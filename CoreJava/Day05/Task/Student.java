/**
* @项目名称: Javacore
* @文件名称: Student.java
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
public class Student {
    
    private String stuName;
    private String stuId;
    private int age;
    private int grade;
    
    
    public Student() {
        super();
    }

    public Student(String stuName, String stuId, int age, int grade) {
        super();
        this.stuName = stuName;
        this.stuId = stuId;
        this.age = age;
        this.grade = grade;
    }
    
    /**
     * 打印学生信息，要求：一行显示
     */
    public void printStuInfo() {
        System.out.println("姓名："+stuName+"， 学号："+stuId+"， 年龄："+age+"， 成绩："+grade);
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
}
