package cn.linzs.commons.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created By linzs on 7/14/17 11:32 AM
 * 文件上传工具类，包括ckeditor操作
 */
@Component
public class FileUploadUtil {

    /**
     * 文件上传
     *
     * @Title upload
     * @param request
     * @param directoryName
     *            文件上传目录
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String upload(HttpServletRequest request, String directoryName) throws IllegalStateException,
            IOException {
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());

        // 文件名称
        String fileName = null;
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 记录上传过程起始时的时间，用来计算上传时间
                // int pre = (int) System.currentTimeMillis();
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 获得文件的原始名称
                        String originalFilename = file.getOriginalFilename();
                        // 获得文件后缀名称
                        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

                        if(!directoryName.endsWith(File.separator)) {
                            directoryName = directoryName + File.separator;
                        }
                        // 如果路径不存在，则创建该路径
                        File realPathDirectory = new File(directoryName);
                        if (realPathDirectory == null || !realPathDirectory.exists()) {
                            realPathDirectory.mkdirs();
                        }
                        // 重命名上传后的文件名 xxx.jpg
                        fileName = System.currentTimeMillis() + suffix;
                        // 定义上传路径 .../upload/xxx.jpg
                        File uploadFile = new File(realPathDirectory + File.separator + fileName);
                        System.out.println(uploadFile);
                        file.transferTo(uploadFile);
                    }
                }
            }
        }
        return fileName;
    }

}