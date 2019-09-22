/**
* @项目名称: Javacore
* @文件名称: SetDemo.java
* @Date: 2019年7月15日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava17;

import java.util.HashSet;
import java.util.Set;

/**
 * Set的使用
 * 
 * @author: liuhao
 * @version 1.0
 */
public class SetDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("world");
        set.add("!");
        set.add("Hello");
        System.out.println(set.size());
        for (String str : set) {
            System.out.println(str);
        }
    }

}
