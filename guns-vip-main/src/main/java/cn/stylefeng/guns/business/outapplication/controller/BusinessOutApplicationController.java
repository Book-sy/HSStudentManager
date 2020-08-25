package cn.stylefeng.guns.business.outapplication.controller;

import cn.afterturn.easypoi.entity.vo.MapExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.consts.ConstantsContext;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.dailyreport.model.result.BusinessDailyReportResult;
import cn.stylefeng.guns.business.outapplication.entity.BusinessOutApplication;
import cn.stylefeng.guns.business.outapplication.model.params.BusinessOutApplicationParam;
import cn.stylefeng.guns.business.outapplication.model.result.BusinessOutApplicationResult;
import cn.stylefeng.guns.business.outapplication.service.BusinessOutApplicationService;
import cn.stylefeng.guns.sys.core.exception.enums.BizExceptionEnum;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 控制器
 *
 * @author 韩硕
 * @Date 2020-08-01 21:08:07
 */
@Controller
@RequestMapping("/businessOutApplication")
public class BusinessOutApplicationController extends BaseController {

    private String PREFIX = "/businessOutApplication";

    @Autowired
    private BusinessOutApplicationService businessOutApplicationService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/businessOutApplication.html";
    }

    /**
     * 新增页面
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/businessOutApplication_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/businessOutApplication_edit.html";
    }


    /**
     * 申请接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/app")
    public String app() {
        return PREFIX + "/businessOutApplication_application.html";
    }

    /**
     * 用户修改接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/eapp")
    public String eapp() {
        return PREFIX + "/businessOutApplication_eapp.html";
    }

    /**
     * 确认界面接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/sure")
    public String sure() {
        return PREFIX + "/businessOutApplication_sure.html";
    }

    /**
     * 新增接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(BusinessOutApplicationParam businessOutApplicationParam) {
        this.businessOutApplicationService.add(businessOutApplicationParam);
        return ResponseData.success();
    }

    /**
     * 申请接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/appItem")
    @ResponseBody
    public ResponseData appItem(BusinessOutApplicationParam businessOutApplicationParam) {
        businessOutApplicationParam.setUser(LoginContextHolder.getContext().getUser().getName());
        businessOutApplicationParam.setOneTime(new Date());
        businessOutApplicationParam.setNowstep(0);
        businessOutApplicationParam.setCls(LoginContextHolder.getContext().getUser().getDeptName());
        this.businessOutApplicationService.add(businessOutApplicationParam);
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
    public ResponseData editItem(BusinessOutApplicationParam businessOutApplicationParam) {
        if (this.businessOutApplicationService.getById(businessOutApplicationParam.getId()).getNowstep() == 4)
            businessOutApplicationParam.setNowstep(0);
        this.businessOutApplicationService.update(businessOutApplicationParam);
        return ResponseData.success();
    }

    /**
     * 审阅接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/sy")
    @ResponseBody
    public ResponseData sy(HttpServletRequest request) {
        BusinessOutApplicationParam boap = this.businessOutApplicationService.getById(request.getParameter("id")).toParam();
        boap.setTwoTime(new Date());
        boap.setNowstep(1);
        this.businessOutApplicationService.update(boap);
        return ResponseData.success();
    }

    /**
     * 批复接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/pf")
    @ResponseBody
    public ResponseData pf(HttpServletRequest request) {
        BusinessOutApplicationParam boap = this.businessOutApplicationService.getById(request.getParameter("id")).toParam();
        boap.setThreeTime(new Date());
        boap.setNowstep(2);
        this.businessOutApplicationService.update(boap);
        return ResponseData.success();
    }

    /**
     * 确认接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/qr")
    @ResponseBody
    public ResponseData qr(HttpServletRequest request) {
        BusinessOutApplicationParam boap = this.businessOutApplicationService.getById(request.getParameter("id")).toParam();
        boap.setFourTime(new Date());
        boap.setNowstep(3);
        boap.setBeizhu(LoginContextHolder.getContext().getUser().getDeptName()+LoginContextHolder.getContext().getUser().getName()+"同学于 "+request.getParameter("msg"));
        this.businessOutApplicationService.update(boap);
        return ResponseData.success();
    }

    /**
     * 批复接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/qx")
    @ResponseBody
    public ResponseData qx(HttpServletRequest request) {
        BusinessOutApplicationParam boap = this.businessOutApplicationService.getById(request.getParameter("id")).toParam();
        boap.setNowstep(6);
        this.businessOutApplicationService.update(boap);
        return ResponseData.success();
    }

    /**
     * 批复接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/dh")
    @ResponseBody
    public ResponseData dh(HttpServletRequest request) {
        BusinessOutApplicationParam boap = this.businessOutApplicationService.getById(request.getParameter("id")).toParam();
        boap.setNowstep(4);
        this.businessOutApplicationService.update(boap);
        return ResponseData.success();
    }

    /**
     * 批复接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping("/jj")
    @ResponseBody
    public ResponseData jj(HttpServletRequest request) {
        BusinessOutApplicationParam boap = this.businessOutApplicationService.getById(request.getParameter("id")).toParam();
        boap.setNowstep(5);
        this.businessOutApplicationService.update(boap);
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
    public ResponseData delete(BusinessOutApplicationParam businessOutApplicationParam) {
        this.businessOutApplicationService.delete(businessOutApplicationParam);
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
    public ResponseData detail(BusinessOutApplicationParam businessOutApplicationParam) {
        BusinessOutApplication detail = this.businessOutApplicationService.getById(businessOutApplicationParam.getId());
        return ResponseData.success(detail);
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
        return this.businessOutApplicationService.findPageBySpec(businessOutApplicationParam);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @ResponseBody
    @RequestMapping("/listUser")
    public LayuiPageInfo listUser(BusinessOutApplicationParam businessOutApplicationParam) {
        businessOutApplicationParam.setUser(LoginContextHolder.getContext().getUser().getName());
        return this.businessOutApplicationService.findPageBySpec(businessOutApplicationParam);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @ResponseBody
    @RequestMapping("/bzlist")
    public LayuiPageInfo bzlist(BusinessOutApplicationParam businessOutApplicationParam) {
        List<BusinessOutApplicationResult> layuiPageInfo = this.businessOutApplicationService.findListBySpec(businessOutApplicationParam);
        String cls = LoginContextHolder.getContext().getUser().getDeptName();
        Iterator<BusinessOutApplicationResult> iterator = layuiPageInfo.iterator();
        while (iterator.hasNext()) {
            BusinessOutApplicationResult s = iterator.next();
            if (!cls.equals(s.getCls())) {
                iterator.remove();
            }
        }
        LayuiPageInfo r = new LayuiPageInfo();
        r.setData(layuiPageInfo);
        return r;
    }

    /**
     * 文件上传接口
     *
     * @author 韩硕
     * @Date 2020-08-01
     */
    @RequestMapping(method = RequestMethod.POST, path = "/file")
    @ResponseBody
    public ResponseData file(@RequestPart("file") MultipartFile picture) {
        String rootPath = "C:\\HS1r1bSYSTEM\\"+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File file = new File(rootPath);
        if(!file.exists()){
            file.mkdirs();
        }
        String pictureName = "计算机学院-2019级"+ LoginContextHolder.getContext().getUser().getDeptName() +"-"+LoginContextHolder.getContext().getUser().getName()+"-" +LoginContextHolder.getContext().getUser().getAccount()+"-"+new Random().nextInt(100)+"." + ToolUtil.getFileSuffix(picture.getOriginalFilename());
        String path = rootPath+"\\"+pictureName;
        try {
            picture.transferTo(new File(path));
        } catch (Exception e) {
            throw new ServiceException(BizExceptionEnum.UPLOAD_ERROR);
        }
        return ResponseData.success(path);
    }


    @Autowired
    private UserService userService;

    /**
     * 模板下载
     *
     * @author fengshuonan
     * @Date 2019/3/9 11:03
     */
    @RequestMapping("/dld")
    public void dld(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String wj = request.getParameter("file");
        String downloadFilePath = "C:\\HS1r1bSYSTEM\\demo\\"+wj+".doc";
        String fileName;
        if(wj.equals("ljdemo")){
            fileName = URLEncoder.encode("离京申请模板.doc","UTF-8");
        } else if(wj.equals("lj")) {
            fileName = URLEncoder.encode("离京申请表.doc","UTF-8");
        } else if(wj.equals("jwdemo")){
            fileName = URLEncoder.encode("非湖北非京出行模板.doc","UTF-8");
        } else if(wj.equals("jw")) {
            fileName = URLEncoder.encode("非湖北非京出行.doc","UTF-8");
        } else if(wj.equals("fjdemo")){
            fileName = URLEncoder.encode("返京申请模板.doc","UTF-8");
        } else {
            fileName = URLEncoder.encode("返京申请表.doc","UTF-8");
        }

        File file = new File(downloadFilePath);
        if (file.exists()) {
            // 设置强制下载不打开
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return;
    }

    /**
     * excel导出
     *
     * @author fengshuonan
     * @Date 2019/3/9 11:03
     */
    @RequestMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //被下载的文件在服务器中的路径,
        String downloadFilePath = this.businessOutApplicationService.getById(request.getParameter("id")).getFile();
        //被下载文件的名称,下载之后的文件显示的名字,
        String[] ml = downloadFilePath.split("\\\\");
        String fileName = ml[ml.length-1];
        fileName = URLEncoder.encode(fileName,"UTF-8");

        File file = new File(downloadFilePath);
        if (file.exists()) {
            // 设置强制下载不打开
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return;
    }

}


