/**
* @项目名称: Javacore
* @文件名称: Calc.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

import java.math.BigDecimal;

/**
 * 实现精确计算
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Calc {

    /**
     * 使用BigDecimal实现小数精确计算（但是依然无法计算出）
     * 
     * @param num1 计算数字一
     * @param num2 计算数字二
     * @return 不精确计算结果
     */
    public double sub(double num1, double num2) {
        BigDecimal number1 = new BigDecimal(num1);// API参数为double类型
        BigDecimal number2 = new BigDecimal(num2);
        return number1.subtract(number2).doubleValue();
    }

    /**
     * 使用BigDecimal实现时间精确计算（结果正确）
     * 
     * @param num1 计算数字一
     * @param num2 计算数字二
     * @return 精确计算结果
     */
    public double sub2(double num1, double num2) {
        BigDecimal number1 = new BigDecimal(num1 + "");// API参数为String类型
        BigDecimal number2 = new BigDecimal(num2 + "");
        return number1.subtract(number2).doubleValue();
    }

    /**
     * 主方法测试
     * 
     * @param args
     */
    public static void main(String[] args) {
        Calc calc = new Calc();
        double num1 = 1;
        double num2 = 0.9;
        // 参数为doule类型
        System.out.println(calc.sub(num1, num2));
        // 参数为String类型
        System.out.println(calc.sub2(num1, num2));

    }

}
