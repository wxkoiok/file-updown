package com.wxkoiok.fileupdown.controller;

import com.wxkoiok.fileupdown.response.ResultBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @description: 文件上传下载
 * @author: wuxiang
 * @create: 2019-05-29 18:04
 **/
@RequestMapping("/file")
@RestController
public class FileController  extends BaseController{

    private String  filePath = FileController.class.getClassLoader().getResource("").getFile()+ "static/img/";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHssmmSSS");

    @PostMapping("")
    public ResultBean upload(@RequestParam("file") MultipartFile[] files) throws IOException {

        List<String> filePathList = new ArrayList<>();
        for (int index = 0; index < files.length; index++) {
            MultipartFile file = files[index];
            //上传文件
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String format = simpleDateFormat.format(new Date());
            if(format.startsWith("0")){
                format = format.substring(1);
            }
            int random = (int)(10000+Math.random()*9000);

            Long hexInt =Long.parseLong(format,16);
            String fileName = hexInt+""+random+suffix;
            String pathname = filePath+fileName;
            File localFile = new File(pathname);
            //文件名存在就再来一次
            if(localFile.exists()){
                index--;
                continue;
            }

            file.transferTo(localFile);
            filePathList.add("static/img/" +fileName);

        }
        return new ResultBean<>(filePathList);
    }

    @GetMapping("/{filename}")
    public ResultBean delete(@PathVariable("filename") String filename){
        String pathname = filePath+filename;
        File localFile = new File(pathname);
        if(localFile.exists()){
            localFile.delete();
        }
        return new ResultBean("删除成功");
    }

}
