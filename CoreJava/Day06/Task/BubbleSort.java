/**
* @项目名称: Javacore
* @文件名称: BubbleSort.java
* @Date: 2019年5月10日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06.array;

import javax.naming.spi.DirStateFactory.Result;

/**
* 冒泡排序
* @author: liuhao
* @version 1.0
*/
public class BubbleSort {
    
    /**
     * 降序排序
     * @param beforArray 待排序数组
     */
    public void sortDown(int [] beforArray) {
        for (int i = 0; i < beforArray.length-1; i++) {
            for (int j = 0; j < beforArray.length-i-1; j++) {
                if(beforArray[j] < beforArray[j+1]) {
                    int temp = beforArray[j];
                    beforArray[j] = beforArray[j+1];
                    beforArray[j+1] = temp;
                }
            }
        }    
    }
    
    /**
     * 升序排序
     * @param beforArray  待排序数组
     */
    public void sortUp(int [] beforArray) {
        for (int i = 0; i < beforArray.length-1; i++) {
            for (int j = 0; j < beforArray.length-i-1; j++) {
                if(beforArray[j] > beforArray[j+1]) {
                    int temp = beforArray[j];
                    beforArray[j] = beforArray[j+1];
                    beforArray[j+1] = temp;
                }
            }
        }    
    }
    
   
    /**
     * 主函数测试
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        // 定义一个乱序数组
        int[] array = new int[] {70,60,50,40,30,20,10};
        System.out.println("原数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+", ");
        }
        
        //创建冒泡排序对象
        BubbleSort bSort  = new BubbleSort();
        
        // 对数组进行排序
        System.out.println("\n");
        System.out.println("先进行升序排列");
        bSort.sortUp(array);     
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+", ");
        }
        
        System.out.println("\n");
        System.out.println("再进行降序排列");
        bSort.sortDown(array);
        for (int value : array) {
            System.out.print(value+", ");
        }
    }
    
}
