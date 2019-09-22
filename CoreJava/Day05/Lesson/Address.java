/**
* @项目名称: Javacore
* @文件名称: Address.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Address {
    // 家庭地址
    private String homeAddr = "太原";
    // 学校地址
    private String schoolAddr = "成都";
    // 工作地址
    private String workAddr = "大连";

    public Address() {
        super();
    }

    public Address(String homeAddr, String schoolAddr, String workAddr) {
        super();
        this.homeAddr = homeAddr;
        this.schoolAddr = schoolAddr;
        this.workAddr = workAddr;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getSchoolAddr() {
        return schoolAddr;
    }

    public void setSchoolAddr(String schoolAddr) {
        this.schoolAddr = schoolAddr;
    }

    public String getWorkAddr() {
        return workAddr;
    }

    public void setWorkAddr(String workAddr) {
        this.workAddr = workAddr;
    }

    public static void main(String[] args) {

        int salary = 5000;
        Address address = null;
        address = new Address();
    }
}
