/**
* @项目名称: Javacore
* @文件名称: MathDemo.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

/**
 * Math类的使用
 * @author: liuhao
 * @version 1.0
 */
public class MathDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 向上取整
        System.out.println("****************ceil向上取整*****************");
        System.out.println(Math.ceil(-11.3));
        System.out.println(Math.ceil(-11.8));
        System.out.println(Math.ceil(11.3));
        System.out.println(Math.ceil(11.8));

        // 向下取整
        System.out.println("******************floor向下取整***************");
        System.out.println(Math.floor(-11.3));
        System.out.println(Math.floor(-11.8));
        System.out.println(Math.floor(11.3));
        System.out.println(Math.floor(11.8));

        // 产生随机数[0,1)
        System.out.println("******************产生随机数[0,1)***************");
        System.out.println(Math.random());
        System.out.println((int)(Math.random()*200-100));
        
        //round()
        // 结果分析：负数-如果绝对值大于大于0.5，原数+0.5，结果向下取整（变小）
        System.out.println(Math.round(-11.2));
        System.out.println(Math.round(-11.5));
        System.out.println(Math.round(-11.6));
        System.out.println(Math.round(11.2));
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-0.5));

    }

}
