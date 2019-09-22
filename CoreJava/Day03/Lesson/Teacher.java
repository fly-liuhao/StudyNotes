/**
* @项目名称: Javacore
* @文件名称: Teacher.java
* @Date: 2019年4月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.test;

/**
* 封装老师的属性
* @author: liuhao
* @version 1.0
*/
public class Teacher {
    private String name;
    private int age;
    static final int AGE_MAX = 150;
    static final int AGE_MIN = 150;
    
    /**
     * Teacher类默认构造方法
     */
    public Teacher() {
        super();
    }

    /**
     * Teacher的带参构造
     * @param name 老师的姓名
     * @param age 老师的年龄
     */
    public Teacher(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    /**
     * 获取姓名
     * @return 老师姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     * @param name 老师姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获得年龄
     * @return 老师年龄
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置年龄
     * @param age 老师年龄
     */
    public void setAge(int age) {
        if(age >= AGE_MIN && age <= AGE_MAX) {
            this.age = age;
        }else {
            System.out.println("年龄不合法！");
        }
    }
    
}
