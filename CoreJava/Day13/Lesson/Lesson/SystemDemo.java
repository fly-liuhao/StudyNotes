/**
* @项目名称: Javacore
* @文件名称: SystemDemo.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

/**
 * 输出程序执行的时间
 * 
 * @author: liuhao
 * @version 1.0
 */
public class SystemDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        long start2 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            System.out.println("lalala~" + i);
        }
        long end1 = System.currentTimeMillis();
        long end2 = System.nanoTime();
        System.out.println("执行时间(微秒)" + (end1 - start1));
        System.out.println("执行时间(纳秒)" + (end2 - start2));

    }

}
