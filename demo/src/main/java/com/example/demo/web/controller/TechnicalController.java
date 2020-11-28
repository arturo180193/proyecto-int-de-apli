package com.example.demo.web.controller;


import com.example.demo.domain.Technical;
import com.example.demo.domain.service.TechnicalService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technicals")
public class TechnicalController {
    @Autowired
    private TechnicalService technicalService;

    @GetMapping("/all")
    @ApiOperation(value = "Get all supermarket technicals", authorizations = { @Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Technical>> getAll(){
        return new ResponseEntity<>(technicalService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Search a technical with an ID", authorizations = { @Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "technical not found")
    })
    public ResponseEntity<Technical> getTechnical(  @ApiParam(value = "The id of the technical", required = true, example = "1")
                                              @PathVariable int id){

        return technicalService.getTechnical(id)
                .map(technical -> new ResponseEntity<>(technical, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Technical> save(@RequestBody Technical technical){
        return new ResponseEntity<Technical>(technicalService.save(technical), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){

        if(technicalService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
