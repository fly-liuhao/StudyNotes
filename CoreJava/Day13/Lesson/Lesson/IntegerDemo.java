/**
* @项目名称: Javacore
* @文件名称: IntegerDemo.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

/**
 * 复合类型的使用
 * 
 * @author: liuhao
 * @version 1.0
 */
public class IntegerDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer x = new Integer(20);
        Integer y = new Integer("20");
        int z = 20;// 基本类型

        // 自动拆箱机制
        System.out.println(z == x);// true
        System.out.println(x == y);// false
        System.out.println(z == y);// true
        System.out.println(x.equals(y));// true

        // 自动拆装箱机制
        Integer m = 100;// 自动装箱机制
        int n = x;// 自动拆箱

        // System.out.println(new Integer(""));//编译成功，执行报错，必须数字构成
        // System.out.println(new Integer("abc"));//编译成功，执行报错，必须数字构成

        // 字符串与数字互转
        String str = "2019";
        System.out.println(Integer.parseInt(str)); // 字符串与整形互转
        String str2 = "3.14";
        System.out.println(Double.parseDouble(str2));// 字符串与浮点形互转

        int num = 15;
        String str3 = num + "";// 整形转字符串
        System.out.println(str3);

        // Boolean比较
        Boolean b1 = new Boolean("true");
        Boolean b2 = new Boolean("TRUE");
        System.out.println(b1 == b2);// Boolean不区分true和false的大小写
        System.out.println(b1.equals(b2));

        Boolean b3 = new Boolean("false");
        Boolean b4 = new Boolean("yes");
        System.out.println(b3 == b4);// Boolean只识别true和false其它都认为是false
        System.out.println(b3.equals(b4));

    }

}
