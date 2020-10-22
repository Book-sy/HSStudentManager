package cn.stylefeng.guns.business.score.controller;

import cn.stylefeng.guns.base.auth.annotion.Permission;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.information.entity.Information;
import cn.stylefeng.guns.business.information.model.params.InformationParam;
import cn.stylefeng.guns.business.information.service.InformationService;
import cn.stylefeng.guns.business.score.entity.Score;
import cn.stylefeng.guns.business.score.model.params.ScoreParam;
import cn.stylefeng.guns.business.score.service.ScoreService;
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
@RequestMapping("/score")
public class ScoreController extends BaseController {

    private String PREFIX = "/score";

    @Autowired
    private ScoreService scoreService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.XY_NAME,Const.BZR_NAME})
    public String index() {
        return PREFIX + "/score.html";
    }

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/us")
    public String us() {
        return PREFIX + "/score_us.html";
    }

    /**
     * 新增页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/score_add.html";
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
        return PREFIX + "/score_edit.html";
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
    public ResponseData addItem(ScoreParam scoreParam) {
        this.scoreService.add(scoreParam);
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
    public ResponseData editItem(ScoreParam scoreParam) {
        this.scoreService.update(scoreParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/delete")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.XY_NAME})
    @ResponseBody
    public ResponseData delete(ScoreParam scoreParam) {
        this.scoreService.delete(scoreParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/detail")
    @ResponseBody
    @Permission({Const.ADMIN_NAME})
    public ResponseData detail(ScoreParam scoreParam) {
        Score detail = this.scoreService.getById(scoreParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @ResponseBody
    @RequestMapping("/uslist")
    public LayuiPageInfo uslist(ScoreParam scoreParam) {
        scoreParam.setUser(LoginContextHolder.getContext().getUser().getId());
        return this.scoreService.findPageBySpec(scoreParam);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @ResponseBody
    @RequestMapping("/list")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.XY_NAME})
    public LayuiPageInfo list(ScoreParam scoreParam) {
        return this.scoreService.findPageBySpec(scoreParam);
    }

}


