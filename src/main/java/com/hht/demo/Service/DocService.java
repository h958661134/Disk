package com.hht.demo.Service;

import com.hht.demo.Bean.Doc;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface DocService {
    public List<Doc> selectall(String username);
    public List<Doc> selectdocbyname(String username);
    public List<Doc> selectshare(String isshare);
    public void deldoc(int id);
    public String upload(MultipartFile file, HttpSession session);
    public void updateshare(int id);
}
