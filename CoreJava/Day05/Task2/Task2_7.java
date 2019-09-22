/**
* @项目名称: Javacore
* @文件名称: Task2_7.java
* @Date: 2019年5月1日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

/**
 * 我想买车，买什么车决定于我在银行有多少存款 如果我的存款超过500万，我就买凯迪拉克 否则，如果我的存款超过100万，我就买帕萨特 否则，
 * 如果我的存款超过50万，我就买依兰特 否则， 如果我的存款超过10万，我就买奥托 否则， 如果我的存款10万以下 ，我买捷安特
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_7 {

    /** 存款金额 */
    private double deposit = 2000000;

    /**
     * 无参构造函数
     */
    public Task2_7() {
        super();
    }

    /**
     * 带参构造函数
     * 
     * @param deposit
     */
    public Task2_7(double deposit) {
        super();
        this.deposit = deposit;
    }

    /**
     * 根据存款金额买相应的车
     */
    public void buyCard() {
        if (this.deposit > 5000000) {
            System.out.println("我买凯迪拉克！");
        } else if (this.deposit > 1000000) {
            System.out.println("我买帕萨特！");
        } else if (this.deposit > 500000) {
            System.out.println("我买依兰特！");
        } else if (this.deposit > 100000) {
            System.out.println("我买奥托！");
        } else {
            System.out.println("我买捷安特！");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_7 test = new Task2_7();
        test.buyCard();
    }

}
