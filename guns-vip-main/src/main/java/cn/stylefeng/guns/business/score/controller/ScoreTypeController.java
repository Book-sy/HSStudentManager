package cn.stylefeng.guns.business.score.controller;

import cn.stylefeng.guns.base.auth.annotion.Permission;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.score.entity.ScoreType;
import cn.stylefeng.guns.business.score.model.params.ScoreTypeParam;
import cn.stylefeng.guns.business.score.service.ScoreTypeService;
import cn.stylefeng.guns.sys.core.constant.Const;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 控制器
 *
 * @author 韩硕
 * @Date 2020-09-27 16:38:09
 */
@Controller
@RequestMapping("/scoreType")
public class ScoreTypeController extends BaseController {

    private String PREFIX = "/scoreType";

    @Autowired
    private ScoreTypeService scoreTypeService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("")
    @Permission({Const.ADMIN_NAME})
    public String index() {
        return PREFIX + "/scoreType.html";
    }

    /**
     * 新增页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/add")
    @Permission({Const.ADMIN_NAME})
    public String add() {
        return PREFIX + "/scoreType_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/edit")
    @Permission({Const.ADMIN_NAME})
    public String edit() {
        return PREFIX + "/scoreType_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/addItem")
    @Permission({Const.ADMIN_NAME})
    @ResponseBody
    public ResponseData addItem(ScoreTypeParam scoreTypeParam) {
        this.scoreTypeService.add(scoreTypeParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/editItem")
    @Permission({Const.ADMIN_NAME})
    @ResponseBody
    public ResponseData editItem(ScoreTypeParam scoreTypeParam) {
        this.scoreTypeService.update(scoreTypeParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/delete")
    @Permission({Const.ADMIN_NAME})
    @ResponseBody
    public ResponseData delete(ScoreTypeParam scoreTypeParam) {
        this.scoreTypeService.delete(scoreTypeParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/detail")
    @Permission({Const.ADMIN_NAME})
    @ResponseBody
    public ResponseData detail(ScoreTypeParam scoreTypeParam) {
        ScoreType detail = this.scoreTypeService.getById(scoreTypeParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @ResponseBody
    @RequestMapping("/list")
    @Permission({Const.ADMIN_NAME})
    public LayuiPageInfo list(ScoreTypeParam scoreTypeParam) {
        return this.scoreTypeService.findPageBySpec(scoreTypeParam);
    }

}


