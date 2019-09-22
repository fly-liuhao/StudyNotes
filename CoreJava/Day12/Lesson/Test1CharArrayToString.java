/**
* @项目名称: Javacore
* @文件名称: Test1CharArrayToString.java
* @Date: 2019年6月7日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava12;

import java.io.UnsupportedEncodingException;

/**
 * 任务1：将一个字符数组转成字符串输出 
 * 任务2：将一个字符串转成字符数组输出
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Test1CharArrayToString {
    public String charString(char[] characterArray) {
        String str = new String(characterArray);
        return str;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Test1CharArrayToString test1CharArrayToString = new Test1CharArrayToString();
        char[] grade = { 'A', 'B', 'C', 'D' };
        System.out.println(test1CharArrayToString.charString(grade));

        String name = "太原工业学院计算机系";
        String newName = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(name + ", " + newName);

        char a[] = name.toCharArray();
        for (char n : a) {
            System.out.print(n+", ");
        }
    }

}
