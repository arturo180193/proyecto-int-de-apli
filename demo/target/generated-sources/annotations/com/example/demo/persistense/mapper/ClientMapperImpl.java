package com.example.demo.persistense.mapper;

import com.example.demo.domain.Client;
import com.example.demo.persistense.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-28T01:17:09-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Amazon.com Inc.)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toClient(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Client client = new Client();

        client.setPassword( cliente.getContrasena() );
        if ( cliente.getIdCliente() != null ) {
            client.setClientId( cliente.getIdCliente() );
        }
        client.setAddress( cliente.getDireccion() );
        client.setPhone( cliente.getTelefono() );
        client.setName( cliente.getNombre() );
        client.setCreditcard( cliente.getTarjeta() );
        client.setEmail( cliente.getCorreo() );

        return client;
    }

    @Override
    public List<Client> toClients(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( toClient( cliente ) );
        }

        return list;
    }

    @Override
    public Cliente toCliente(Client client) {
        if ( client == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setIdCliente( client.getClientId() );
        cliente.setCorreo( client.getEmail() );
        cliente.setDireccion( client.getAddress() );
        cliente.setContrasena( client.getPassword() );
        cliente.setTelefono( client.getPhone() );
        cliente.setTarjeta( client.getCreditcard() );
        cliente.setNombre( client.getName() );

        return cliente;
    }
}
