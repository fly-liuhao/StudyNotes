/**
* @项目名称: Javacore
* @文件名称: StringBufferContent.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

/**
 * 比较可变字符串内容
 * 
 * @author: liuhao
 * @version 1.0
 */
public class StringBufferContent {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // String类对Object类的equals方法进行了重写
        String str1 = new String("china");
        String str2 = new String("china");
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);

        // StringBuilder类使用的还是Object类的equals()方法
        StringBuilder str3 = new StringBuilder("china");
        StringBuilder str4 = new StringBuilder("china");
        System.out.println(str3.equals(str4));
        System.out.println(str3 == str4);

        // StringBuffer类使用的还是Object类的equals()方法
        StringBuffer str5 = new StringBuffer("china");
        StringBuffer str6 = new StringBuffer("china");
        System.out.println(str5.equals(str6));
        System.out.println(str5 == str6);

    }

}
