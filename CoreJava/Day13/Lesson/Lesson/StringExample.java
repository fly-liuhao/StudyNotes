/**
* @项目名称: Javacore
* @文件名称: StringExample.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

/**
 * String创建方式
 * 
 * @author: liuhao
 * @version 1.0
 */
public class StringExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "china";
        String str2 = new String("china");// 创建了几个对象？---2个第一个是:"china",第二个是str2指向的对象（也就是new出来的对象）
        String str3 = "china";

        System.out.println(str1 == str2);// false
        System.out.println(str1.equals(str2));// true

        System.out.println(str1 == str3);// true 字符串的池
        System.out.println(str1.equals(str3));// true

    }

}
