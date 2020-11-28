package com.example.demo.domain.service;



import com.example.demo.domain.Technical;
import com.example.demo.domain.repository.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicalService {

    @Autowired
    private TechnicalRepository technicalRepository;

    public List<Technical> getAll(){
        return technicalRepository.getAll();
    }

    public Optional<Technical> getTechnical(int technicalId){return technicalRepository.getTechnical(technicalId);
    }

     public Technical save(Technical technical){
        return technicalRepository.save(technical);
    }

    public boolean delete(int technicalId){

        return getTechnical(technicalId)
                .map( technical -> {
                    technicalRepository.delete(technicalId);
                    return true;
                }).orElse(false);
    }

}
