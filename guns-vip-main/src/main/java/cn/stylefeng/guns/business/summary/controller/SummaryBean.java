package cn.stylefeng.guns.business.summary.controller;

import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.sys.modular.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * SummaryBean类
 * Git to： http://hs.mccspace.com:3000/Qing_ning/guns-vip/
 *
 * @TIME 2020/8/7 22:01
 * @AUTHOR 韩硕~
 */

public class SummaryBean {

    private String classes;

    private String situation;

    private String change;

    private String json;

    private String mc;

    public SummaryBean(String classes, String situation, String change, String json, String mc) {
        this.classes = classes;
        this.situation = situation;
        this.change = change;
        this.json = json;
        this.mc = mc;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }
}
