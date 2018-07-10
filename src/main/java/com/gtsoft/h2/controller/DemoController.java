package com.gtsoft.h2.controller;

import com.gtsoft.h2.dao.DemoDao;
import com.gtsoft.h2.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DemoController {

    @Autowired
    private DemoDao demoDao;

    @RequestMapping("save")
    public String save() {
        TestModel demoInfo = new TestModel();
        demoInfo.setName("张三");
        demoInfo.setAge(20);
        demoDao.save(demoInfo);

        demoInfo = new TestModel();
        demoInfo.setName("李四");
        demoInfo.setAge(30);
        demoDao.save(demoInfo);

        return "ok";
    }

    @RequestMapping("find")
    public List<TestModel> find() {
        return (List<TestModel>) demoDao.findAll();
    }

    @RequestMapping("findByName")
    public TestModel findByName() {
        return demoDao.findByName("张三");
    }
}

