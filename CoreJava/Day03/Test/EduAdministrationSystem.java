/**
* @项目名称: Javacore
* @文件名称: EduAdministrationSystem.java
* @Date: 2019年4月26日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava03.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* 
* @author: liuhao
* @version 1.0
*/
public class EduAdministrationSystem {
    
    public int compAge(Student stu) throws ParseException {
        // 利用SimpleDateFormat类将日期字符串转化为Date类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date birdate = sdf.parse(stu.getBirthday());
       // 获得当前系统日期
        Date nowdate = new Date();
        int age = nowdate.getYear() - birdate.getYear();
        return age;
    }
    public double compGradeAVG(Student stu1,Student stu2,Student stu3) {
        double avgDouble = (stu1.getGrade()+stu2.getGrade()+stu3.getGrade()) / 3.0;
        int avg =(int)(avgDouble * 100 + 1);
        return ((double)avg/100);
    }

}
