package cn.stylefeng.guns.business.temperature.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author 韩硕
 * @since 2020-09-01
 */
@Data
public class TemperatureParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 用户id
     */
    private Long user;

    private Date day;

    private List<Long> userId;

    /**
     * 第一次温度
     */
    private Double first;

    /**
     * 第一次时间
     */
    private Date firstTime;

    /**
     * 第一次经度
     */
    private Double firstJ;

    /**
     * 第一次纬度
     */
    private Double firstW;

    /**
     * 第二次温度
     */
    private Double second;

    /**
     * 第二次时间
     */
    private Date secondTime;

    /**
     * 第二次经度
     */
    private Double secondJ;

    /**
     * 第二次纬度
     */
    private Double secondW;

    /**
     * 第三次温度
     */
    private Double third;

    /**
     * 第三次时间
     */
    private Date thirdTime;

    /**
     * 第三次经度
     */
    private Double thirdJ;

    /**
     * 第三次纬度
     */
    private Double thirdW;

    @Override
    public String checkParam() {
        return null;
    }

}
