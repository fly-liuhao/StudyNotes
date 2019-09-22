/**
* @项目名称: Javacore
* @文件名称: Food.java
* @Date: 2019年6月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava10;

/**
 * 测试对象的构造次序（父类的静态->子类的静态->父类的非静态->父类的构造->子类的非静态->子类的构造）
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Food {
    int weight = getWeight();
    static String color = getColor();
    static {
        System.out.println("3333333");
    }
    {
        System.out.println("44444");
    }

    public Food() {
        System.out.println("555555");
    }

    public int getWeight() {
        System.out.println("111111");
        return 10;
    }

    public static String getColor() {
        System.out.println("22222");
        return "red";
    }

    public static void main(String[] args) {
        Food food = new Food();
    }

}

class Apple extends Food {
    int addr = getAddr();
    static String color2 = getColor2();
    static {
        System.out.println("Apple3333333");
    }
    {
        System.out.println("Apple44444");
    }

    public Apple() {
        System.out.println("Apple555555");
    }

    public int getAddr() {
        System.out.println("Apple111111");
        return 10;
    }

    public static String getColor2() {
        System.out.println("Apple22222");
        return "red";
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
    }
}
