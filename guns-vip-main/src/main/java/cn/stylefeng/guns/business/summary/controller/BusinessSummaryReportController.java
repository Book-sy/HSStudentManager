package cn.stylefeng.guns.business.summary.controller;

import cn.hutool.json.JSONObject;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.dailyreport.entity.BusinessDailyReport;
import cn.stylefeng.guns.business.dailyreport.model.params.BusinessDailyReportParam;
import cn.stylefeng.guns.business.dailyreport.model.result.BusinessDailyReportResult;
import cn.stylefeng.guns.business.dailyreport.service.BusinessDailyReportService;
import cn.stylefeng.guns.business.outapplication.model.params.BusinessOutApplicationParam;
import cn.stylefeng.guns.business.outapplication.service.BusinessOutApplicationService;
import cn.stylefeng.guns.sys.modular.system.service.DeptService;
import cn.stylefeng.guns.sys.modular.system.service.UserPosService;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.guns.sys.modular.system.warpper.DeptWrapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 *
 * @author 韩硕
 * @Date 2020-08-07 21:23:56
 */
@Controller
@RequestMapping("/businessSummaryReport")
public class BusinessSummaryReportController extends BaseController {

    private String PREFIX = "/businessSummaryReport";

    @Autowired
    private BusinessOutApplicationService businessOutApplicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private BusinessDailyReportService businessDailyReportService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-08-07
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/businessSummaryReport.html";
    }

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-08-07
     */
    @RequestMapping("/noReport")
    public String noReport() {
        return PREFIX + "/businessSummaryReport_noReport.html";
    }

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-08-07
     */
    @RequestMapping("/changes")
    public String changes() {
        return PREFIX + "/businessSummaryReport_change.html";
    }


    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(BusinessOutApplicationParam businessOutApplicationParam) {
        Map<Long, String> name = new HashMap<>();
        Map<Long, Map<String, InformBean>> map = new HashMap<>();

        LayuiPageInfo layuiPageInfo = new LayuiPageInfo();
        layuiPageInfo.setData(new ArrayList<SummaryBean>());

        for(Map<String, Object> i:this.deptService.allList(null, null).getRecords()){
            name.put((Long)i.get("deptId"),(String)i.get("simpleName"));
            map.put((Long)i.get("deptId"),new HashMap<>());
        }

        for(Map<String, Object> i:this.userService.selectAllUsers(null, null, null, null, null).getRecords()){
            map.get(i.get("deptId")).put(((Long)i.get("userId")).toString(),new InformBean(false,false));
        }

        BusinessDailyReportParam param = new BusinessDailyReportParam();
        for(BusinessDailyReportResult i:(List<BusinessDailyReportResult>)this.businessDailyReportService.findAllPageBySpec(param).getData()){
            map.get(i.getClasses()).get(i.getXh().toString()).setAll(i.getChanges()!=0,true,i.getId());
        }

        for(Long i:map.keySet()){
            int all=0,t=0,ch=0;
            JSONObject js = new JSONObject();
            js.put("weibaogao",new ArrayList<>());
            js.put("bianhua",new ArrayList<>());
            Map<String,InformBean> l = map.get(i);
            for(String j:l.keySet()){
                if(l.get(j).isReport())
                    t++;
                else
                    js.getJSONArray("weibaogao").put(j);
                if(l.get(j).isChange()) {
                    ch++;
                    js.getJSONArray("bianhua").put(l.get(j).getId());
                }
                all++;
            }
            layuiPageInfo.getData().add(new SummaryBean(name.get(i),t+" / "+all,ch+"位",js.toString(),getDeptName()));
        }
        return layuiPageInfo;
    }

    private String getDeptName(){
        for(Map<String, Object> i:this.deptService.allList(null, null).getRecords()){
            if(LoginContextHolder.getContext().getUser().getDeptId().equals(i.get("deptId")))
                return (String)i.get("simpleName");
        }
        return null;
    }

    /**
     * 查看未报告名单处理接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/noReportItem")
    @ResponseBody
    public LayuiPageInfo wbg(HttpServletRequest request) {
        LayuiPageInfo layuiPageInfo = new LayuiPageInfo();
        layuiPageInfo.setData(new ArrayList<noReportBean>());
        for(String i:request.getParameter("wbg").split(",")) {
            if(i.equals(""))
                continue;
            layuiPageInfo.getData().add(new noReportBean((String) userService.getUserInfo(Long.parseLong(i)).get("name"), Long.parseLong(i)));
        }
        return layuiPageInfo;
    }

    /**
     * 查看变化名单处理接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/changesItem")
    @ResponseBody
    public LayuiPageInfo changesItem(HttpServletRequest request) {
        LayuiPageInfo layuiPageInfo = new LayuiPageInfo();
        layuiPageInfo.setData(new ArrayList<BusinessDailyReport>());
        for(String i:request.getParameter("changes").split(",")) {
            int id;
            try{
                id=Integer.parseInt(i);
            } catch (NumberFormatException e){
                continue;
            }
            layuiPageInfo.getData().add(this.businessDailyReportService.getById(id));
        }
        return layuiPageInfo;
    }



}


