/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月16日
 */
package cn.edu.tit.corejava08;

/**
 * 接口的实现类
 * 
 * @author liuhao
 * @version: 1.0
 */
public class PersonImpl implements IPerson {
    /**
     * 实现了接口的类必须实现接口中所有抽象方法，除非该类是抽象类
     */
    @Override
    public void speak() {
        System.out.println("说人话");
    }

    @Override
    public void eat() {
        System.out.println("吃");
    }

}
