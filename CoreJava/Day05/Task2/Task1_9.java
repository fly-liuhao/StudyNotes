/**
* @项目名称: Javacore
* @文件名称: Task1_9.java
* @Date: 2019年4月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 用户可以享受购物8折的优惠，当消费2564元时，请计算实际消费金额
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_9 {

    /**
     * 计算打折后的实付金额
     * 
     * @param payMoner 应付金额
     * @return 实付金额
     */
    public double discount(double payMoney) {
        return 0.8 * payMoney;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task1_9 test = new Task1_9();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入顾客应付金额：");
        double payMoney = sc.nextDouble();
        double trueMoner = test.discount(payMoney);
        System.out.println("顾客实际应付金额为：" + trueMoner + "元");
    }

}
