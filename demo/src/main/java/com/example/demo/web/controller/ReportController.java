package com.example.demo.web.controller;

import com.example.demo.domain.Client;
import com.example.demo.domain.Report;
import com.example.demo.domain.service.ClientService;
import com.example.demo.domain.service.ReportService;
import com.example.demo.domain.service.TechnicalService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {


    @Autowired
    private ReportService reportService;


    
    @GetMapping("/all")
    @ApiOperation(value = "Get all supermarket reports", authorizations = { @Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Report>> getAll(){
        return new ResponseEntity<>(reportService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Search a report with an ID", authorizations = { @Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "report not found")
    })
    public ResponseEntity<Report> getReport(  @ApiParam(value = "The id of the report", required = true, example = "1")
                                                @PathVariable int id){

        return reportService.getReport(id)
                .map(report -> new ResponseEntity<>(report, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PostMapping("/save")
    public ResponseEntity<Report> save(@RequestBody Report report){
        return new ResponseEntity<Report>(reportService.save(report), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){

        if(reportService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
