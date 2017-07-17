package cn.linzs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

/**
 * Created By linzs on 7/14/17 3:17 PM
 */
@Controller
@RequestMapping("/ckeditor")
public class CkeditorController {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @Value("${upload.path}")
    private String UPLOAD_PATH;
    @Value("${ckeditor.img.path}")
    private String CKEDITOR_IMG_PATH;
    private final ResourceLoader resourceLoader;

    @Autowired
    public CkeditorController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @RequestMapping(value = "/images/{day}/{fileName}.{extension}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getFile(@PathVariable String day,
                          @PathVariable String fileName,
                          @PathVariable String extension) {
        byte[] imgBuffer = null;
        FileInputStream fis = null;
        try {
            fileName = fileName + "." + extension;
            String filePath = UPLOAD_PATH + CKEDITOR_IMG_PATH + File.separator + day + File.separator + fileName;
            File imgFile = resourceLoader.getResource("file:" + Paths.get(filePath)).getFile();
            fis = new FileInputStream(imgFile);

            imgBuffer = new byte[fis.available()];
            fis.read(imgBuffer);
        } catch (Exception e) {} finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {}
            }
        }

        return imgBuffer;
    }
}
