package cn.stylefeng.guns.business.temperature.controller;

import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.pojo.node.LayuiTreeNode;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.temperature.entity.Temperature;
import cn.stylefeng.guns.business.temperature.model.params.TemperatureParam;
import cn.stylefeng.guns.business.temperature.service.TemperatureService;
import cn.stylefeng.guns.sys.modular.system.factory.LayuiTreeFactory;
import cn.stylefeng.guns.sys.modular.system.service.DeptService;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.guns.sys.modular.system.warpper.UserWrapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.treebuild.DefaultTreeBuildFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 *
 * @author 韩硕
 * @Date 2020-09-01 22:16:49
 */
@Controller
@RequestMapping("/temperature")
public class TemperatureController extends BaseController {

    private String PREFIX = "/temperature";

    @Autowired
    private TemperatureService temperatureService;
    @Autowired
    private UserService userService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/temperature.html";
    }

    /**
     * 新增页面
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/temperature_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/temperature_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(TemperatureParam temperatureParam) {
        this.temperatureService.add(temperatureParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(TemperatureParam temperatureParam) {
        this.temperatureService.update(temperatureParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(TemperatureParam temperatureParam) {
        this.temperatureService.delete(temperatureParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(TemperatureParam temperatureParam) {
        Temperature detail = this.temperatureService.getById(temperatureParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-09-01
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(TemperatureParam temperatureParam) {

        Page<Map<String, Object>> users = userService.selectAllUsers(null, null, "", "", LoginContextHolder.getContext().getUser().getDeptId());

        List<Long> userId = new ArrayList<>();
        for (Map<String, Object> record : users.getRecords()) {
            userId.add((Long)record.get("userId"));
        }
        temperatureParam.setUserId(userId);
        return this.temperatureService.findPageBySpec(temperatureParam);
    }

}


