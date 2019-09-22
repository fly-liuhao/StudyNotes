/**
* @项目名称: Javacore
* @文件名称: MapDemo.java
* @Date: 2019年7月15日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava17;

import java.util.HashMap;
import java.util.Map;

/**
 * Map的使用
 * 
 * @author: liuhao
 * @version 1.0
 */
public class MapDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map Map = new HashMap();
        Map.put("学号", "2016");// 键-值对
        Map.put("姓名", "张三");
        Map.put("性别", "男");
        Map.put("性别", "女");
        System.out.println(Map.size());

        /** Map取值：按名取值 */
        System.out.println(Map.get("性别"));
        System.out.println(Map.get("学号"));

    }

}
