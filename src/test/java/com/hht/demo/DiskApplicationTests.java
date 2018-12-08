package com.hht.demo;

import com.hht.demo.Mapper.Docmapper;
import com.hht.demo.Mapper.Usermapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiskApplicationTests {

    @Autowired
    private Docmapper usermapper;
    @Test
    public void contextLoads() {
        System.out.println(usermapper.selectalluser("韩昊天").toString());
    }

}
