/**
* @项目名称: Javacore
* @文件名称: Test1.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05;

/**
 * 面试题
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Test1 {
    public int harf(int x) {
        int y = x / 2;
        System.out.println("harf---x = " + x);
        System.out.println("harf---y = " + y);
        return y;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int x = 100;
        System.out.println("slaary = " + x);
        int y = test1.harf(x);
        System.out.println("slaary = " + x);
    }
}
