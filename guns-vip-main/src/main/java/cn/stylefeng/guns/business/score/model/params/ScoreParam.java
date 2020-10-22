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
public class ScoreParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 学期类型
     */
    private Long type;

    /**
     * 用户
     */
    private Long user;

    /**
     * 分数
     */
    private Double score;

    /**
     * 排名
     */
    private Integer ranking;

    @Override
    public String checkParam() {
        return null;
    }

}
