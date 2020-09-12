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

    @TableField("banzhang")
    private Long banzhang;

    @TableField("fudaoyuan")
    private Long fudaoyuan;

    @TableField("banzhuren")
    private Long banzhuren;

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

    @TableField("banzhangyijian")
    private String banzhangyijian;

    @TableField("banzhang_time")
    private Date banzhangTime;

    @TableField("banzhurenyijian")
    private String banzhurenyijian;

    @TableField("banzhuren_time")
    private Date banzhurenTime;

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

    public Long getBanzhang() {
        return banzhang;
    }

    public void setBanzhang(Long banzhang) {
        this.banzhang = banzhang;
    }

    public Long getFudaoyuan() {
        return fudaoyuan;
    }

    public void setFudaoyuan(Long fudaoyuan) {
        this.fudaoyuan = fudaoyuan;
    }

    public Long getBanzhuren() {
        return banzhuren;
    }

    public void setBanzhuren(Long banzhuren) {
        this.banzhuren = banzhuren;
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

    public String getBanzhangyijian() {
        return banzhangyijian;
    }

    public void setBanzhangyijian(String banzhangyijian) {
        this.banzhangyijian = banzhangyijian;
    }

    public Date getBanzhangTime() {
        return banzhangTime;
    }

    public void setBanzhangTime(Date banzhangTime) {
        this.banzhangTime = banzhangTime;
    }

    public String getBanzhurenyijian() {
        return banzhurenyijian;
    }

    public void setBanzhurenyijian(String banzhurenyijian) {
        this.banzhurenyijian = banzhurenyijian;
    }

    public Date getBanzhurenTime() {
        return banzhurenTime;
    }

    public void setBanzhurenTime(Date banzhurenTime) {
        this.banzhurenTime = banzhurenTime;
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
        ", banzhangyijian=" + banzhangyijian +
        ", banzhangTime=" + banzhangTime +
        ", banzhurenyijian=" + banzhurenyijian +
        ", banzhurenTime=" + banzhurenTime +
        ", fudaoyuanyijian=" + fudaoyuanyijian +
        ", fudaoyuanTime=" + fudaoyuanTime +
        "}";
    }
}
