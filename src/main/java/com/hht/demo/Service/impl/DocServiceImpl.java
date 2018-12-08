package com.hht.demo.Service.impl;

import com.hht.demo.Bean.Doc;
import com.hht.demo.Mapper.Docmapper;
import com.hht.demo.Service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DocServiceImpl implements DocService {
    @Autowired
    private Docmapper docmapper;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<Doc> selectall(String username) {
        return docmapper.selectalluser(username);
    }

    @Override
    public List<Doc> selectdocbyname(String username) {
        return docmapper.selectdocbyname(username);
    }

    @Override
    public List<Doc> selectshare(String isshare) {
        return docmapper.selectallshare(isshare);
    }

    @Override
    public void deldoc(int id) {
        docmapper.deldoc(id);
    }

    @Override
    public String upload(MultipartFile file, HttpSession session) {
        Doc doc = new Doc();
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
//      System.out.println("fileName:" + fileName);
        String filePath = "G:\\ae素材\\boot\\disk\\src\\main\\resources\\static\\upload\\";
//      String filePath = "./upload/";
        System.out.println("上传到"+filePath + fileName);
        File dest = new File(filePath + fileName);

        doc.setFilesize(file.getSize());
        doc.setFilename(fileName);
        doc.setSavepath(filePath+fileName);
        doc.setFiletype(file.getContentType());
        doc.setCount(0);
        doc.setIsshare("否");
        doc.setMemo(" ");
        doc.setUploaddate(df.format(new Date()));
        doc.setCatalog(" ");
        doc.setUsername((String) session.getAttribute("username"));

        try {
            file.transferTo(dest);
            if(docmapper.selectOneFileByFileName(fileName)==null){
                docmapper.insert(doc);
            }
            return "上传成功";
        } catch (IOException e) {
        }
        return "上传失败！";
    }

    @Override
    public void updateshare(int id) {
        docmapper.updateshare(id);
    }
}
