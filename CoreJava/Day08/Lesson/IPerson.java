/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月16日
 */
package cn.edu.tit.corejava08;

/**
 * 接口
 * 
 * @author liuhao
 * @version: 1.0
 */
//接口修饰符默认public abstract修饰
interface IPerson {
    // 在接口中变量默认public static final修饰，且必须赋值
    public static final int a = 1;

    // 接口中的方法默认public abstract修饰，不能添加方法体
    void speak();

    public abstract void eat();

    /*
     * 在JDK8中新增default和static方法，可以包含方法体
     */
    default void help() {

    }

    static void sleep() {

    }
    // 在JDK9中新增private私有方法，也可以包含方法体
//	private void drink() {
//		
//	}
}
