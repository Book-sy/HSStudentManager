package cn.stylefeng.guns.business.index.controller;

import cn.stylefeng.guns.base.auth.annotion.Permission;
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
import cn.stylefeng.guns.sys.modular.system.warpper.DeptWrapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 *
 * @author 韩硕
 * @Date 2020-08-01 17:21:21
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

    private String PREFIX = "/index";

    @Autowired
    private DeptService deptService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/index.html";
    }



    /**
     * 获取所有部门列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 4:57 PM
     */
    @RequestMapping(value = "/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(value = "condition", required = false) String condition,
                       @RequestParam(value = "deptId", required = false) Long deptId) {
        Page<Map<String, Object>> list = this.deptService.list(condition, deptId);
        Page<Map<String, Object>> wrap = new DeptWrapper(list).wrap();
        return LayuiPageFactory.createPageInfo(wrap);
    }


}


