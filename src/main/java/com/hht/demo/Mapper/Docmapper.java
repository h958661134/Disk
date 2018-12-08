package com.hht.demo.Mapper;

import com.hht.demo.Bean.Doc;

import java.util.List;

public interface Docmapper {

    public List<Doc> selectalluser(String username);
    public List<Doc> selectdocbyname(String username);
    public List<Doc> selectallshare(String isshare);
    public void deldoc(int id);
    public void insert(Doc doc);
    public Doc selectOneFileByFileName(String fileName);
    public void updateshare(int id);
}
