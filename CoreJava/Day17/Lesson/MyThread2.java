/**
* @项目名称: Javacore
* @文件名称: MyThread2.java
* @Date: 2019年7月11日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava16.thread.create;

/**
 * 线程创建方式二：使用接口方式创建一个线程
 * 
 * @author: liuhao
 * @version 1.0
 */
public class MyThread2 implements Runnable {

    /**
     * 线程主体
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "：i = " + i);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        /* 创建线程1---通过装饰模式 */
        Runnable oneRunnable = new MyThread2();
        Thread t1 = new Thread(oneRunnable, "张三");
        /* 创建线程2 */
        Runnable twoRunnable = new MyThread2();
        Thread t2 = new Thread(oneRunnable, "李四");

        /* 执行线程 */
        t1.start();
        t2.start();
    }

}
