package com.aikon.wht.controller;

import com.aikon.wht.enums.ImageFormatQiniuEnum;
import com.aikon.wht.model.UploadFileModel;
import com.aikon.wht.service.UploadImageService;
import com.beust.jcommander.internal.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author haitao.wang
 */
@Controller
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @Autowired
    UploadImageService uploadImageService;

    @ResponseBody
    @RequestMapping("/image")
    public UploadFileModel uploadImage(MultipartFile file) {
        return this.upload(file, ImageFormatQiniuEnum.ORIGIN);
    }

    @ResponseBody
    @RequestMapping("/imageWater")
    public UploadFileModel uploadImageWater(MultipartFile file) {
        return this.upload(file, ImageFormatQiniuEnum.ORIGIN_WATERMARK);
    }


    @RequestMapping("/imageEditor")
    @ResponseBody
    public void uploadImageEditor(@RequestParam(value = "upfile", required = false) MultipartFile file, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        UploadFileModel uploadFileModel;
        String msg = uploadImageService.checkFileTypeAndSize(file, Lists.newArrayList("jpg", "png", "bmp","jpeg"), 3);
        if (!"".equals(msg)) {
            response.getWriter().print("{'state':'" + msg + "'}");
            return;
        }
        uploadFileModel = this.upload(file, ImageFormatQiniuEnum.ORIGIN_WATERMARK);
        if (uploadFileModel == null) {
            response.getWriter().print("{'state':'" + "无法连接服务器" + "'}");
        }
        String url = uploadFileModel.getUrl();
        response.getWriter().print(
                "{'original':'测试图片','url':'" + url + "','title':'','state':'"
                        + "SUCCESS" + "'}");
    }


    private UploadFileModel upload(MultipartFile file, ImageFormatQiniuEnum qiniuEnum) {
        UploadFileModel uploadFileModel = new UploadFileModel();
        String msg = uploadImageService.checkFileTypeAndSize(file, Lists.newArrayList("jpg", "png", "bmp","jpeg"), 3);
        if (!"".equals(msg)) {
            uploadFileModel.setMsg(msg);
            return uploadFileModel;
        }
        uploadFileModel = uploadImageService.upload(file, qiniuEnum);
        if (uploadFileModel == null) {
            return null;
        }
        return uploadFileModel;
    }


}
