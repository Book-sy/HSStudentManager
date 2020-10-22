package cn.stylefeng.guns.business.information.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-30
 */
@TableName("_information")
public class Information implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 发送用户
     */
      @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 内容
     */
    @TableField("text")
    private String text;

    /**
     * 接收人
     */
    @TableField("to_user")
    private Long toUser;

    /**
     * 已读
     */
    @TableField("reades")
    private Boolean reades;

    /**
     * 记录时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 已读时间
     */
    @TableField("read_time")
    private Date readTime;

    public Boolean getReades() {
        return reades;
    }

    public void setReades(Boolean reades) {
        this.reades = reades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    @Override
    public String toString() {
        return "Information{" +
        "id=" + id +
        ", createUser=" + createUser +
        ", text=" + text +
        ", toUser=" + toUser +
        ", createTime=" + createTime +
        ", readTime=" + readTime +
        "}";
    }
}
