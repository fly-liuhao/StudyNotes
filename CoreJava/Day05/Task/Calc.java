/**
* @项目名称: Javacore
* @文件名称: Calc.java
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
public class Calc {
    /**
     * double型数的加法运算
     * @param num1 输入数1
     * @param num2 输入数2
     * @return 两数相加结果
     */
    public double add(double num1, double num2) {
        return num1 + num2;
    }
    
    /**
     * double型数的减法运算
     * @param num1 输入数1
     * @param num2 输入数2
     * @return 两数相加结果
     */
    public double sub(double num1, double num2) {
        return num1 - num2;
    }
    
    /**
     * double型数的乘法运算
     * @param num1 输入数1
     * @param num2 输入数2
     * @return 两数相加结果
     */
    public double mul(double num1, double num2) {
        return num1 * num2;
    }
    
    /**
     * double型数的除法运算
     * @param num1 输入数1
     * @param num2 输入数2
     * @return 两数相除结果
     */
    public double div(double num1, double num2) {
        if(num2 == 0) {
            System.out.println("Error：除数不能为0！");
            return 0;
        }else {
        return num1 / num2;
        }
    }
    
    /**
     * double型数的求余运算
     * @param num1 输入数1
     * @param num2 输入数2
     * @return 两数求余结果
     */
    public double mod(double num1, double num2) {
        return num1 % num2;
    }

}
