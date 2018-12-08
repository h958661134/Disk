package com.hht.demo.Controller;

import com.hht.demo.Bean.Doc;
import com.hht.demo.Service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class DocController {
    @Autowired
    private DocService docService;

    @RequestMapping("/doc/selectall")
    public List<Doc> selectall(HttpSession session){
        System.out.println("session+"+(String)session.getAttribute("username"));
        return docService.selectall((String)session.getAttribute("username"));
    }

    @RequestMapping("/doc/selectshare")
    public List<Doc> selectshare(String share){
        return docService.selectshare(share);
    }

    @RequestMapping("/doc/deldoc")
    public void del(int id){
        docService.deldoc(id);
    }

    @RequestMapping("/doc/exit")
    public void exit(HttpSession session){
        session.invalidate();
    }

    @RequestMapping("/doc/filename")
    public void filename(HttpSession session,String filename){
        session.setAttribute("filename",filename);
    }

    @RequestMapping("/doc/updateshare")
    public void updateshare(int id){
        docService.updateshare(id);
    }

    @RequestMapping("/doc/selectbyname")
    public List<Doc> selectbyname(String username){
        return docService.selectdocbyname(username);
    }
}
