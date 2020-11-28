package com.example.demo.persistense.mapper;


import com.example.demo.domain.Technical;
import com.example.demo.persistense.entity.Tecnico;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnicalMapper {

    @Mappings({
            @Mapping(source = "idTecnico", target = "technicalId"),
            @Mapping(source = "tipo", target = "type"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "direccion", target = "address"),
    })
    Technical toTechnical(Tecnico tecnico);
    List<Technical> toTechnicals(List<Tecnico> tecnicos);

    @InheritInverseConfiguration
    Tecnico toTecnico(Technical technical);
}



