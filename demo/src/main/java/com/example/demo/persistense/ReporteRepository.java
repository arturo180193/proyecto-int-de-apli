package com.example.demo.persistense;

import com.example.demo.domain.Report;
import com.example.demo.domain.repository.ReportRepository;
import com.example.demo.persistense.crud.ReporteCrudRepository;
import com.example.demo.persistense.entity.Reporte;
import com.example.demo.persistense.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReporteRepository implements ReportRepository {

    @Autowired
    private ReporteCrudRepository reporteCrudRepository;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<Report> getAll() {
        List<Reporte> reportes = (List<Reporte>) reporteCrudRepository.findAll();
        return reportMapper.toReports(reportes);
    }



    @Override
    public Optional<Report> getReport(int reportId) {
        return reporteCrudRepository.findById(reportId)
                .map(reporte -> reportMapper.toReport(reporte));
    }

    @Override
    public Report save(Report report) {
        Reporte reporte = reportMapper.toReporte(report);
        return reportMapper.toReport(reporteCrudRepository.save(reporte));
    }

    @Override
    public void delete(int reportId) {
        reporteCrudRepository.deleteById(reportId);
    }
}

