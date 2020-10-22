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
public class ScoreResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 学期类型
     */
    private String type;

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

    /** 人工插入查询字段 */
    private String name;
    private String classes;
    private int eveNum;

}
