package com.imarble.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarble.dto.StockTrackerDto;
import com.imarble.entities.Product;
import com.imarble.entities.StockTracker;
import com.imarble.mapper.StockTrackerMapper;
import com.imarble.repos.ProductRepository;
import com.imarble.repos.StockTrackerRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class StockTrackerService {
    @Autowired
    private StockTrackerRepository stockTrackerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockTrackerMapper mapper;

    
    public StockTrackerDto addStockTracker(StockTrackerDto dto) {
        Product product = productRepository.findById(dto.getProductId()).orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + dto.getProductId()));

        StockTracker entity = mapper.toEntity(dto, product);
        StockTracker saved = stockTrackerRepository.save(entity);
        return mapper.toDto(saved);
    }

    
    public List<StockTrackerDto> getAllStockTrackers() {
        return stockTrackerRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    
    public List<StockTrackerDto> getStockTrackersByProduct(Long productId) {
        return stockTrackerRepository.findByProductPid(productId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    
    public Integer getFinalStock(Long productId) {
        return stockTrackerRepository.calculateFinalStock(productId);
    }
}
