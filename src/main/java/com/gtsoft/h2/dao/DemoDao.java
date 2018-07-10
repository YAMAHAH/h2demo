package com.gtsoft.h2.dao;

import com.gtsoft.h2.model.TestModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoDao extends CrudRepository<TestModel, Long> {
    TestModel findByName(String name);
}
