package com.xhc.springcloud.demouser;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class UploadDemo {

    /**
     * curl -F "file=@文件路径" localhost:8080/upload
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam(value = "file", required = true) MultipartFile multipartFile) throws  Exception{
        byte[] bytes = multipartFile.getBytes();
        File file = new File(multipartFile.getOriginalFilename());
        FileCopyUtils.copy(bytes, file);
        return file.getAbsolutePath();
    }


}
