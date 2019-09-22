/**
* @项目名称: Javacore
* @文件名称: CalcTest.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

import java.util.Scanner;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class CalcTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calc calc = new Calc();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        double num1 = scanner.nextDouble();
        System.out.println("请输入第er个数：");
        double num2 = scanner.nextDouble();

        System.out.println("加法结果："+calc.add(num1, num2));
        System.out.println("减法结果："+calc.sub(num1, num2));
        System.out.println("乘法结果："+calc.mul(num1, num2));
        System.out.println("除法结果："+calc.div(num1, num2));
        System.out.println("求余结果："+calc.mod(num1, num2));

    }

}
