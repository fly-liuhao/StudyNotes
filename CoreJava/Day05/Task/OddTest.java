/**
* @项目名称: Javacore
* @文件名称: OddTest.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

import java.util.Scanner;

/**
 * 判断用户输入整数是否为奇数，以及求解50以内的奇数之和
 * 
 * @author: liuhao
 * @version 1.0
 */
public class OddTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Odd odd = new Odd();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int tempNum = sc.nextInt();
        if (odd.isOdd(tempNum)) {
            System.err.println("是奇数！");
        } else {
            System.out.println("不是奇数！");
        }

        System.out.println("求解50以内的奇数之和：");
        int sum = 0;
        for (int i = 0; i <= 50; i++) {
            if (odd.isOdd(i)) {
                sum += i;
            }
        }
        System.out.println("50以内的计数之和为：" + sum);

    }

}
