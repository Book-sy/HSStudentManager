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
public class ScoreTypeParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 学期名称
     */
    private String name;

    @Override
    public String checkParam() {
        return null;
    }

}
