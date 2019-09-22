/**
* @项目名称: Javacore
* @文件名称: MyThread.java
* @Date: 2019年7月11日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava16.thread.create;

/**
 * 线程创建方式一：通过继承Thread
 * 
 * @author: liuhao
 * @version 1.0
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    /**
     * 线程主体
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        /* 创建线程1 */
        MyThread myThread = new MyThread("张三");
        /* 创建线程2 */
        MyThread myThread2 = new MyThread("李四");

        /* 执行线程 */
        myThread.start();
        myThread2.start();

    }

}
