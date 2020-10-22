package cn.stylefeng.guns.business.leaveApp.model.result;

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
 * @since 2020-09-02
 */
@Data
public class LeaveappResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Boolean nature;

    private Long id;

    private Long userId;

    private Long fudaoyuan;

    private Long xueyuanlingdao;

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

    private String phone;

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

    private Long file;

    private Long sign;

    /** 人工联合查询字段  */
    private String sex;
    private String dn;
    private String xh;
    private String name;
    private String myPhone;
    private String otherName;

}
