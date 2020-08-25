package cn.stylefeng.guns.business.summary.controller;

/**
 * InformBean类
 * Git to： http://hs.mccspace.com:3000/Qing_ning/guns-vip/
 *
 * @TIME 2020/8/8 12:03
 * @AUTHOR 韩硕~
 */

public class InformBean {

    private boolean change;
    private boolean report;

    private int id;

    public InformBean(boolean change, boolean report) {
        this.change = change;
        this.report = report;
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAll(boolean change, boolean report,int id){
        this.change = change;
        this.report = report;
        this.id = id;
    }
}
