/**
* @项目名称: Javacore
* @文件名称: Graduate.java
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
public class Graduate {
    
    private String name;
    // 数学成绩
    private int mathScore;
    //英语成绩
    private int engScore;
    //政治成绩
    private int polScore;
    
    public Graduate() {
        super();
    }

    public Graduate(String name, int mathScore, int engScore, int polScore) {
        super();
        this.name = name;
        this.mathScore = mathScore;
        this.engScore = engScore;
        this.polScore = polScore;
    }

    /**
     * 判断是否考研成功
     * @return 判断结果
     */
    public String judgeResult() {
        if(mathScore>50 && engScore>40 && polScore>45) {
            return "Succeed!";
        }else {
            return "Fail!";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getPolScore() {
        return polScore;
    }

    public void setPolScore(int polScore) {
        this.polScore = polScore;
    }

    
}
