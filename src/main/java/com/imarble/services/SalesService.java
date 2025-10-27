package com.imarble.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.imarble.dto.SalesDto;
import com.imarble.entities.Branch;
import com.imarble.entities.Clients;
import com.imarble.entities.Sales;
import com.imarble.mapper.SalesMapper;
import com.imarble.repos.BranchRepository;
import com.imarble.repos.ClientRepository;
import com.imarble.repos.SalesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepo;
    private final ClientRepository clientRepo;
    private final BranchRepository branchRepo;

   
    public SalesDto createSales(SalesDto dto) {
        Clients client = clientRepo.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Branch branch = branchRepo.findById(dto.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        Sales sales = SalesMapper.toEntity(dto, client, branch);
        return SalesMapper.toDto(salesRepo.save(sales));
    }

   
    public SalesDto getSalesById(Long salesId) {
        return SalesMapper.toDto(salesRepo.findById(salesId)
                .orElseThrow(() -> new RuntimeException("Sales not found")));
    }

   
    public List<SalesDto> getAllSales() {
        return salesRepo.findAll()
                .stream()
                .map(SalesMapper::toDto)
                .collect(Collectors.toList());
    }

   
    public SalesDto updateSales(Long salesId, SalesDto dto) {
        Sales existing = salesRepo.findById(salesId)
                .orElseThrow(() -> new RuntimeException("Sales not found"));
        Clients client = clientRepo.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Branch branch = branchRepo.findById(dto.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        existing.setInvoiceNumber(dto.getInvoiceNumber());
        existing.setBillAmount(dto.getBillAmount());
        existing.setDate(dto.getDate());
        existing.setType(Sales.SalesType.valueOf(dto.getType()));
        existing.setStatus(Sales.SalesStatus.valueOf(dto.getStatus()));
        existing.setClient(client);
        existing.setBranch(branch);

        return SalesMapper.toDto(salesRepo.save(existing));
    }

 
    public void deleteSales(Long salesId) {
        Sales sales = salesRepo.findById(salesId)
                .orElseThrow(() -> new RuntimeException("Sales not found"));
        salesRepo.delete(sales);
    }
}
