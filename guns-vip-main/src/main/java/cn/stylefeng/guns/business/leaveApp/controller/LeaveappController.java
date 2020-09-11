package cn.stylefeng.guns.business.leaveApp.controller;

import cn.hutool.core.io.FileUtil;
import cn.stylefeng.guns.base.auth.annotion.Permission;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.business.leaveApp.entity.Leaveapp;
import cn.stylefeng.guns.business.leaveApp.model.params.LeaveappParam;
import cn.stylefeng.guns.business.leaveApp.model.params.SpQxParam;
import cn.stylefeng.guns.business.leaveApp.model.result.LeaveappResult;
import cn.stylefeng.guns.business.leaveApp.model.result.SpQxResult;
import cn.stylefeng.guns.business.leaveApp.service.LeaveappService;
import cn.stylefeng.guns.sys.core.constant.Const;
import cn.stylefeng.guns.sys.modular.system.entity.Dept;
import cn.stylefeng.guns.sys.modular.system.entity.FileInfo;
import cn.stylefeng.guns.sys.modular.system.entity.User;
import cn.stylefeng.guns.sys.modular.system.model.UeditorFileResult;
import cn.stylefeng.guns.sys.modular.system.service.DeptService;
import cn.stylefeng.guns.sys.modular.system.service.FileInfoService;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.datascope.DataScope;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static cn.stylefeng.guns.sys.core.exception.enums.BizExceptionEnum.*;


/**
 * 控制器
 *
 * @author 韩硕
 * @Date 2020-09-02 16:56:38
 */
@Controller
@RequestMapping("/leaveapp")
public class LeaveappController extends BaseController {

    private String PREFIX = "/leaveapp";

    @Autowired
    private LeaveappService leaveappService;

    @Autowired
    private UserService userService;

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private DeptService deptService;

    /**
     * 跳转到主页面
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.XY_NAME, Const.BZ_NAME,Const.BZR_NAME})
    public String index() {
        return PREFIX + "/leaveapp.html";
    }

    /**
     * 新增页面
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("/add")
    @Permission(Const.ADMIN_NAME)
    public String add() {
        return PREFIX + "/leaveapp_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("/edit")
    @Permission(Const.ADMIN_NAME)
    public String edit() {
        return PREFIX + "/leaveapp_edit.html";
    }

    /**
     * 编辑页面
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("/app")
    public String app() {
        return PREFIX + "/leaveapp_app.html";
    }

    /**
     * 签名页面
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("/sign")
    public String sign() {
        return PREFIX + "/leaveapp_sign.html";
    }

    /**
     * 新增接口
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(LeaveappParam leaveappParam) {
        this.leaveappService.add(leaveappParam);
        return ResponseData.success();
    }

    /**
     * 申请接口
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("/appItem")
    @ResponseBody
    public ResponseData appItem(LeaveappParam leaveappParam) {
        leaveappParam.setXiaoqu("健翔桥校区");
        leaveappParam.setXueyuan("计算机学院");
        leaveappParam.setAppTime(new Date());
        leaveappParam.setUserId(LoginContextHolder.getContext().getUser().getId());
        this.leaveappService.add(leaveappParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("/editItem")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public ResponseData editItem(LeaveappParam leaveappParam) {
        this.leaveappService.update(leaveappParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("/delete")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public ResponseData delete(LeaveappParam leaveappParam) {
        this.leaveappService.delete(leaveappParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @RequestMapping("/detail")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.XY_NAME})
    @ResponseBody
    public ResponseData detail(LeaveappParam leaveappParam) {
        Leaveapp detail = this.leaveappService.getById(leaveappParam.getId());
        return ResponseData.success(detail);
    }


    /**
     * 查看自己列表
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @ResponseBody
    @RequestMapping("/uslist")
    public LayuiPageInfo uslist() {

        LeaveappParam leaveappParam = new LeaveappParam();

        LoginUser us = LoginContextHolder.getContext().getUser();
        leaveappParam.setUserId(us.getId());


        return this.leaveappService.findPageBySpec(leaveappParam);
    }

    /**
     * 查询列表
     *
     * @author 韩硕
     * @Date 2020-09-02
     */
    @ResponseBody
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.XY_NAME, Const.BZ_NAME,Const.BZR_NAME})
    @RequestMapping("/list")
    public LayuiPageInfo list(LeaveappParam leaveappParam) {

        LoginUser us = LoginContextHolder.getContext().getUser();

        for (String roleName : us.getRoleNames()) {
            if (roleName.equals("学院领导")) {
                leaveappParam.setFudaoyuanyijian("通过");
            }
        }
        leaveappParam.setDeptId(us.getDeptId());
        LayuiPageInfo pageBySpec = this.leaveappService.findPageBySpec(leaveappParam);
        for (Object datum : pageBySpec.getData()) {
            LeaveappResult data = (LeaveappResult) datum;
            data.setShenfenzheng("******"+data.getShenfenzheng().substring(16,18));
            try {
                data.setPhone(data.getPhone().substring(0, 1) + "***" + data.getPhone().substring(6, 10));
                data.setMyPhone(data.getMyPhone().substring(0, 1) + "***" + data.getMyPhone().substring(6, 10));
            } catch (Exception e){
                data.setPhone("***********");
                data.setMyPhone("***********");
            }
        }

        return pageBySpec;
    }

    /**
     * 审批接口
     *
     * @author 韩硕
     * @Date 2020-08-25
     */
    @RequestMapping("/sp")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.XY_NAME, Const.BZ_NAME, Const.BZR_NAME})
    @ResponseBody
    public ResponseData sp(LeaveappParam leaveParam) {
        LoginUser us = LoginContextHolder.getContext().getUser();

        SpQxParam spQxParam = new SpQxParam();
        spQxParam.setAppId(leaveParam.getId());
        spQxParam.setDeptId(us.getDeptId());
        SpQxResult map = leaveappService.lookSpQx(spQxParam);

        if(map.getNum() == 0)
            return ResponseData.error("您没有此权限");

        for (String roleName : us.getRoleNames()) {
            if (roleName.equals("学院领导")) {
                leaveParam.setXueyuanyijian(leaveParam.getYj());
                leaveParam.setXueyuanlingdao(us.getId());
                leaveParam.setTime(new Date());
            } else if (roleName.equals("辅导员")) {
                leaveParam.setFudaoyuanyijian(leaveParam.getYj());
                leaveParam.setFudaoyuan(us.getId());
                leaveParam.setFudaoyuanTime(new Date());
            } else if (roleName.equals("班主任")) {
                leaveParam.setBanzhurenyijian(leaveParam.getYj());
                leaveParam.setBanzhuren(us.getId());
                leaveParam.setBanzhurenTime(new Date());
            } else if (roleName.equals("班长")) {
                leaveParam.setBanzhangyijian(leaveParam.getYj());
                leaveParam.setBanzhang(us.getId());
                leaveParam.setBanzhangTime(new Date());
            }
        }
        this.leaveappService.update(leaveParam);
        return ResponseData.success();
    }


    /**
     * 获取文件
     *
     * @author dfggking
     * @date 2020/8/7 15:48
     * @version 1.0
     */
    @RequestMapping("/file")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.XY_NAME})
    public void file(Long fileId, Long userId, Long leaveId, HttpServletResponse response) {


        User user = userService.getById(userId);
        Dept dept = deptService.getById(user.getDeptId());
        Leaveapp leaveapp = leaveappService.getById(leaveId);
        String filename = dept.getSimpleName() + "-" + user.getName() + "-出校申请";

        if (fileId != null) {
            try {
                FileInfo fileInfo = fileInfoService.getById(fileId);
                // path是指欲下载的文件的路径。
                File file = new File(fileInfo.getFilePath());
                // 以流的形式下载文件。
                InputStream fis = new BufferedInputStream(new FileInputStream(fileInfo.getFilePath()));
                String ext = fileInfo.getFileName().substring(fileInfo.getFileName().lastIndexOf(".") + 1).toUpperCase();
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Disposition", "attachment;filename=" + new String((filename + "." + ext).getBytes("UTF-8"), "iso-8859-1"));
                response.addHeader("Content-Length", "" + file.length());
                response.setContentType("application/octet-stream");
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                toClient.write(buffer);
                toClient.flush();
                toClient.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Disposition", "attachment;filename=" + new String((filename + ".doc").getBytes("UTF-8"), "iso-8859-1"));
                response.setContentType("application/octet-stream");
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());


                // 要填充的数据, 注意map的key要和word中${xxx}的xxx一致
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy年MM月dd日");

                Map<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("name", user.getName());
                dataMap.put("sex", user.getSex().equals("M") ? "男" : "女");
                dataMap.put("xq", leaveapp.getXiaoqu());
                dataMap.put("ss", leaveapp.getSushehao());
                dataMap.put("xy", leaveapp.getXueyuan());
                dataMap.put("zy", dept.getSimpleName());
                dataMap.put("bj", dept.getSimpleName());
                dataMap.put("xh", user.getAccount());
                dataMap.put("id", "" + leaveapp.getShenfenzheng());
                dataMap.put("phone", "" + user.getPhone());
                dataMap.put("reason", leaveapp.getReason());
                dataMap.put("start_time", dateFormat.format(leaveapp.getStartTime()));
                dataMap.put("end_time", dateFormat.format(leaveapp.getEndTime()));
                dataMap.put("lianxiren", leaveapp.getJinjilianxiren());
                dataMap.put("gx", "" + leaveapp.getGuanxi());
                dataMap.put("lxr_phone", "" + leaveapp.getPhone());
                dataMap.put("juzhudizhi", leaveapp.getAddress());
                dataMap.put("xyyj", "" + ("通过".equals(leaveapp.getXueyuanyijian()) ? "同意" : "未审批"));
                dataMap.put("xueyuantime", dateFormat2.format(leaveapp.getTime()));

                ExecutorService executor = Executors.newFixedThreadPool(3);
                StringBuffer sb = new StringBuffer();
                for (String s : leaveapp.getChuxingguiji().split("\\|")) {
                    executor.submit(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject json = new JSONObject(transport("https://restapi.amap.com/v3/geocode/regeo?key=caa408034c27b0552255ab633c15858d&radius=0&extensions=all&batch=false&roadlevel=0&location=" + s, ""));
                            synchronized (LeaveappController.this) {
                                sb.append(" ==> " + json.getJSONObject("regeocode").getString("formatted_address"));
                            }
                        }
                    });
                }

                executor.shutdown();
                executor.awaitTermination(60, TimeUnit.SECONDS);

                dataMap.put("guiji", sb.toString());

                //Configuration用于读取ftl文件
                Configuration configuration = new Configuration();
                configuration.setDefaultEncoding("utf-8");
                /*以下是两种指定ftl文件所在目录路径的方式, 注意这两种方式都是
                 * 指定ftl文件所在目录的路径,而不是ftl文件的路径
                 */
                //指定路径的第一种方式(根据某个类的相对路径指定)
                //configuration.setClassForTemplateLoading(this.getClass(),"");

                //指定路径的第二种方式,我的路径是C:/a.ftl
                FileInfo fileInfo = fileInfoService.getById(1);
                configuration.setDirectoryForTemplateLoading(new File(fileInfo.getFilePath()));


                //以utf-8的编码读取ftl文件
                Template t = configuration.getTemplate("sqb.xml", "UTF-8");
                Writer out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"), 10240);
                t.process(dataMap, out);

                out.flush();
                out.close();
            } catch (TemplateException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private String transport(String url, String message) {
        StringBuffer sb = new StringBuffer();
        try {
            URL urls = new URL(url);
            HttpURLConnection uc = (HttpURLConnection) urls.openConnection();
            uc.setRequestMethod("POST");
            uc.setRequestProperty("content-type",
                    "application/x-www-form-urlencoded");
            uc.setRequestProperty("charset", "utf-8");
            uc.setDoOutput(true);
            uc.setDoInput(true);
            uc.setReadTimeout(10000);
            uc.setConnectTimeout(10000);
            OutputStream os = uc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.write(message.getBytes("utf-8"));
            dos.flush();
            os.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc
                    .getInputStream(), "utf-8"));
            String readLine;
            while ((readLine = in.readLine()) != null) {
                sb.append(readLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 文件上传
     *
     * @author fengshuonan
     * @Date 2019/8/26 15:19
     */
    @RequestMapping(value = "/fileUpdate")
    @Permission({Const.ADMIN_NAME, Const.FDY_NAME, Const.XY_NAME})
    @ResponseBody
    public UeditorFileResult fileUpdate(@RequestParam(value = "upfile") MultipartFile upfile, HttpServletRequest request) {
        if (upfile.isEmpty()) {
            throw new ServiceException(UE_FILE_NULL_ERROR);
        }

        // 获取文件名,后缀名
        String oldFileName = upfile.getOriginalFilename();
        String suffixName = ToolUtil.getFileSuffix(oldFileName);

        String fileId = IdWorker.getIdStr();
        // 重新命名图片
        String newFileName = fileId + "." + suffixName;

        UeditorFileResult ueditorFileResult = new UeditorFileResult();
        ueditorFileResult.setFileName(newFileName);
        ueditorFileResult.setFileId(fileId);

        //文件用原始文件
        String path = /*"/news_file"*//*"/Users/dfggking/dev/"*/"C:/test/" + newFileName;
        //String path = ConstantsContext.getFileUploadPath() +"/news_file"+ newFileName;
        ueditorFileResult.setUrl(path);
        ueditorFileResult.setTitle(newFileName);
        ueditorFileResult.setOriginal(newFileName);

        //更新申请表单数据
        LeaveappParam leaveappParam = new LeaveappParam();
        leaveappParam.setId(Long.parseLong(request.getParameter("id")));
        leaveappParam.setFileId(Long.parseLong(fileId));
        this.leaveappService.update(leaveappParam);

        try {

            File dest = new File(path);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            upfile.transferTo(dest);

            saveFileInfo(ueditorFileResult, upfile);

            return ueditorFileResult;
        } catch (IOException e) {
            throw new ServiceException(UE_FILE_SAVE_ERROR);
        }
    }

    /**
     * 附件上传
     *
     * @author fengshuonan
     * @Date 2019/8/26 15:19
     */
    @RequestMapping(value = "/fileUp")
    @ResponseBody
    public UeditorFileResult fileUp(@RequestParam(value = "upfile") MultipartFile upfile, HttpServletRequest request) {
        if (upfile.isEmpty()) {
            throw new ServiceException(UE_FILE_NULL_ERROR);
        }
        // 获取文件名,后缀名
        String oldFileName = upfile.getOriginalFilename();
        String suffixName = ToolUtil.getFileSuffix(oldFileName);
        String fileId = IdWorker.getIdStr();
        // 重新命名图片
        String newFileName = fileId + "." + suffixName;
        UeditorFileResult ueditorFileResult = new UeditorFileResult();
        ueditorFileResult.setFileName(newFileName);
        ueditorFileResult.setFileId(fileId);
        //文件用原始文件
        String path = /*"/news_file"*//*"/Users/dfggking/dev/"*/"C:/test/" + newFileName;
        //String path = ConstantsContext.getFileUploadPath() +"/news_file"+ newFileName;
        ueditorFileResult.setUrl(path);
        ueditorFileResult.setTitle(newFileName);
        ueditorFileResult.setOriginal(newFileName);
        try {
            File dest = new File(path);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            upfile.transferTo(dest);
            saveFileInfo(ueditorFileResult, upfile);
            return ueditorFileResult;
        } catch (IOException e) {
            throw new ServiceException(UE_FILE_SAVE_ERROR);
        }
    }

    /**
     * 签名上传传
     *
     * @author fengshuonan
     * @Date 2019/8/26 15:19
     */
    @RequestMapping(value = "/signUp")
    @ResponseBody
    public UeditorFileResult signUp(String img) throws Exception {

        Long name = IdWorker.getId();
        String newFileName = name + ".png";

        String path = /*"/news_file"*//*"/Users/dfggking/dev/"*/"C:/test/" + newFileName;

        //保存文件信息
        FileInfo mediaFile = new FileInfo();
        mediaFile.setFileId("" + name);
        mediaFile.setFileName(newFileName);
        mediaFile.setFilePath(path);
        mediaFile.setFinalName(newFileName);
        fileInfoService.save(mediaFile);

        decoderBase64File(img.split(",")[1], path);

        return new UeditorFileResult("" + name, "", newFileName, newFileName, newFileName);

    }

    private static void decoderBase64File(String base64Code, String targetPath) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    /**
     * 保存文件信息
     *
     * @author dfggking
     * @date 2020/3/5 15:34
     * @version 1.0
     */
    private void saveFileInfo(UeditorFileResult fileResult, MultipartFile upfile) {
        FileInfo mediaFile = new FileInfo();
        String fileSuffix = ToolUtil.getFileSuffix(upfile.getOriginalFilename());
        mediaFile.setFileId(fileResult.getFileId());
        mediaFile.setFileName(upfile.getOriginalFilename());
        mediaFile.setFinalName(fileResult.getTitle());
        mediaFile.setFilePath(fileResult.getUrl());
        mediaFile.setFileSuffix(fileSuffix);
        //计算文件大小kb
        long kb = new BigDecimal(upfile.getSize())
                .divide(BigDecimal.valueOf(1024))
                .setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
        mediaFile.setFileSizeKb(kb);
        fileInfoService.save(mediaFile);
    }

}


