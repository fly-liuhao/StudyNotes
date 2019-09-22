/**
* @项目名称: Javacore
* @文件名称: AccountException.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava14;

/**
 * 模拟取款余额不足时的异常 自定义异常类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class AccountException extends Exception {

    /**
     * 无参构造
     */
    public AccountException() {
        super();
    }

    /**
     * 带参构造
     * 
     * @param message
     */
    public AccountException(String message) {
        super(message);
    }

    /**
     * 重写同String
     */
    public String toString() {
        return "AccountException提示：余额不足";
    }

}

//用户账户
class BankAccound {
    public void withDraw() throws AccountException {
        int balance = 200;// 余额
        int withDraw = 500;// 待取金额
        if (withDraw > balance) {
            throw new AccountException("余额不足");
        }
    }

    public static void main(String[] args) {
        BankAccound bankAccound = new BankAccound();
        try {
            bankAccound.withDraw();
        } catch (AccountException e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
}