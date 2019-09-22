/**
* @项目名称: Javacore
* @文件名称: LinkedListDemo.java
* @Date: 2019年7月15日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava17;

import java.util.LinkedList;

/**
 * LinkedList（链表实现的集合）的使用
 * 
 * @author: liuhao
 * @version 1.0
 */
public class LinkedListDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList str = new LinkedList();
        str.add("123");
        str.add("a");
        str.add("b");
        str.add("c");
        str.add(123);
        System.out.println(str);
        str.remove();
        System.out.println(str);
        str.remove(2);
        System.out.println(str);

    }

}
