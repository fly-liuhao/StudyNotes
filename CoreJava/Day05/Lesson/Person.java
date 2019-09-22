/**
* @项目名称: Javacore
* @文件名称: Person.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/**
 * 引用数据类型（复合数据类型）
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Person {

    private String name;
    private int age;
    private Address addr;

    public void change(Address addr) {
        addr.setHomeAddr("上海");
        addr.setWorkAddr("北京");
    }

    public static void main(String[] args) {
        int salary = 100;
        int grade = 4;

        Address addr1 = new Address("太原", "西安", "深圳");
        Address addr2 = addr1;
        System.out.println(salary + grade);

        Person person = new Person();
        person.change(addr1);
        System.out.println(addr1.getHomeAddr());
        System.out.println(addr1.getSchoolAddr());
        System.out.println(salary);
    }

}
