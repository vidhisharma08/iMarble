package com.imarble.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.imarble.dto.SalesItemsDto;
import com.imarble.entities.Product;
import com.imarble.entities.Sales;
import com.imarble.entities.SalesItems;
import com.imarble.mapper.SalesItemsMapper;
import com.imarble.repos.ProductRepository;
import com.imarble.repos.SalesItemsRepository;
import com.imarble.repos.SalesRepository;

@Service
public class SalesItemsService {

    @Autowired
    private SalesItemsRepository salesItemsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;

    public SalesItemsDto createSalesItem(SalesItemsDto dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Sales sales = salesRepository.findById(dto.getSalesId())
                .orElseThrow(() -> new RuntimeException("Sales not found"));

        SalesItems salesItem = SalesItemsMapper.toEntity(dto, product, sales);
        return SalesItemsMapper.toDto(salesItemsRepository.save(salesItem));
    }

    
    public SalesItemsDto getSalesItemById(Long id) {
        SalesItems salesItem = salesItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SalesItem not found"));
        return SalesItemsMapper.toDto(salesItem);
    }

    
    public List<SalesItemsDto> getAllSalesItems() {
        return salesItemsRepository.findAll()
                .stream()
                .map(SalesItemsMapper::toDto)
                .collect(Collectors.toList());
    }

    
    public SalesItemsDto updateSalesItem(Long id, SalesItemsDto dto) {
        SalesItems existing = salesItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SalesItem not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Sales sales = salesRepository.findById(dto.getSalesId())
                .orElseThrow(() -> new RuntimeException("Sales not found"));

        existing.setProduct(product);
        existing.setSales(sales);
        existing.setQuantity(dto.getQuantity());
        existing.setAmount(dto.getAmount());

        return SalesItemsMapper.toDto(salesItemsRepository.save(existing));
    }

    
    public void deleteSalesItem(Long id) {
        salesItemsRepository.deleteById(id);
    }
}
