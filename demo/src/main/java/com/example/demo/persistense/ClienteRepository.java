package com.example.demo.persistense;


import com.example.demo.domain.Client;
import com.example.demo.domain.repository.ClientRepository;
import com.example.demo.persistense.crud.ClienteCrudRepository;
import com.example.demo.persistense.entity.Cliente;
import com.example.demo.persistense.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {


        @Autowired
        private ClienteCrudRepository clienteCrudRepository;

        @Autowired
        private ClientMapper clientMapper;

        @Override
        public List<Client> getAll() { List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
            return clientMapper.toClients(clientes);
        }

        @Override
        public Optional<Client> getClient(int clientId) {
            return clienteCrudRepository.findById(clientId).map(cliente -> clientMapper.toClient(cliente));
        }

        @Override
        public Client save(Client client) {
            Cliente cliente = clientMapper.toCliente(client);
            return clientMapper.toClient(clienteCrudRepository.save(cliente));
        }

        @Override
        public void delete(int clientId) {
            clienteCrudRepository.deleteById(clientId);
        }


}
