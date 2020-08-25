package cn.stylefeng.guns.business.outapplication.model.result;

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
 * @since 2020-08-01
 */
@Data
public class BusinessOutApplicationResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String user;

    private Date oneTime;

    private Date twoTime;

    private Date threeTime;

    private Date fourTime;

    private Integer nowstep;

    private Integer applicationType;

    private String file;

    private String beizhu;

    private String cls;

}
