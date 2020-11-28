package com.example.demo.persistense.crud;



import com.example.demo.persistense.entity.Tecnico;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface TecnicoCrudRepository  extends CrudRepository<Tecnico, Integer> {


}
