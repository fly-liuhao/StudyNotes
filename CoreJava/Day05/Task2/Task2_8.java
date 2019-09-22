/**
* @项目名称: Javacore
* @文件名称: Task2_8.java
* @Date: 2019年5月1日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

/**
 * 学校举行运动会，百米赛跑跑入10秒内的学生有资格进决赛，根据性别分别进入男子组和女子组
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task2_8 {

    /** 学生姓名 */
    private String name;
    /** 学生性别 */
    private String sex = "男";
    /** 学生百米赛成绩 */
    private double score;

    public Task2_8() {
        super();
    }

    public Task2_8(String name, String sex, double score) {
        super();
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public void IntoMatch() {
        if (this.score <= 10) {
            if (this.sex == "男") {
                System.out.println("恭喜你" + this.name + ",进入总决赛男子组！");
            } else if (this.sex == "女") {
                System.out.println("恭喜你" + this.name + ",进入总决赛女子组！");
            }
        } else {
            System.out.println("很遗憾" + this.name + ",你没能进入总决赛！");
        }

    }

    /**
     * 主函数
     * 
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        Task2_8 test1 = new Task2_8("张三", "男", 9.88);
        Task2_8 test2 = new Task2_8("李四", "女", 9.65);
        Task2_8 test3 = new Task2_8("王五", "男", 10.12);

        // 判断比赛结果
        test1.IntoMatch();
        test2.IntoMatch();
        test3.IntoMatch();

    }

}
