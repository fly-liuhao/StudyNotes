/**
* @项目名称: Javacore
* @文件名称: MountaineeringTest.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class MountaineeringTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Mountaineering person = new Mountaineering(8848, 530);
        int climbDay = person.compClimbDay();
        System.out.println(
                "山高：" + person.getPeakHight() + ", 每日登山高度：" + person.getDayClimbHight() + "登顶所需天数：" + climbDay);
    }

}
