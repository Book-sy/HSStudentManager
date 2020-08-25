package cn.stylefeng.guns.business.summary.controller;

/**
 * noReportBean类
 * Git to： http://hs.mccspace.com:3000/Qing_ning/guns-vip/
 *
 * @TIME 2020/8/8 16:09
 * @AUTHOR 韩硕~
 */

public class noReportBean {

    private String name;
    private Long xh;

    public noReportBean(String name, Long xh) {
        this.name = name;
        this.xh = xh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }
}
