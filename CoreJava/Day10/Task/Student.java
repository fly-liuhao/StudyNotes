/**
* @项目名称: Javacore
* @文件名称: Student.java
* @Date: 2019年6月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava10;

/**
 * static方法的虚方法的调用有什么特点？
 * 子类不能重写父类的静态方法，所以对静态方法无效，静态方法调用看变量（什么类型）
 * @author: liuhao
 * @version 1.0
 */
public class Student {

    static int age = 21;
    static int geard = getGread();

    public static int getGread() {
        System.out.println("给静态变量赋值...");
        return 9;
    }

    public void speak() {
        System.out.println("父类speak()方法！");
    }

    public static void eat() {
        System.out.println("父类eat()静态方法！");
    }
}

class ExcellentStudent extends Student {
    @Override
    public void speak() {
        System.out.println("子类speak方法！");
    }

    // 不是重写父类的方法
    public static void eat() {
        System.out.println("子类eat()静态方法~");
    }

    public static void main(String[] args) {
        // 向上造型
        Student student = new ExcellentStudent();
        student.speak();
        student.eat();
    }
}