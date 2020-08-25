package cn.stylefeng.guns.business.dailyreport.controller;

import cn.afterturn.easypoi.entity.vo.MapExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.dailyreport.entity.BusinessDailyReport;
import cn.stylefeng.guns.business.dailyreport.model.params.BusinessDailyReportParam;
import cn.stylefeng.guns.business.dailyreport.model.result.BusinessDailyReportResult;
import cn.stylefeng.guns.business.dailyreport.service.BusinessDailyReportService;
import cn.stylefeng.guns.business.outapplication.model.params.BusinessOutApplicationParam;
import cn.stylefeng.guns.business.summary.controller.InformBean;
import cn.stylefeng.guns.business.summary.controller.SummaryBean;
import cn.stylefeng.guns.sys.modular.system.service.DeptService;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 控制器
 *
 * @author 韩硕
 * @Date 2020-08-01 17:21:21
 */
@Controller
@RequestMapping("/businessDailyReport")
public class BusinessDailyReportController extends BaseController {

    private String PREFIX = "/businessDailyReport";

    @Autowired
    private DeptService deptService;

    @Autowired
    private BusinessDailyReportService businessDailyReportService;

    @Autowired
    private UserService userService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/businessDailyReport.html";
    }

    /**
     * 报告页面
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/bao")
    public String bao() {
        return PREFIX + "/businessDailyReport_bao.html";
    }

    /**
     * 新增页面
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/businessDailyReport_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/businessDailyReport_edit.html";
    }

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-08-07
     */
    @RequestMapping("/adminadd")
    public String adminadd() {
        return PREFIX + "/businessDailyReport_adminadd.html";
    }

    /**
     * 新增接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(BusinessDailyReportParam businessDailyReportParam) {
        businessDailyReportParam.setClasses(LoginContextHolder.getContext().getUser().getDeptId());
        businessDailyReportParam.setTime(1);
        Date now = new Date();
        businessDailyReportParam.setFirstdate(now);
        businessDailyReportParam.setLastdate(now);
        businessDailyReportParam.setXh(LoginContextHolder.getContext().getUser().getId());
        businessDailyReportParam.setUser(LoginContextHolder.getContext().getUser().getName());
        this.businessDailyReportService.add(businessDailyReportParam);
        return ResponseData.success();
    }

    /**
     * 新增接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/addItem2")
    @ResponseBody
    public ResponseData addItem2(BusinessDailyReportParam businessDailyReportParam) {
        businessDailyReportParam.setUser((String)userService.getUserInfo(businessDailyReportParam.getXh()).get("name"));
        businessDailyReportParam.setClasses((Long)userService.getUserInfo(businessDailyReportParam.getXh()).get("deptId"));
        businessDailyReportParam.setTime(1);
        Date now = new Date();
        businessDailyReportParam.setFirstdate(now);
        businessDailyReportParam.setLastdate(now);
        this.businessDailyReportService.add(businessDailyReportParam);
        return ResponseData.success();
    }

    /**
     * 审阅接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/yjb")
    @ResponseBody
    public ResponseData yjb(HttpServletRequest request) {
        String[] xh = request.getParameter("xh").split(",");
        Date now = new Date();
        for(String i:xh){
            if(i.equals(""))
                continue;
            this.businessDailyReportService.add(new BusinessDailyReportParam(null,(String)userService.getUserInfo(Long.parseLong(i)).get("name"),now,1,now,0,null,(Long)userService.getUserInfo(Long.parseLong(i)).get("deptId"),Long.parseLong(i)));
        }
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(BusinessDailyReportParam businessDailyReportParam) {
        if (businessDailyReportParam.getChanges() == 0)
            businessDailyReportParam.setOther("");
        else
            businessDailyReportParam.setLastdate(new Date());
        businessDailyReportParam.setTime(businessDailyReportParam.getTime()+1);
        this.businessDailyReportService.update(businessDailyReportParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(BusinessDailyReportParam businessDailyReportParam) {
        this.businessDailyReportService.delete(businessDailyReportParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(BusinessDailyReportParam businessDailyReportParam) {
        BusinessDailyReport detail = this.businessDailyReportService.getById(businessDailyReportParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 自动获取今日报告信息接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/getbao")
    @ResponseBody
    public ResponseData getbao(BusinessDailyReportParam businessDailyReportParam) {
        List<BusinessDailyReportResult> detail = this.businessDailyReportService.findListBySpec(new BusinessDailyReportParam(LoginContextHolder.getContext().getUser().getId()));
        for (BusinessDailyReportResult i : detail) {
            if (isToday(i.getLastdate()))
                return ResponseData.success(i);
        }
        return ResponseData.success(new BusinessDailyReportResult());
    }

    private static boolean isToday(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(BusinessDailyReportParam businessDailyReportParam) {
        LayuiPageInfo layuiPageInfo = this.businessDailyReportService.findPageBySpec(businessDailyReportParam);
        Map<Long, String> name = new HashMap<>();
        for(Map<String, Object> i:this.deptService.allList(null, null).getRecords()){
            name.put((Long)i.get("deptId"),(String)i.get("simpleName"));
        }
        for(Object i:layuiPageInfo.getData()){
            BusinessDailyReportResult r = (BusinessDailyReportResult)i;
            r.setClasses(name.get(r.getClasses()));
        }
        return layuiPageInfo;
    }


}


