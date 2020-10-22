package cn.stylefeng.guns.business.score.model.result;

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
 * @since 2020-09-27
 */
@Data
public class ScoreEvaluateResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 分数id
     */
    private Long scoreId;

    /**
     * 评价
     */
    private String evaluate;

    /**
     * 评价人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updataTime;

    /**
     * 评价时间
     */
    private Date createTime;

    /** 评论给的用户ID */
    private String toId;

}
