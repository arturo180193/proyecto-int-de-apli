package com.example.demo.domain.service;


import com.example.demo.domain.Report;
import com.example.demo.domain.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAll(){ return reportRepository.getAll();
    }

    public Optional<Report> getReport(int reportId){return reportRepository.getReport(reportId); }


     public Report save(Report report){
        return reportRepository.save(report);
    }

    public boolean delete(int reportId){

        return getReport(reportId)
                .map( report -> {
                    reportRepository.delete(reportId);
                    return true;
                }).orElse(false);
    }

}
