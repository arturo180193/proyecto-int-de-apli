package com.example.demo.persistense.mapper;

import com.example.demo.domain.Technical;
import com.example.demo.persistense.entity.Tecnico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-28T01:17:10-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Amazon.com Inc.)"
)
@Component
public class TechnicalMapperImpl implements TechnicalMapper {

    @Override
    public Technical toTechnical(Tecnico tecnico) {
        if ( tecnico == null ) {
            return null;
        }

        Technical technical = new Technical();

        technical.setAddress( tecnico.getDireccion() );
        technical.setType( tecnico.getTipo() );
        technical.setPhone( tecnico.getTelefono() );
        if ( tecnico.getIdTecnico() != null ) {
            technical.setTechnicalId( tecnico.getIdTecnico() );
        }
        technical.setEmail( tecnico.getCorreo() );

        return technical;
    }

    @Override
    public List<Technical> toTechnicals(List<Tecnico> tecnicos) {
        if ( tecnicos == null ) {
            return null;
        }

        List<Technical> list = new ArrayList<Technical>( tecnicos.size() );
        for ( Tecnico tecnico : tecnicos ) {
            list.add( toTechnical( tecnico ) );
        }

        return list;
    }

    @Override
    public Tecnico toTecnico(Technical technical) {
        if ( technical == null ) {
            return null;
        }

        Tecnico tecnico = new Tecnico();

        tecnico.setTipo( technical.getType() );
        tecnico.setCorreo( technical.getEmail() );
        tecnico.setDireccion( technical.getAddress() );
        tecnico.setTelefono( technical.getPhone() );
        tecnico.setIdTecnico( technical.getTechnicalId() );

        return tecnico;
    }
}
