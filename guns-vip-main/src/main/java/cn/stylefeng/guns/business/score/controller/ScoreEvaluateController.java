package cn.stylefeng.guns.business.score.controller;

import cn.stylefeng.guns.base.auth.annotion.Permission;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.information.entity.Information;
import cn.stylefeng.guns.business.information.model.params.InformationParam;
import cn.stylefeng.guns.business.information.service.InformationService;
import cn.stylefeng.guns.business.score.entity.ScoreEvaluate;
import cn.stylefeng.guns.business.score.model.params.ScoreEvaluateParam;
import cn.stylefeng.guns.business.score.service.ScoreEvaluateService;
import cn.stylefeng.guns.business.score.service.ScoreService;
import cn.stylefeng.guns.sys.core.constant.Const;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
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
@RequestMapping("/scoreEvaluate")
public class ScoreEvaluateController extends BaseController {

    private String PREFIX = "/scoreEvaluate";

    @Autowired
    private ScoreEvaluateService scoreEvaluateService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private UserService userService;

    @Autowired
    private InformationService informationService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("")
    @Permission({Const.ADMIN_NAME})
    public String index() {
        return PREFIX + "/scoreEvaluate.html";
    }

    /**
     * 新增页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/scoreEvaluate_add.html";
    }

    /**
     * 新增页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/adminadd")
    public String adminadd() {
        return PREFIX + "/scoreEvaluate_adminadd.html";
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
        return PREFIX + "/scoreEvaluate_edit.html";
    }

    /**
     * 编辑页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/eve")
    public String eve() {
        return PREFIX + "/scoreEvaluate_eve.html";
    }

    /**
     * 编辑页面
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/admineve")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME})
    public String admineve() {
        return PREFIX + "/scoreEvaluate_admineve.html";
    }

    /**
     * 新增接口
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/pl")
    @ResponseBody
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.BZR_NAME})
    public ResponseData pl(ScoreEvaluateParam scoreEvaluateParam) {

        InformationParam informationParam = new InformationParam();
        informationParam.setReades(false);
        informationParam.setToUser(scoreService.getById(scoreEvaluateParam.getScoreId()).getUser());
        informationParam.setText("您的绩点排名被评论过了哦~记得去查看");
        informationService.add(informationParam);

        this.scoreEvaluateService.add(scoreEvaluateParam);
        this.scoreService.eveplus(scoreEvaluateParam.getScoreId());
        return ResponseData.success();
    }

    /**
     * 新增接口
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ScoreEvaluateParam scoreEvaluateParam) {
        if(!scoreService.getById(scoreEvaluateParam.getScoreId()).getUser().equals(LoginContextHolder.getContext().getUser().getId()))
            return ResponseData.error("权限错误");
        this.scoreEvaluateService.add(scoreEvaluateParam);
        this.scoreService.eveplus(scoreEvaluateParam.getScoreId());
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
    public ResponseData editItem(ScoreEvaluateParam scoreEvaluateParam) {
        this.scoreEvaluateService.update(scoreEvaluateParam);
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
    public ResponseData delete(ScoreEvaluateParam scoreEvaluateParam) {
        this.scoreEvaluateService.delete(scoreEvaluateParam);
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
    public ResponseData detail(ScoreEvaluateParam scoreEvaluateParam) {
        ScoreEvaluate detail = this.scoreEvaluateService.getById(scoreEvaluateParam.getId());
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
    public LayuiPageInfo list(ScoreEvaluateParam scoreEvaluateParam) {
        return this.scoreEvaluateService.findPageBySpec(scoreEvaluateParam);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @ResponseBody
    @RequestMapping("/evelist")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.BZR_NAME})
    public LayuiPageInfo evelist(Long id) {
        ScoreEvaluateParam scoreEvaluateParam = new ScoreEvaluateParam();
        scoreEvaluateParam.setScoreId(id);
        return this.scoreEvaluateService.findPageBySpec(scoreEvaluateParam);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-09-27
     */
    @ResponseBody
    @RequestMapping("/uslist")
    public LayuiPageInfo usList(Long id) {
        ScoreEvaluateParam scoreEvaluateParam = new ScoreEvaluateParam();
        scoreEvaluateParam.setScoreId(id);
        return this.scoreEvaluateService.findPageBySpec(scoreEvaluateParam);
    }

}


