package com.imarble.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarble.dto.MissingItemsDto;
import com.imarble.entities.MissingItems;
import com.imarble.entities.Product;
import com.imarble.mapper.MissingItemsMapper;
import com.imarble.repos.MissingItemRepository;
import com.imarble.repos.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MissingItemsService {
    @Autowired
    private MissingItemRepository missingItemsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MissingItemsMapper mapper;

    public MissingItemsDto addMissingItem(MissingItemsDto dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + dto.getProductId()));

        MissingItems entity = mapper.toEntity(dto, product);
        return mapper.toDto(missingItemsRepository.save(entity));
    }

    public List<MissingItemsDto> getAllMissingItems() {
        return missingItemsRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

 
    public MissingItemsDto getMissingItemById(Long id) {
        MissingItems entity = missingItemsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Missing Item not found with ID: " + id));
        return mapper.toDto(entity);
    }


    public MissingItemsDto updateMissingItem(Long id, MissingItemsDto dto) {
        MissingItems existing = missingItemsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Missing Item not found with ID: " + id));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + dto.getProductId()));

        existing.setQty(dto.getQty());
        existing.setDescription(dto.getDescription());
        existing.setType(dto.getType());
        existing.setProduct(product);

        return mapper.toDto(missingItemsRepository.save(existing));
    }

 
    public void deleteMissingItem(Long id) {
        if (!missingItemsRepository.existsById(id)) {
            throw new EntityNotFoundException("Missing Item not found with ID: " + id);
        }
        missingItemsRepository.deleteById(id);
    }
}
