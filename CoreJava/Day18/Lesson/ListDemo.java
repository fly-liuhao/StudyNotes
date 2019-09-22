/**
* @项目名称: Javacore
* @文件名称: ListDemo01.java
* @Date: 2019年7月15日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List的使用
 * 
 * @author: liuhao
 * @version 1.0
 */
public class ListDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(12);
        list.add("hello");

        List<String> strList = new ArrayList<String>();
//        strList.add(12);
        strList.add("hello");
        strList.add("world");

        /** 集合和遍历的第一种方式 */
        for (int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }
        /** 集合和遍历的第二种方式 */
        for (String str : strList) {
            System.out.println(str);
        }
        /** 集合和遍历的第三种方式:：使用迭代器 */
        Iterator iter = null;
        for (iter = strList.iterator(); iter.hasNext();) {
            String str = (String) iter.next();
            System.out.println(str);
        }

    }

}