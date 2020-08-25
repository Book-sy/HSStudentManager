package cn.stylefeng.guns.business.outapplication.model.params;

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
 * @since 2020-08-01
 */
@Data
public class BusinessOutApplicationParam implements Serializable, BaseValidatingParam {

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

    public BusinessOutApplicationParam(Integer id, String user, Date oneTime, Date twoTime, Date threeTime, Date fourTime, Integer nowstep, Integer applicationType, String file,String beizhu,String cls) {
        this.id = id;
        this.user = user;
        this.oneTime = oneTime;
        this.twoTime = twoTime;
        this.threeTime = threeTime;
        this.fourTime = fourTime;
        this.nowstep = nowstep;
        this.applicationType = applicationType;
        this.file = file;
        this.beizhu = beizhu;
        this.cls = cls;
    }

    @Override
    public String checkParam() {
        return null;
    }

}
