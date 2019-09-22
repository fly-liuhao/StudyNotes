/**
* @项目名称: Javacore
* @文件名称: Test8.java
* @Date: 2019年6月7日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava12;

/**
 * 1.将字符串中的ab换成123
 * 2.获取身份证号的某一位
 * @author: liuhao
 * @version 1.0
 */
public class Test8 {
    public static void main(String[] args) {

        String codeString = "ab";
        System.out.println(codeString.replaceAll("ab", "123"));

        String id = "412485199707062547";
        // 数组的属性length 字符串的方法length()
        for (int i = 0; i < id.length(); i++) {
            System.out.print(id.charAt(i) + ",");
        }
    }
}
