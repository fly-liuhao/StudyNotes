/**
* @项目名称: Javacore
* @文件名称: Person.java
* @Date: 2019年4月24日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava04;

/**
 * 基本数据类型示例
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Person {
    private byte workAge;
    private short age;
    private int salary;
    private long account;
    private char sex;
    private float height;
    private double food;
    private boolean isAlive;

    public static void main(String[] args) {
        Person person = new Person();
        person.workAge = 45;
        person.sex = '男';
        person.sex = 97;
        System.out.println(person.sex); // a
        person.sex = '\u0128'; // \\u表示Unicode编码
        System.out.println(person.sex); // a
        System.out.println("\"\"");
        System.out.println("\\\\");

        person.account = 10000000;
        person.account = 2147483648l; // long类型当超过int类型时，一定要写上L/l,推荐写L

        person.height = 1.80f; // float型数据f/F不能省略
        person.height = .8f;
        person.height = 8.f;

        person.food = 900.678;

        person.isAlive = true;
//      person.isAlive = 1;

        // 类型转换
        int int_num = 90;
        double dou_num = 100;
        int_num = (int) dou_num;// 强制转换
        dou_num = int_num;// 自动转换
    }
}
