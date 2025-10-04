package com.imarble.services;

import com.imarble.dto.PurchaseItemsDto;
import com.imarble.entities.Product;
import com.imarble.entities.Purchase;
import com.imarble.entities.PurchaseItems;
import com.imarble.mapper.PurchaseItemsMapper;
import com.imarble.repos.ProductRepository;
import com.imarble.repos.PurchaseItemsRepository;
import com.imarble.repos.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseItemsService {

    @Autowired
    private PurchaseItemsRepository purchaseItemsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    // Create new purchase item
    public PurchaseItemsDto createPurchaseItem(PurchaseItemsDto dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Purchase purchase = purchaseRepository.findById(dto.getPurchaseId())
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        PurchaseItems entity = PurchaseItemsMapper.toEntity(dto, product, purchase);

        PurchaseItems saved = purchaseItemsRepository.save(entity);
        return PurchaseItemsMapper.toDto(saved);
    }

    // Get purchase item by ID
    public PurchaseItemsDto getPurchaseItemById(Long id) {
        PurchaseItems entity = purchaseItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseItem not found"));
        return PurchaseItemsMapper.toDto(entity);
    }

    // Get all purchase items
    public List<PurchaseItemsDto> getAllPurchaseItems() {
        return purchaseItemsRepository.findAll()
                .stream()
                .map(PurchaseItemsMapper::toDto)
                .collect(Collectors.toList());
    }

    // Update purchase item
    public PurchaseItemsDto updatePurchaseItem(Long id, PurchaseItemsDto dto) {
        PurchaseItems entity = purchaseItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseItem not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Purchase purchase = purchaseRepository.findById(dto.getPurchaseId())
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        entity.setProduct(product);
        entity.setPurchase(purchase);
        entity.setQuantity(dto.getQuantity());
        entity.setAmount(dto.getAmount());

        PurchaseItems updated = purchaseItemsRepository.save(entity);
        return PurchaseItemsMapper.toDto(updated);
    }

    // Delete purchase item
    public void deletePurchaseItem(Long id) {
        PurchaseItems entity = purchaseItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseItem not found"));
        purchaseItemsRepository.delete(entity);
    }
}
