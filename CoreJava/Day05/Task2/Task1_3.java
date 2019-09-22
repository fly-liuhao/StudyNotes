/**
* @项目名称: Javacore
* @文件名称: Task1_3.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

/**
 * 求解表达式(3 + 40 % 6) > ( 9 / 2 * 3)的结果
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        boolean result = (3 + 40 % 6) > (9 / 2 * 3);
        System.out.println("(3 + 40 % 6) = " + (3 + 40 % 6));
        System.out.println("( 9 / 2 * 3) = " + (9 / 2 * 3));
        System.out.println("(3 + 40 % 6) > ( 9 / 2 * 3)运算结果为：" + result);
    }

}
