/**
* @项目名称: Javacore
* @文件名称: Student.java
* @Date: 2019年4月18日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava;

/**
* 任务一：设计学生类
* @author: liuhao-fly
* @version 1.0
*/
public class Student
{
    /**学生姓名*/
    private String studentName ;
    /**学生学号*/
    private String studentID ;
    /**性别*/
    private String sex ;
    /**学生籍贯*/
    private String nation ;
    /**学生年龄*/
    private int age ;


    /**
     * 说话方法 
     * @param words 学生说的话
     */
    public void speak (String words) 
    {
        System.out.println("" + words);
    }

    /**
     * 吃饭方法
     * @param food 吃的食物
     * @return “好吃”
     */
    public String eat (String food) 
    {
        System.out.println("我在吃：" + food);
        return "好吃！";
    }

    /**
     * 完成两个int类型数加法运算
     * @param num1 加数一
     * @param num2 加数二
     * @return 两数之和
     */
    public int add (int num1, int num2) 
    {
        System.out.println();
        return num1 + num2;
    }


}
