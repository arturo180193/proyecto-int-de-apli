package com.example.demo.persistense.crud;


import com.example.demo.persistense.entity.Reporte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReporteCrudRepository  extends CrudRepository<Reporte, Integer> {




}
