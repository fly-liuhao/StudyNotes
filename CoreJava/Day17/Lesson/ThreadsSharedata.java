/**
* @项目名称: Javacore
* @文件名称: ThreadsSharedata.java
* @Date: 2019年7月11日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava16.thread.sharedata;

import java.util.concurrent.Delayed;

/**
 * 多线程共享数据，共享Account类的对象 
 * 两个线程同时取款问题
 * 
 * @author: liuhao
 * @version 1.0
 */
public class ThreadsSharedata {
    /**
     * @param args
     */
    public static void main(String[] args) {
        /** 创建账户对象 */
        Account account = new Account(1000);
        /** 创建线程1 */
        OneThread t1 = new OneThread(account, "张三");
        /** 创建线程2 */
        Thread t2 = new Thread(new TwoThread(account), "李四");

        /** 运行线程 */
        t1.start();
        t2.start();
    }

}

class Account {
    /** 账户余额 */
    private double balance;

    /**
     * 通过初始化账户余额
     * 
     * @param money 账户的初始金额
     */
    public Account(double money) {
        this.balance = money;
    }

    /**
     * 取款方法 取款过程 
     *      1. 判断余额是否足够 
     *      2. 如果余额够，从账户扣除金额，并更改余额 
     *      3. 金额不够，提醒用户 同步：
     * 
     * @param count 取款金额
     */
    public synchronized void withDraw(double count) {
        System.out.println(Thread.currentThread().getName() + "：进入取款方法...");
        if (count <= this.balance) {
            System.out.println(Thread.currentThread().getName() + "：正在取款...");
            this.balance -= count;
            System.out.println(Thread.currentThread().getName() + "：取款成功！剩余金额：" + this.balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "：余额不足，请及时充值...");
        }
    }

    /**
     * 取款方法 取款过程
     *       1. 判断余额是否足够 
     *       2. 如果余额够，从账户扣除金额，并更改余额 
     *       3. 金额不够，提醒用户 同步：对局部代码保护
     * 
     * @param count
     */
//    public void withDraw(double count) {
//        System.out.println(Thread.currentThread().getName() + "：进入取款方法...");
//        synchronized (this) {
//            if (count <= this.balance) {
//                System.out.println(Thread.currentThread().getName() + "：正在取款...");
//                this.balance -= count;
//                System.out.println(Thread.currentThread().getName() + "：取款成功！剩余金额：" + this.balance);
//            } else {
//                System.out.println(Thread.currentThread().getName() + "：余额不足，请及时充值...");
//            }
//        }
//    }

    /**
     * 获取账户余额
     * 
     * @return 账户余额
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 设置账户余额
     * 
     * @param balance 账户余额
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

/**
 * 线程一类：通过继承方式
 * 
 * @author: liuhao
 * @version 1.0
 */
class OneThread extends Thread {
    Account account;

    /**
     * 构造方法，对account赋值
     */
    public OneThread(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        account.withDraw(1000);
    }

}

/**
 * 线程二类：通过接口方式
 * 
 * @author: liuhao
 * @version 1.0
 */
class TwoThread implements Runnable {
    Account account;

    /**
     * 构造方法，对account赋值
     */
    public TwoThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withDraw(500);
    }
}
