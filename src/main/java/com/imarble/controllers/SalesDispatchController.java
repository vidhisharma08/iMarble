package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.SalesDispatchDto;
import com.imarble.services.SalesDispatchService;

@RestController
@RequestMapping("/api/sales-dispatch")
public class SalesDispatchController {

    @Autowired
    private SalesDispatchService dispatchService;

    @PostMapping("/add")
    public SalesDispatchDto createDispatch(@RequestBody SalesDispatchDto dto) {
        return dispatchService.createDispatch(dto);
    }

    @GetMapping("/get/{id}")
    public SalesDispatchDto getDispatch(@PathVariable("id") Long id) {
        return dispatchService.getDispatchById(id);
    }

    @GetMapping("/getall")
    public List<SalesDispatchDto> getAllDispatches() {
        return dispatchService.getAllDispatches();
    }

    @PutMapping("/update/{id}")
    public SalesDispatchDto updateDispatch(@PathVariable("id") Long id, @RequestBody SalesDispatchDto dto) {
        return dispatchService.updateDispatch(id, dto);
    }

    @DeleteMapping("/del/{id}")
    public String deleteDispatch(@PathVariable("id") Long id) {
        dispatchService.deleteDispatch(id);
        return ("Sales Dispatch deleted successfully");
    }
}
