package com.example.demo.web.controller;

import com.example.demo.domain.Client;
import com.example.demo.domain.service.ClientService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    @ApiOperation(value = "Get all supermarket clients", authorizations = { @Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Search a client with an ID", authorizations = { @Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "client not found")
    })
    public ResponseEntity<Client> getClient(  @ApiParam(value = "The id of the client", required = true, example = "1")
                                              @PathVariable int id){

        return clientService.getClient(id)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<Client>(clientService.save(client), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){

        if(clientService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


}
