public class Student {
    /**属性：private、static修饰，类型为当前类类型，不先初始化，只先声明 */
    private static Student student;

    /**
     * 构造方法必须私有
     */
    private  Student() {
        System.out.println("这里是懒汉模式的私有构造方法！");
    }
    
     /**
     * public、通过get当前类的对象(首次使用需要实例化)
     * @return student
     */
    public static Student getStudentInstence() {
        if(student == null)
            student = new Student();
        return student;
    }  
}

//测试类
class TestStudent {
    public static void main(String[] args) {
   	//static方法，直接通过类调用进行对象初始化
        Student stu1 = Student.getStudentInstence();
        Student stu2 = Student.getStudentInstence();
        
        //属于同一个对象
        System.out.println(stu1 == stu2);
    }
}
