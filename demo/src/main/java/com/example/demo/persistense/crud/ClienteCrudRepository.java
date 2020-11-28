package com.example.demo.persistense.crud;


import com.example.demo.persistense.entity.Cliente;
import com.example.demo.persistense.entity.Reporte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClienteCrudRepository  extends CrudRepository<Cliente, Integer> {

    List<Cliente> findByIdClienteOrderByNombreAsc(int idCliente);
}
