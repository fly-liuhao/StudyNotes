/**
* @项目名称: Javacore
* @文件名称: TeacherTest.java
* @Date: 2019年4月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.test;

/**
* 创建Teacher对象，输出其属性值
* @author: liuhao
* @version 1.0
*/
public class TeacherTest {

    /**
     * @param args 主方法
     */
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("张宇",-38);
        System.out.println(teacher1.getAge());
        System.out.println(teacher1.getName());
        
        Teacher teacher2 = new Teacher();
        teacher2.setName("张宇");
        teacher2.setAge(-38);
        System.out.println(teacher2.getName());
        System.out.println(teacher2.getAge());
        teacher1.getClass();
    }

}
