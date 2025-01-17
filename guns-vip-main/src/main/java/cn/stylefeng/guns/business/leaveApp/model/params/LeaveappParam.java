package cn.stylefeng.guns.business.leaveApp.model.params;

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
 * @since 2020-09-02
 */
@Data
public class LeaveappParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;

    //临时变量
    private String sx;

    private Boolean nature;

    private Long id;

    private Long userId;

    private Long fudaoyuan;

    private Long xueyuanlingdao;

    //人工字段 意见传输
    private String yj;
    private Long deptId;
    private Long dept;

    private String xiaoqu;

    private String sushehao;

    private String xueyuan;

    private String reason;

    private Date startTime;

    private Date endTime;

    private String shenfenzheng;

    private String chuxingguiji;

    private String jinjilianxiren;

    private String guanxi;

    private Long phone;

    private String address;

    private String xueyuanyijian;

    private Date time;

    private Date appTime;

    private String otheryijian;

    private Date othertime;

    private Long other;

    private String fudaoyuanyijian;

    private Date fudaoyuanTime;

    private Long fileId;

    private Long sign;

    private Long file;
    //身份验证人工字段
    private String sf;

    @Override
    public String checkParam() {
        return null;
    }

}
