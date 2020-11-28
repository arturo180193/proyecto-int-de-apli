package com.example.demo.domain.repository;



import com.example.demo.domain.Report;

import java.util.List;
import java.util.Optional;

public interface ReportRepository {

    List<Report> getAll();
    Optional<Report> getReport(int reportId);
    Report save(Report report);
    void delete(int reportId);

}
