package cn.stylefeng.guns.sys.modular.system.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.stylefeng.guns.sys.core.util.UeditorUtil;
import cn.stylefeng.guns.sys.modular.system.entity.FileInfo;
import cn.stylefeng.guns.sys.modular.system.model.UeditorFileResult;
import cn.stylefeng.guns.sys.modular.system.service.FileInfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import static cn.stylefeng.guns.sys.core.exception.enums.BizExceptionEnum.*;

/**
 * UEditor相关文件操作
 *
 * @author fengshuonan
 * @Date 2019-08-27 10:02
 */
@Controller
@RequestMapping("/ueditor")
@CrossOrigin
@Slf4j
public class UeditorController {

    @Autowired
    private FileInfoService fileInfoService;

    /**
     * 获取ueditor的配置
     *
     * @author fengshuonan
     * @Date 2019/8/26 15:18
     */
    @RequestMapping("/config")
    @ResponseBody
    public void getConfigInfo(HttpServletResponse response) {
        try {
            response.setContentType("application/json;charset=utf-8");
            String json = ResourceUtil.readStr("classpath:ueditor.json", StandardCharsets.UTF_8);
            response.getWriter().write(json);
            response.getWriter().flush();
        } catch (Exception e) {
            log.error("读取ueditor配置失败!", e);
            throw new ServiceException(UE_CONFIG_ERROR);
        }
    }

    /**
     * 图片上传
     *
     * @author fengshuonan
     * @Date 2019/8/26 15:19
     */
    @RequestMapping(value = "/imgUpdate")
    @ResponseBody
    public UeditorFileResult imgUpdate(@RequestParam(value = "upfile") MultipartFile upfile) {
        return UeditorUtil.uploadFile(upfile, UeditorUtil.FileType.IMG);
    }

    /**
     * ueditor文件上传方法
     *
     * @author fengshuonan
     * @Date 2019-08-27 10:05
     */
    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public UeditorFileResult uploadFile(@RequestParam(value = "upfile") MultipartFile upfile) {
        return UeditorUtil.uploadFile(upfile, UeditorUtil.FileType.FILE);
    }

    /**
     * 视频上传
     *
     * @author fengshuonan
     * @Date 2019-04-08 16:12
     */
    @RequestMapping(value = "/uploadvideo")
    @ResponseBody
    public UeditorFileResult uploadvideo(@RequestParam(value = "upfile") MultipartFile upfile) {
        return UeditorUtil.uploadFile(upfile, UeditorUtil.FileType.VIDEO);
    }

    /**
     * 通过url请求返回图像的字节流
     *
     * @author fengshuonan
     * @Date 2019-04-08 16:12
     */
    @RequestMapping("/images/{fileName}")
    public void getImages(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        UeditorUtil.readFile(fileName, response, UeditorUtil.FileType.IMG, null);
    }


    /**
     * 通过url请求返回文件的字节流
     *
     * @author fengshuonan
     * @Date 2019-04-08 16:12
     */
    @RequestMapping("/file/{fileName}/{orginalName}")
    public void getIco(@PathVariable("fileName") String fileName, @PathVariable("orginalName") String orginalName, HttpServletResponse response) {
        UeditorUtil.readFile(fileName, response, UeditorUtil.FileType.FILE, orginalName);
    }


    /**
     * 通过url请求返回图像的字节流
     *
     * @author fengshuonan
     * @Date 2019-04-08 16:12
     */
    @RequestMapping("/video/{fileName}")
    public void getVideo(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        UeditorUtil.readFile(fileName, response, UeditorUtil.FileType.VIDEO, null);
    }

    /**
     *获取图片
     * @author dfggking
     * @date 2020/8/7 15:48
     * @version 1.0
     */
    @RequestMapping("/img")
    public void readImg(Long id, HttpServletResponse response) {

        FileInfo fileInfo = fileInfoService.getById(id);

        //获取文件路径
        File file = new File(fileInfo.getFilePath());

        //文件不存在或者不可读
        if (!file.exists() || !file.canRead()) {
            throw new ServiceException(UE_FILE_NULL_ERROR);
        }

        //读取文件
        byte[] bytes = null;

        //设置响应的类型
        response.setContentType("image/png");
        bytes = FileUtil.readBytes(file);

        try {
            OutputStream stream = response.getOutputStream();
            stream.write(bytes);
        } catch (IOException e) {
            throw new ServiceException(UE_FILE_READ_ERROR);
        }
    }
}
