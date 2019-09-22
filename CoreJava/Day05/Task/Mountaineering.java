/**
* @项目名称: Javacore
* @文件名称: Mountaineering.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

/**
* 
* @author: liuhao
* @version 1.0
*/
public class Mountaineering {
    // 山峰高度
    private double peakHight = 8848;
    // 每日登山高度
    private int dayClimbHight =530;
    
    
    public Mountaineering() {
        super();
    }

    public Mountaineering(double peakHight, int dayClimbHight) {
        super();
        this.peakHight = peakHight;
        this.dayClimbHight = dayClimbHight;
    }

    /**
     * 计算登峰天数
     * @return 登峰所用天数
     */
    public int compClimbDay() {
        return (int) (peakHight/dayClimbHight+0.5);
    }

    public double getPeakHight() {
        return peakHight;
    }

    public void setPeakHight(double peakHight) {
        this.peakHight = peakHight;
    }

    public int getDayClimbHight() {
        return dayClimbHight;
    }

    public void setDayClimbHight(int dayClimbHight) {
        this.dayClimbHight = dayClimbHight;
    }

}
