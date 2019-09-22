/**
* @项目名称: Javacore
* @文件名称: Task1_8.java
* @Date: 2019年4月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 数字加密器，加密规则是：加密结果 = （整数*10+5）/2 + 3.14159，加 密结果仍为一整数
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_8 {

    /**
     * 给整数加密
     * 
     * @param number 待加密的整数
     * @return 加密后的整数
     */
    public int encryption(int number) {
        return (int) ((number * 10 + 5) / 2 + 3.14159);// = 5*number + 5.64159
    }

    public int decode(int number) {
        return (number - 5) / 5;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task1_8 test = new Task1_8();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个带加密的整数：");
        int srcNum = sc.nextInt();
        int dstNum = test.encryption(srcNum);
        System.out.println("加密后的数字为：" + dstNum);
        System.out.println("解密后的数字为：" + test.decode(dstNum));
    }

}
