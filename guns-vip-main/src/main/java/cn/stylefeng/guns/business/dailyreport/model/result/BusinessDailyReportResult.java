package cn.stylefeng.guns.business.dailyreport.model.result;

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
public class BusinessDailyReportResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String user;

    private Date firstdate;

    private Integer time;

    private Date lastdate;

    private Integer changes;

    private String other;

    private Object classes;

    private Long xh;

}
