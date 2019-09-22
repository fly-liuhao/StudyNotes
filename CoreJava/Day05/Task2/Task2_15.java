/**
* @项目名称: Javacore
* @文件名称: Task2_15.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

/**
 * 张浩 Java 考试成绩未达到自己的目标。为了表明自己勤奋学习的决心，他决定写一百遍“好好学习，天天向上！”
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_15 {
    
    /**姓名*/
    private String name;

    /**
     * 带参构造
     * 
     * @param name
     */
    public Task2_15(String name) {
        super();
        this.name = name;
    }

    /**
     * 下决心好好学习（100遍“好好学习，天天向上！”）
     */
    public void makeDetermination() {
        for (int i = 0; i < 100; i++) {
            System.out.println("好好学习，天天向上！");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_15 test = new Task2_15("张浩");
        test.makeDetermination();

    }

}
