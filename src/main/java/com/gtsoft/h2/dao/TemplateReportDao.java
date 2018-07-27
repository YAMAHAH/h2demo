package com.gtsoft.h2.dao;

import com.gtsoft.h2.model.TemplateReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "TemplateReports",collectionResourceRel = "TemplateReports")
public interface TemplateReportDao extends JpaRepository<TemplateReport,Long> {

    TemplateReport findByTemplateIdAndReportName(@Param("templateId") String templateId,@Param("reportName")String reportName);

    List<TemplateReport> findAllByTemplateId(@Param("templateId") String templateId);
}
