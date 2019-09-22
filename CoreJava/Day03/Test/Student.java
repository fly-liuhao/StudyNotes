/**
* @项目名称: Javacore
* @文件名称: Student.java
* @Date: 2019年4月26日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava03.task;

/**
* 
* @author: liuhao
* @version 1.0
*/
public class Student {
    private String name;
    private String Birthday;
    private double grade;


    public Student() {
        super();
    }

    public Student(String name, String birthday) {
        super();
        this.name = name;
        Birthday = birthday;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }
    
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
