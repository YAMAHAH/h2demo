package com.gtsoft.h2.controller;

import com.gtsoft.h2.dao.DemoDao;
import com.gtsoft.h2.model.Address;
import com.gtsoft.h2.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private DemoDao demoDao;
    @RequestMapping("/init")
    public String init() {
        TestModel demoInfo = new TestModel();
        demoInfo.setName("张三");
        demoInfo.setAge(20);
        Address address = new Address();
        address.setProvince("beijing");
        address.setCity("beijing");
        address.setPostcode("102002");
        address.setDetailAdress("beigjing hu 2343");
        demoInfo.setAddresses( new ArrayList<>(Arrays.asList(address)));
        demoDao.save(demoInfo);

        demoInfo = new TestModel();
        demoInfo.setName("李四");
        demoInfo.setAge(30);
        address = new Address();
        address.setProvince("beijing");
        address.setCity("beijing");
        address.setPostcode("102002");
        address.setDetailAdress("beigjing hu 2343");
        demoInfo.setAddresses( new ArrayList<>(Arrays.asList(address)));
        demoDao.save(demoInfo);

        return "ok";
    }

    @RequestMapping("/default")
    @ResponseBody
    public TestModel defaultModel(){
        TestModel demoInfo = new TestModel();
        demoInfo.setId(0L);
        demoInfo.setName("Input Name");
        demoInfo.setAge(0);
        Address address = new Address();
        address.setId(0L);
        address.setProvince("beijing");
        address.setCity("beijing");
        address.setPostcode("102002");
        address.setDetailAdress("beigjing hu 2343");
        demoInfo.setAddresses( new ArrayList<>(Arrays.asList(address)));
        return demoInfo;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Iterable<TestModel> save(@RequestBody List<TestModel> testModels) {
        return demoDao.saveAll(testModels);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/find")
    public List<TestModel> find() {
        return (List<TestModel>) demoDao.findAll();
    }

    @RequestMapping("/findByName")
    public TestModel findByName() {
        return demoDao.findByName("张三");
    }

    @RequestMapping("/deleteItem")
    public void deleteItem(@RequestParam("id") long id){
        demoDao.deleteById(id);
    }

    @RequestMapping("/deleteItems")
    public void deleteItems(@RequestBody List<TestModel> testModels){
        demoDao.deleteAll(testModels);
    }

    @RequestMapping("/findById")
    @ResponseBody
    public TestModel findById(@RequestParam("id") long id) {
        return demoDao.findById(id).get();
    }
}

