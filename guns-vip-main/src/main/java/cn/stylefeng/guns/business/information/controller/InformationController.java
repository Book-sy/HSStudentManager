package cn.stylefeng.guns.business.information.controller;

import cn.stylefeng.guns.base.auth.annotion.Permission;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.information.entity.Information;
import cn.stylefeng.guns.business.information.model.params.InformationParam;
import cn.stylefeng.guns.business.information.service.InformationService;
import cn.stylefeng.guns.sys.core.constant.Const;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * 控制器
 *
 * @author 韩硕
 * @Date 2020-09-30 10:22:34
 */
@Controller
@RequestMapping("/information")
public class InformationController extends BaseController {

    private String PREFIX = "/information";

    @Autowired
    private InformationService informationService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @RequestMapping("")
    @Permission(Const.ADMIN_NAME)
    public String index() {
        return PREFIX + "/information.html";
    }

    /**
     *
     * 新增页面
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @RequestMapping("/add")
    @Permission(Const.ADMIN_NAME)
    public String add() {
        return PREFIX + "/information_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @RequestMapping("/edit")
    @Permission(Const.ADMIN_NAME)
    public String edit() {
        return PREFIX + "/information_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @RequestMapping("/addItem")
    @ResponseBody
    @Permission(Const.ADMIN_NAME)
    public ResponseData addItem(InformationParam informationParam) {
        this.informationService.add(informationParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @RequestMapping("/editItem")
    @ResponseBody
    @Permission(Const.ADMIN_NAME)
    public ResponseData editItem(InformationParam informationParam) {
        this.informationService.update(informationParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @RequestMapping("/delete")
    @ResponseBody
    @Permission(Const.ADMIN_NAME)
    public ResponseData delete(InformationParam informationParam) {
        this.informationService.delete(informationParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @RequestMapping("/detail")
    @ResponseBody
    @Permission(Const.ADMIN_NAME)
    public ResponseData detail(InformationParam informationParam) {
        Information detail = this.informationService.getById(informationParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @ResponseBody
    @RequestMapping("/list")
    @Permission(Const.ADMIN_NAME)
    public LayuiPageInfo list(InformationParam informationParam) {
        return this.informationService.findPageBySpec(informationParam);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @ResponseBody
    @RequestMapping("/uslist")
    public LayuiPageInfo uslist() {
        InformationParam informationParam = new InformationParam();
        LoginUser user = LoginContextHolder.getContext().getUser();
        informationParam.setToUser(user.getId());
        return this.informationService.findPageBySpec(informationParam);
    }

    /**
     * 查看详情接口
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @RequestMapping("/look")
    @ResponseBody
    public ResponseData look(Long id) {
        Information detail = this.informationService.getById(id);
        InformationParam informationParam = new InformationParam();
        informationParam.setId(id);
        informationParam.setReades(true);
        informationParam.setReadTime(new Date());
        this.informationService.update(informationParam);
        return ResponseData.success(detail);
    }

    /**
     * 查看详情接口
     *
     * @author 韩硕
     * @Date 2020-09-30
     */
    @RequestMapping("/haveifm")
    @ResponseBody
    public Boolean haveifm() {
        LoginUser user = LoginContextHolder.getContext().getUser();
        InformationParam informationParam = new InformationParam();
        informationParam.setToUser(user.getId());
        informationParam.setReades(false);
        return this.informationService.findListBySpec(informationParam).size()!=0;
    }

}


