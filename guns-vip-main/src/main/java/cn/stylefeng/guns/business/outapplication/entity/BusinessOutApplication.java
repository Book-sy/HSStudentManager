package cn.stylefeng.guns.business.outapplication.entity;

import cn.stylefeng.guns.business.outapplication.model.params.BusinessOutApplicationParam;
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
 * @since 2020-08-01
 */
@TableName("business_out_application")
public class BusinessOutApplication implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user")
    private String user;

    @TableField("one_time")
    private Date oneTime;

    @TableField("two_time")
    private Date twoTime;

    @TableField("three_time")
    private Date threeTime;

    @TableField("four_time")
    private Date fourTime;

    @TableField("nowstep")
    private Integer nowstep;

    @TableField("application_type")
    private Integer applicationType;

    @TableField("file")
    private String file;

    @TableField("beizhu")
    private String beizhu;

    @TableField("cls")
    private String cls;

    public BusinessOutApplicationParam toParam(){
        return new BusinessOutApplicationParam(id,user,oneTime,twoTime,threeTime,fourTime,nowstep,applicationType,file,beizhu,cls);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getOneTime() {
        return oneTime;
    }

    public void setOneTime(Date oneTime) {
        this.oneTime = oneTime;
    }

    public Date getTwoTime() {
        return twoTime;
    }

    public void setTwoTime(Date twoTime) {
        this.twoTime = twoTime;
    }

    public Date getThreeTime() {
        return threeTime;
    }

    public void setThreeTime(Date threeTime) {
        this.threeTime = threeTime;
    }

    public Date getFourTime() {
        return fourTime;
    }

    public void setFourTime(Date fourTime) {
        this.fourTime = fourTime;
    }

    public Integer getNowstep() {
        return nowstep;
    }

    public void setNowstep(Integer nowstep) {
        this.nowstep = nowstep;
    }

    public Integer getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(Integer applicationType) {
        this.applicationType = applicationType;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    @Override
    public String toString() {
        return "BusinessOutApplication{" +
        "id=" + id +
        ", user=" + user +
        ", oneTime=" + oneTime +
        ", twoTime=" + twoTime +
        ", threeTime=" + threeTime +
        ", fourTime=" + fourTime +
        ", nowstep=" + nowstep +
        ", applicationType=" + applicationType +
        ", file=" + file +
        ", beizhu=" + beizhu +
        "}";
    }
}
