package com.hht.demo.Controller;

import com.hht.demo.Service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class uploadController {

    @Autowired
    private DocService docService;

    @RequestMapping("/file/upload")
    public Map<String,String> upload(MultipartFile file, HttpSession session){
        docService.upload(file,session);
        Map<String,String> map = new HashMap();

        map.put("msg","ok");
        map.put("code","0");

        return map;
    }

    @GetMapping("/file/Download2")
    public void downloadFileByOutputStream(HttpServletResponse res,HttpSession session) {

        String fileName = (String)session.getAttribute("filename");
        System.out.println((String)session.getAttribute("filename"));
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/x-msdownload");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("G://ae素材//boot//disk//src//main//resources//static//upload//"
                    + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }
}
