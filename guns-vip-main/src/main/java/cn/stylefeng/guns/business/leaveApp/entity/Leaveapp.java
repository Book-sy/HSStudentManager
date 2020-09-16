package cn.stylefeng.guns.business.leaveApp.entity;

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
 * @since 2020-09-02
 */
@TableName("_leaveapp")
public class Leaveapp implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("xueyuanlingdao")
    private Long xueyuanlingdao;

    @TableField("fudaoyuan")
    private Long fudaoyuan;

    @TableId("id")
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("xiaoqu")
    private String xiaoqu;

    @TableField("sushehao")
    private String sushehao;

    @TableField("xueyuan")
    private String xueyuan;

    @TableField("reason")
    private String reason;

    @TableField("start_time")
    private Date startTime;

    @TableField("end_time")
    private Date endTime;

    @TableField("shenfenzheng")
    private String shenfenzheng;

    @TableField("chuxingguiji")
    private String chuxingguiji;

    @TableField("jinjilianxiren")
    private String jinjilianxiren;

    @TableField("guanxi")
    private String guanxi;

    @TableField("phone")
    private Long phone;

    @TableField("address")
    private String address;

    @TableField("app_time")
    private Date appTime;

    @TableField("xueyuanyijian")
    private String xueyuanyijian;

    @TableField("time")
    private Date time;

    @TableField("otheryijian")
    private String otheryijian;

    @TableField("othertime")
    private Date othertime;

    @TableField("other")
    private Long other;

    @TableField("fudaoyuanyijian")
    private String fudaoyuanyijian;

    @TableField("fudaoyuan_time")
    private Date fudaoyuanTime;

    @TableField("fileId")
    private Long fileId;

    @TableField("sign")
    private Long sign;

    @TableField("file")
    private Long file;

    @TableField("nature")
    private Boolean nature;

    public Boolean getNature() {
        return nature;
    }

    public void setNature(Boolean nature) {
        this.nature = nature;
    }

    public Long getFile() {
        return file;
    }

    public void setFile(Long file) {
        this.file = file;
    }

    public Long getSign() {
        return sign;
    }

    public void setSign(Long sign) {
        this.sign = sign;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getXueyuanlingdao() {
        return xueyuanlingdao;
    }

    public void setXueyuanlingdao(Long xueyuanlingdao) {
        this.xueyuanlingdao = xueyuanlingdao;
    }

    public Long getFudaoyuan() {
        return fudaoyuan;
    }

    public void setFudaoyuan(Long fudaoyuan) {
        this.fudaoyuan = fudaoyuan;
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getSushehao() {
        return sushehao;
    }

    public void setSushehao(String sushehao) {
        this.sushehao = sushehao;
    }

    public String getXueyuan() {
        return xueyuan;
    }

    public void setXueyuan(String xueyuan) {
        this.xueyuan = xueyuan;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getShenfenzheng() {
        return shenfenzheng;
    }

    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng;
    }

    public String getChuxingguiji() {
        return chuxingguiji;
    }

    public void setChuxingguiji(String chuxingguiji) {
        this.chuxingguiji = chuxingguiji;
    }

    public String getJinjilianxiren() {
        return jinjilianxiren;
    }

    public void setJinjilianxiren(String jinjilianxiren) {
        this.jinjilianxiren = jinjilianxiren;
    }

    public String getGuanxi() {
        return guanxi;
    }

    public void setGuanxi(String guanxi) {
        this.guanxi = guanxi;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getXueyuanyijian() {
        return xueyuanyijian;
    }

    public void setXueyuanyijian(String xueyuanyijian) {
        this.xueyuanyijian = xueyuanyijian;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOtheryijian() {
        return otheryijian;
    }

    public void setOtheryijian(String otheryijian) {
        this.otheryijian = otheryijian;
    }

    public Date getOthertime() {
        return othertime;
    }

    public void setOthertime(Date othertime) {
        this.othertime = othertime;
    }

    public Long getOther() {
        return other;
    }

    public void setOther(Long other) {
        this.other = other;
    }

    public String getFudaoyuanyijian() {
        return fudaoyuanyijian;
    }

    public void setFudaoyuanyijian(String fudaoyuanyijian) {
        this.fudaoyuanyijian = fudaoyuanyijian;
    }

    public Date getFudaoyuanTime() {
        return fudaoyuanTime;
    }

    public void setFudaoyuanTime(Date fudaoyuanTime) {
        this.fudaoyuanTime = fudaoyuanTime;
    }

    @Override
    public String toString() {
        return "Leaveapp{" +
        "id=" + id +
        ", userId=" + userId +
        ", xiaoqu=" + xiaoqu +
        ", sushehao=" + sushehao +
        ", xueyuan=" + xueyuan +
        ", reason=" + reason +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", shenfenzheng=" + shenfenzheng +
        ", chuxingguiji=" + chuxingguiji +
        ", jinjilianxiren=" + jinjilianxiren +
        ", guanxi=" + guanxi +
        ", phone=" + phone +
        ", address=" + address +
        ", xueyuanyijian=" + xueyuanyijian +
        ", time=" + time +
        ", fudaoyuanyijian=" + fudaoyuanyijian +
        ", fudaoyuanTime=" + fudaoyuanTime +
        "}";
    }
}
