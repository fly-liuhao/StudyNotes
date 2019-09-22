/**
* @项目名称: Javacore
* @文件名称: ReverseString.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

/**
 * 任务：反转字符串
 * 
 * @author: liuhao
 * @version 1.0
 */
public class ReverseString {
    /**
     * 把"cba"转成"cba"
     * 
     * @param oldStr
     * @return 反转后的字符串
     */
    public String reverseStr(String oldStr) {
        StringBuilder str1 = new StringBuilder(oldStr);
        str1.reverse();
        return str1.toString();
    }

    /**
     * 把"cba"转成"cba"(不使用可变字符串）
     * 
     * @param oldStr
     * @return 反转后的字符串
     */
    public String reverseStr2(String oldStr) {
        String result = "";
//        for (int i = oldStr.length()-1; i >=0; i--) {
//            result += oldStr.charAt(i);
//        }
        for (int i = oldStr.length()-1; i >=0; i--) {
            result += oldStr.substring(i,i+1);
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        String string = "abcde";
        System.out.println(reverseString.reverseStr(string));
        System.out.println(reverseString.reverseStr2(string));

    }

}
