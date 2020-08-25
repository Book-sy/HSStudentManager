package cn.stylefeng.guns.business.dailyreport.entity;

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
@TableName("business_daily_report")
public class BusinessDailyReport implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user")
    private String user;

    @TableField("firstdate")
    private Date firstdate;

    @TableField("time")
    private Integer time;

    @TableField("classes")
    private Long classes;

    @TableField("xh")
    private Long xh;

    @TableField("lastdate")
    private Date lastdate;

    @TableField("changes")
    private Integer changes;

    @TableField("other")
    private String other;


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

    public Date getFirstdate() {
        return firstdate;
    }

    public void setFirstdate(Date firstdate) {
        this.firstdate = firstdate;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    public Integer getChanges() {
        return changes;
    }

    public void setChanges(Integer changes) {
        this.changes = changes;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Long getClasses() {
        return classes;
    }

    public void setClasses(Long classes) {
        this.classes = classes;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    @Override
    public String toString() {
        return "BusinessDailyReport{" +
        "id=" + id +
        ", user=" + user +
        ", firstdate=" + firstdate +
        ", time=" + time +
        ", lastdate=" + lastdate +
        ", changes=" + changes +
        ", other=" + other +
        "}";
    }
}
