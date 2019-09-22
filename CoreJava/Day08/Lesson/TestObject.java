/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月16日
 */
package cn.edu.tit.corejava08;

/**
 * Object类方法的使用
 * 
 * @author liuhao
 * @version: 1.0
 */
public class TestObject {
    String name;
    int age;

    public TestObject() {

    }

    /**
     * @param name
     * @param age
     */
    public TestObject(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        TestObject other = (TestObject) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TestObject [name=" + name + ", age=" + age + "]";
    }

    @Override
    protected void finalize() {
        System.out.println(111);
    }

    public static void main(String[] args) {
        TestObject t1 = new TestObject("aa", 11);
        TestObject t2 = new TestObject("aa", 11);
//		TestObject t2 = t1;

        // equals比较内容
        System.out.println(t1.equals(t2));
        // ==在引用类型中比较对象的地址
        System.out.println(t1 == t2);
        System.out.println(t1 + " " + t2);
        // 打印对象时，默认调用toString()
        System.out.println(t1.toString());
    }
}
