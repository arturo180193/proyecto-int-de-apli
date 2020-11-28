package com.example.demo.domain.repository;


import com.example.demo.domain.Technical;

import java.util.List;
import java.util.Optional;

public interface TechnicalRepository {

    List<Technical> getAll();
    Optional<Technical> getTechnical(int technicalId);
    Technical save(Technical technical);
    void delete(int technicalId);

}
