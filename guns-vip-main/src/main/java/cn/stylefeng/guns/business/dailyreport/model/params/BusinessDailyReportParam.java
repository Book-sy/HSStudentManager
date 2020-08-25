package cn.stylefeng.guns.business.dailyreport.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;

import java.text.SimpleDateFormat;
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
public class BusinessDailyReportParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String user;

    private Date firstdate;

    private Integer time;

    private Date lastdate;

    private Integer changes;

    private String other;

    private Long classes;

    private Long xh;

    private String seacher = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public BusinessDailyReportParam(){}

    public BusinessDailyReportParam(Long xh) {
        this.xh = xh;
    }

    public BusinessDailyReportParam(Integer id, String user, Date firstdate, Integer time, Date lastdate, Integer changes, String other, Long classes,Long xh) {
        this.id = id;
        this.user = user;
        this.firstdate = firstdate;
        this.time = time;
        this.lastdate = lastdate;
        this.changes = changes;
        this.other = other;
        this.classes = classes;
        this.xh = xh;
    }

    public String getSeacher() {
        return seacher;
    }

    public void setSeacher(String seacher) {
        this.seacher = seacher;
    }

    @Override
    public String checkParam() {
        return null;
    }

}
