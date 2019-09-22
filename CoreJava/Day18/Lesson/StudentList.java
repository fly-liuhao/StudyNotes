/**
* @项目名称: Javacore
* @文件名称: StudentList.java
* @Date: 2019年7月15日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 去掉List中重复对象
 * 
 * @author: liuhao
 * @version 1.0
 */
public class StudentList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Student stu1 = new Student("张三", 21, "2016");
        Student stu2 = new Student("李四", 21, "2015");
        Student stu3 = new Student("张三", 21, "2016");

        List<Student> stuList = new ArrayList<Student>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        System.out.println(stuList.size());

        /** 迭代器遍历 */
        Iterator iter = null;
        for (iter = stuList.iterator(); iter.hasNext();) {
            Student stu = (Student) iter.next();
            System.out.println(stu);
        }

        /** 第二步：用Set集合包裹List，使用构造方法 */
        Set<Student> setList = new HashSet<Student>(stuList);
        System.out.println(setList.size());
    }
}

class Student {
    private String name;
    private int age;
    private String sid;

    public Student() {
        super();
    }

    public Student(String name, int age, String sid) {
        super();
        this.name = name;
        this.age = age;
        this.sid = sid;
    }

    /* 第一步：重写hashCode和equals方法 */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((sid == null) ? 0 : sid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (sid == null) {
            if (other.sid != null)
                return false;
        } else if (!sid.equals(other.sid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sid=" + sid + "]";
    }

}