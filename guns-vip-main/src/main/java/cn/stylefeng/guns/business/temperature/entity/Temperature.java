package cn.stylefeng.guns.business.temperature.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-01
 */
@TableName("_temperature")
public class Temperature implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("user")
    private Long user;

    @TableField("day")
    private Date day;

    /**
     * 第一次温度
     */
    @TableField("first")
    private Double first;

    /**
     * 第一次时间
     */
    @TableField("first_time")
    private Date firstTime;

    /**
     * 第一次经度
     */
    @TableField("first_j")
    private Double firstJ;

    /**
     * 第一次纬度
     */
    @TableField("first_w")
    private Double firstW;

    /**
     * 第二次温度
     */
    @TableField("second")
    private Double second;

    /**
     * 第二次时间
     */
    @TableField("second_time")
    private Date secondTime;

    /**
     * 第二次经度
     */
    @TableField("second_j")
    private Double secondJ;

    /**
     * 第二次纬度
     */
    @TableField("second_w")
    private Double secondW;

    /**
     * 第三次温度
     */
    @TableField("third")
    private Double third;

    /**
     * 第三次时间
     */
    @TableField("third_time")
    private Date thirdTime;

    /**
     * 第三次经度
     */
    @TableField("third_j")
    private Double thirdJ;

    /**
     * 第三次纬度
     */
    @TableField("third_w")
    private Double thirdW;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Double getFirst() {
        return first;
    }

    public void setFirst(Double first) {
        this.first = first;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Double getFirstJ() {
        return firstJ;
    }

    public void setFirstJ(Double firstJ) {
        this.firstJ = firstJ;
    }

    public Double getFirstW() {
        return firstW;
    }

    public void setFirstW(Double firstW) {
        this.firstW = firstW;
    }

    public Double getSecond() {
        return second;
    }

    public void setSecond(Double second) {
        this.second = second;
    }

    public Date getSecondTime() {
        return secondTime;
    }

    public void setSecondTime(Date secondTime) {
        this.secondTime = secondTime;
    }

    public Double getSecondJ() {
        return secondJ;
    }

    public void setSecondJ(Double secondJ) {
        this.secondJ = secondJ;
    }

    public Double getSecondW() {
        return secondW;
    }

    public void setSecondW(Double secondW) {
        this.secondW = secondW;
    }

    public Double getThird() {
        return third;
    }

    public void setThird(Double third) {
        this.third = third;
    }

    public Date getThirdTime() {
        return thirdTime;
    }

    public void setThirdTime(Date thirdTime) {
        this.thirdTime = thirdTime;
    }

    public Double getThirdJ() {
        return thirdJ;
    }

    public void setThirdJ(Double thirdJ) {
        this.thirdJ = thirdJ;
    }

    public Double getThirdW() {
        return thirdW;
    }

    public void setThirdW(Double thirdW) {
        this.thirdW = thirdW;
    }

    @Override
    public String toString() {
        return "Temperature{" +
        "id=" + id +
        ", user=" + user +
        ", day=" + day +
        ", first=" + first +
        ", firstTime=" + firstTime +
        ", firstJ=" + firstJ +
        ", firstW=" + firstW +
        ", second=" + second +
        ", secondTime=" + secondTime +
        ", secondJ=" + secondJ +
        ", secondW=" + secondW +
        ", third=" + third +
        ", thirdTime=" + thirdTime +
        ", thirdJ=" + thirdJ +
        ", thirdW=" + thirdW +
        "}";
    }
}
