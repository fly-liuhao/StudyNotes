/**
* @项目名称: Javacore
* @文件名称: StudentTest.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

/**
 * 输入学生姓名、学号、年龄、成绩，要求一句话输出
 * 
 * @author: liuhao
 * @version 1.0
 */
public class StudentTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 创建学生对象
        Student stu = new Student("刘浩", "162056224", 22, 95);
        // 一句话输出学生信息
        stu.printStuInfo();
        System.out.println("姓名：" + stu.getStuName() + "， 学号：" + stu.getStuId() + "， 年龄：" + stu.getAge() + "， 成绩："
                + stu.getGrade());
    }
}
