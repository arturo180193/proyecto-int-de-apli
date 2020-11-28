package com.example.demo.persistense.mapper;

import com.example.demo.domain.Report;
import com.example.demo.persistense.entity.Reporte;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-28T01:41:33-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Amazon.com Inc.)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public Report toReport(Reporte reporte) {
        if ( reporte == null ) {
            return null;
        }

        Report report = new Report();

        if ( reporte.getFecha() != null ) {
            report.setDate( Date.from( reporte.getFecha().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        report.setClientId( reporte.getIdCliente() );
        if ( reporte.getIdReporte() != null ) {
            report.setReportId( reporte.getIdReporte() );
        }
        report.setDescription( reporte.getDescripcion() );
        report.setLocation( reporte.getLocalizacion() );
        report.setTechnicalId( reporte.getIdTecnico() );
        if ( reporte.getEstado() != null ) {
            report.setStatus( reporte.getEstado() );
        }

        return report;
    }

    @Override
    public List<Report> toReports(List<Reporte> reportes) {
        if ( reportes == null ) {
            return null;
        }

        List<Report> list = new ArrayList<Report>( reportes.size() );
        for ( Reporte reporte : reportes ) {
            list.add( toReport( reporte ) );
        }

        return list;
    }

    @Override
    public Reporte toReporte(Report report) {
        if ( report == null ) {
            return null;
        }

        Reporte reporte = new Reporte();

        reporte.setDescripcion( report.getDescription() );
        if ( report.getDate() != null ) {
            reporte.setFecha( LocalDateTime.ofInstant( report.getDate().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        reporte.setEstado( report.isStatus() );
        reporte.setIdCliente( report.getClientId() );
        reporte.setLocalizacion( report.getLocation() );
        reporte.setIdReporte( report.getReportId() );
        reporte.setIdTecnico( report.getTechnicalId() );

        return reporte;
    }
}
