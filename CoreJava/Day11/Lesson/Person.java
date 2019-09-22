public class Person {
    /**属性：private、static修饰，类型为当前类类型，且立即初始化 */
    private static Person person = new Person();
    
    /**
     * 构造方法必须私有
     */
    private Person() {
        System.out.println(" 这里是饿汉式的私有构造方法！");
    }
    
    /**
     * public、通过get当前类的对象
     * @return
     */
    public static Person getPerson() {
        return person;
    }
}

//测试类
class TestPerson {
    public static void main(String[] args) {
        //static方法，直接通过类调用进行对象初始化
        Person person1 = Person.getPerson();
        Person person2 = Person.getPerson();
        
        //属于同一个对象
        System.out.println(person1 == person2);
    }
