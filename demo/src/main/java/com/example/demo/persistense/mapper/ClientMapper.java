package com.example.demo.persistense.mapper;

import com.example.demo.domain.Client;
import com.example.demo.persistense.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "contrasena", target = "password"),
            @Mapping(source = "tarjeta", target = "creditcard"),
            @Mapping(source = "telefono", target = "phone"),

    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(Client client);


}


