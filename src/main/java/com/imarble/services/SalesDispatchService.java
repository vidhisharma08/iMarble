package com.imarble.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.imarble.dto.SalesDispatchDto;
import com.imarble.entities.Sales;
import com.imarble.entities.SalesDispatch;
import com.imarble.entities.Staff;
import com.imarble.mapper.SalesDispatchMapper;
import com.imarble.repos.SalesDispatchRepository;
import com.imarble.repos.SalesRepository;
import com.imarble.repos.StaffRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalesDispatchService {

    private final SalesDispatchRepository dispatchRepo;
    private final StaffRepository staffRepo;
    private final SalesRepository salesRepo;

    
    public SalesDispatchDto createDispatch(SalesDispatchDto dto) {
        Staff dispatcher = staffRepo.findById(dto.getDispatcherId())
                .orElseThrow(() -> new RuntimeException("Dispatcher not found"));
        Sales sales = salesRepo.findById(dto.getSalesId())
                .orElseThrow(() -> new RuntimeException("Sales not found"));
        SalesDispatch dispatch = SalesDispatchMapper.toEntity(dto, dispatcher, sales);
        return SalesDispatchMapper.toDto(dispatchRepo.save(dispatch));
    }

    
    public SalesDispatchDto getDispatchById(Long disid) {
        SalesDispatch dispatch = dispatchRepo.findById(disid)
                .orElseThrow(() -> new RuntimeException("Dispatch not found"));
        return SalesDispatchMapper.toDto(dispatch);
    }

    
    public List<SalesDispatchDto> getAllDispatches() {
        return dispatchRepo.findAll().stream()
                .map(SalesDispatchMapper::toDto)
                .collect(Collectors.toList());
    }

    
    public SalesDispatchDto updateDispatch(Long disid, SalesDispatchDto dto) {
        SalesDispatch existing = dispatchRepo.findById(disid)
                .orElseThrow(() -> new RuntimeException("Dispatch not found"));
        Staff dispatcher = staffRepo.findById(dto.getDispatcherId())
                .orElseThrow(() -> new RuntimeException("Dispatcher not found"));
        Sales sales = salesRepo.findById(dto.getSalesId())
                .orElseThrow(() -> new RuntimeException("Sales not found"));

        existing.setDispatcher(dispatcher);
        existing.setSales(sales);
        existing.setDate(dto.getDate() != null ? dto.getDate() : existing.getDate());

        return SalesDispatchMapper.toDto(dispatchRepo.save(existing));
    }

    
    public void deleteDispatch(Long disid) {
        SalesDispatch existing = dispatchRepo.findById(disid)
                .orElseThrow(() -> new RuntimeException("Dispatch not found"));
        dispatchRepo.delete(existing);
    }
}
