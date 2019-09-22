/**
* @项目名称: Javacore
* @文件名称: ProducerConsumer.java
* @Date: 2019年7月11日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava16.thread.sharedata;

/**
 * 生产着消费者问题
 * 
 * @author: liuhao
 * @version 1.0
 */
public class ProducerConsumer {

    /**
     * 测试生产者消费者同步且共享资源
     * 
     * @param args
     */
    public static void main(String[] args) {

        /** 创建缓冲区对象 */
        Buffer buffer = new Buffer();

        /** 生产者线程 */
        Thread producerThread = new Thread(new Producer(buffer));
        /** 消费者线程 */
        Thread consumerThread = new Thread(new Consumer(buffer));

        /** 启动消费者和生产者线程 */
        producerThread.start();
        consumerThread.start();
    }

}

/**
 * 缓冲区类，其对象被生产者和消费者共享
 * 
 * @author: liuhao
 * @version 1.0
 */
class Buffer {
    /** -1 表示当前缓冲区没有产品 */
    private int product = -1;

    /**
     * 此方法由生产者调用，向缓冲区放产品 
     * 注：此方法存在同步关系，需要synchronized关键字进行修饰
     * 
     * @param digit 产品--数字
     */
    public synchronized void setProduct(int digit) {
        if (this.product != -1) {
            try {
                /** 缓冲区已有产品，生产者需等待 */
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.product = digit;
        System.out.println("生产者生产出产品（数字）：" + this.product);

        /** 通知所有处于等待区的消费者可以从缓冲区取走产品 */
        notifyAll();
    }

    /**
     * 此方法由消费者调用，从缓冲区里取产品
     * 注：此方法存在同步关系，需要synchronized关键字进行修饰
     * 
     * @return 产品---数字
     */
    public synchronized int getProduct() {
        if (this.product == -1) {
            try {
                /** 缓冲区里没有产品,消费者需等待 */
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int digit = this.product;
        System.out.println("消费者取走产品（数字）：" + this.product);
        System.out.println("");
        /** 取走产品，-1表示当前缓冲区无产品 */
        this.product = -1;

        /** 通知等待区中的一个生产者可以继续工作了 */
        notifyAll();

        return digit;
    }
}

/**
 * 生产者线程类
 * 
 * @author: liuhao
 * @version 1.0
 */
class Producer implements Runnable {
    /** 声明共享的缓冲区变量 */
    private Buffer buffer;

    /** 构造方法，初始化共享的缓冲区 */
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品...");
        System.out.println();

        /** 生产1到10的整数 */
        for (int product = 1; product <= 10; product++) {
            try {
                /** 暂停1000ms */
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /** 将产品（数字）放入缓冲区 */
            buffer.setProduct(product);
        }
    }
}

/**
 * 消费者线程类
 * 
 * @author: liuhao
 * @version 1.0
 */
class Consumer implements Runnable {
    /** 声明共享的缓冲区变量 */
    private Buffer buffer;

    /** 构造方法，初始化缓冲区 */
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("消费者开始取产品...");
        System.out.println();

        /** 消费生产出的10个整数 */
        for (int i = 1; i <= 10; i++) {
            try {
                /** 暂停1000ms */
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /** 从缓冲区取走产品（数字） */
            buffer.getProduct();
        }
    }
}
