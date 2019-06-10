package com.itheima.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 传统方式的文件上传
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Controller
@RequestMapping("springmvc")
public class FileUploadController1 {

    /**
     * 传统方式文件上传
     * @return
     */
    @RequestMapping("fileupload1")
    public String fileUpload(HttpServletRequest request)throws  Exception{
        //1.文件保存到服务器的何处
        ServletContext sc = request.getSession().getServletContext();
        //2.获取当前应用发布目录
        String basePath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
        //3.为了防止一个目录下文件过多，创建一个二级目录，以当前日期作为文件夹名
        //String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //4.判断目录是否存在
        File file = new File(basePath);
//        if(!file.exists()){
//            file.mkdirs();
//        }
        //5.创建磁盘文件项工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //6.创建文件上传的核心对象
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //7.解析request中的请求正文（多部分表单上数据）
        List<FileItem> items = sfu.parseRequest(request);
        //8.遍历集合
        for(FileItem item : items){
            //判断当前item是不是文件
            if(item.isFormField()){
                //表示不是文件
                System.out.println(item.getFieldName());
            }else{
                //表示是文件
                //取出文件名
                String fileName = item.getName();
                //随机化文件名
                String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
                fileName = uuid+"_"+fileName;
                //写文件
                item.write(new File(file,fileName));
            }
        }
        return "success";
    }
}
