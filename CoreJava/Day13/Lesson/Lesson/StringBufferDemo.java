/**
* @项目名称: Javacore
* @文件名称: StringBufferDemo.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

/**
 * StringBuffer的使用
 * 
 * @author: liuhao
 * @version 1.0
 */
public class StringBufferDemo {
    public static void main(String[] args) {

        // StringBuffer str = "china";//error:不能直接复制赋值
        StringBuffer str1 = new StringBuffer("china");
        str1.append(" shanxi taiyuan tit ").append("software engineering ");
        System.out.println(str1);
        
        StringBuilder str2 = new StringBuilder("china");
        str1.append(" shanxi taiyuan tit ").append("software engineering ");
        System.out.println(str2);
    }
}
