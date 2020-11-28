package com.example.demo.persistense.mapper;

import com.example.demo.domain.Report;
import com.example.demo.persistense.entity.Reporte;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface ReportMapper {


    @Mappings({
            @Mapping(source = "idReporte", target = "reportId"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "localizacion", target = "location"),
            @Mapping(source = "estado", target = "status"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "idTecnico", target = "technicalId"),

    })
    Report toReport(Reporte reporte
    );
    List<Report> toReports(List<Reporte> reportes);

    @InheritInverseConfiguration
        Reporte toReporte(Report report);


}
