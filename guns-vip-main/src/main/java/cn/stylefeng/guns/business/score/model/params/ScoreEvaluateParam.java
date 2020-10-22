package cn.stylefeng.guns.business.score.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
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
public class ScoreEvaluateParam implements Serializable, BaseValidatingParam {

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
    private Long createUser;

    /**
     * 更新时间
     */
    private Date updataTime;

    /**
     * 评价时间
     */
    private Date createTime;

    @Override
    public String checkParam() {
        return null;
    }

}
