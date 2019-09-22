/**
* @项目名称: Javacore
* @文件名称: TestMain.java
* @Date: 2019年4月26日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava03.task;

import java.text.ParseException;

/**
* 
* @author: liuhao
* @version 1.0
*/
public class TestMain {

    /**
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        
        Teacher th1 = new Teacher();
        Teacher th2 = new Teacher("1001","张三","35");
        Teacher th3 = new Teacher("1002","李四","45","博士","教授",5000.0);
        
        System.out.println("th1老师的学历："+th1.gettDegree()+", th1老师的学历："+th1.gettTitle()+", th1老师的学历："+th1.gettMonthSal());
        System.err.println("th3老师的年龄："+th3.compAge(1984));
        System.err.println("th3老师的工龄："+th3.compWorkAge(2003));
        System.err.println("th3老师的年薪："+th3.compYearSal(3765.23));
        

        Student stu1 = new Student("stu1","1998-1-5");
        Student stu2 = new Student("stu2","1998-12-25");
        Student stu3 = new Student("stu3","1999-3-11");
        Teacher teacher = new Teacher();
        EduAdministrationSystem eaSystem = new EduAdministrationSystem();

        teacher.mark(stu1);
        teacher.mark(stu2);
        teacher.mark(stu3);
        
        int stu1Age = eaSystem.compAge(stu1);
        int stu2Age = eaSystem.compAge(stu2);
        int stu3Age = eaSystem.compAge(stu3);
        double gradeAvg = eaSystem.compGradeAVG(stu1,stu2,stu3);
        
        System.out.println("stu1年龄："+stu1Age+", stu2年龄："+stu2Age+", stu3年龄："+stu3Age );
        System.out.println("stu1成绩："+stu1.getGrade()+", stu2成绩："+stu2.getGrade()+", stu3成绩："+stu3.getGrade()+", ");
        System.out.println("stu1、stu2、stu3的平均成绩："+gradeAvg);
        
    }

}
