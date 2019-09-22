/**
* @项目名称: Javacore
* @文件名称: Divide.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava14;

import java.nio.channels.AcceptPendingException;
import java.util.Scanner;

/**
 * 除法计算
 * @author: liuhao
 * @version 1.0
 */
public class Divide {

    /**
     * 除法计算（不添加异常捕获）
     * 
     * @param num1
     * @param num2
     * @return
     */
    public double div(int num1, int num2) {
        double result = num1 / num2;
        return result;
    }

    /**
     * 除法计算（使用JVM添加异常捕获)
     * 
     * @param num1 被除数
     * @param num2 除数
     * @return 相除结果
     */
    public double div2(int num1, int num2) {
        double result = 0;
        try {
            // 一旦出现异常，JVM直接创建ArithmeticException对象
            result = num1 / num2;
        } catch (Exception e) {
            System.out.println("数据不合法！");
            // e.printStackTrace();
        } finally {// 不管有无异常必定要执行，可选则添加，一般用于释放资源
            System.out.println("finally");
        }
        return result;
    }

    /**
     * 除法计算（手动添加异常捕获)
     * 
     * @param num1 被除数
     * @param num2 除数
     * @return 相除结果
     */
    public double div3(int num1, int num2) {
        double result = 0;
        if (num2 == 0) {
            System.out.println("数据不合法！");
            // 手动抛出异常
            throw new AcceptPendingException();
        } else {
            result = num1 / num2;
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Divide divide = new Divide();

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个整数：");
        int num1 = scanner.nextInt();
        System.out.print("请输入第一个整数：");
        int num2 = scanner.nextInt();

        System.out.println(divide.div3(num1, num2));
    }

}
