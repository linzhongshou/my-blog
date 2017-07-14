package cn.linzs.controller;

import cn.linzs.commons.utils.ImageUploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By linzs on 7/14/17 11:51 AM
 */
@Controller
@RequestMapping("/image")
public class ImageUploadController {

    @Value("${img.path}")
    private static String UPLOAD_PATH;

    @RequestMapping("/upload")
    public void imageUpload(HttpServletRequest request, HttpServletResponse response) {
        try {
            ImageUploadUtil.ckeditor(request, response, UPLOAD_PATH);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
