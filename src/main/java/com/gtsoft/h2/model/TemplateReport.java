package com.gtsoft.h2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TemplateReport {

    @Id
    @GeneratedValue
    private long reportId;

    @Column
    private String templateId;
    @Column
    private String fullPath;
    @Column
    private String reportName;
    @Column
    private byte[] reportData;

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public byte[] getReportData() {
        return reportData;
    }

    public void setReportData(byte[] reportData) {
        this.reportData = reportData;
    }
}

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="parent_id")
//    private Organization parent;
//
//    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    @JoinColumn(name="parent_id")
//    private Set<Organization> children = new HashSet<>();