package com.example.demo.persistense;

import com.example.demo.domain.Technical;
import com.example.demo.domain.repository.TechnicalRepository;
import com.example.demo.persistense.crud.TecnicoCrudRepository;
import com.example.demo.persistense.entity.Tecnico;
import com.example.demo.persistense.mapper.TechnicalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TecnicoRepository implements TechnicalRepository {

    @Autowired
    private TecnicoCrudRepository tecnicoCrudRepository;

    @Autowired
    private TechnicalMapper technicaltMapper;

    @Override
    public List<Technical> getAll() {
        List<Tecnico> tecnicos = (List<Tecnico>) tecnicoCrudRepository.findAll();
        return technicaltMapper.toTechnicals(tecnicos);
    }


    @Override
    public Optional<Technical> getTechnical(int technicalId) {
        return tecnicoCrudRepository.findById(technicalId)
                .map(tecnico -> technicaltMapper.toTechnical(tecnico));
    }

    @Override
    public Technical save(Technical technical) {
        Tecnico tecnico = technicaltMapper.toTecnico(technical);
        return technicaltMapper.toTechnical(tecnicoCrudRepository.save(tecnico));
    }

    @Override
    public void delete(int technicalId) {
        tecnicoCrudRepository.deleteById(technicalId);
    }


}
