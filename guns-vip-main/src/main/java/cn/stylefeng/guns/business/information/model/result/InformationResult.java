package cn.stylefeng.guns.business.information.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-30
 */
@Data
public class InformationResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 发送用户
     */
    private Long createUser;

    /**
     * 内容
     */
    private String text;

    /**
     * 接收人
     */
    private Long toUser;

    /**
     * 已读
     */
    private Boolean reades;

    /**
     * 记录时间
     */
    private Date createTime;

    /**
     * 已读时间
     */
    private Date readTime;

    /** 临时变量 */
    private String name;

}
