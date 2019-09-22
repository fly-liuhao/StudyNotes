/**
* @项目名称: Javacore
* @文件名称: ArrayCopyDemo.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

/**
 * 数组复制
 * 
 * @author: liuhao
 * @version 1.0
 */
public class ArrayCopyDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] first = { 100, 200, 300, 400, 500 };
        int[] second = { 1, 2, 3, 4, 5 };
        System.arraycopy(first, 1, second, 1, 3);
        for (int x : second) {
            System.out.print(x + ", ");
        }
    }
}
