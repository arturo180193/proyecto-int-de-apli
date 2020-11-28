package com.example.demo.domain;

import java.util.Date;

public class Report {

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTechnicalId() {
        return technicalId;
    }

    public void setTechnicalId(int technicalId) {
        this.technicalId = technicalId;
    }

    private int reportId;
    private String description;
    private String location;
    private boolean status;
    private Date date;
    private int clientId;
    private int technicalId;



}
