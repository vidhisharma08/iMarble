package com.imarble.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarble.dto.PurchaseDto;
import com.imarble.entities.Clients;
import com.imarble.entities.Purchase;
import com.imarble.mapper.PurchaseMapper;
import com.imarble.repos.ClientRepository;
import com.imarble.repos.PurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ClientRepository clientRepository;

    // Create Purchase
    public PurchaseDto createPurchase(PurchaseDto purchaseDto) {
        Clients client = clientRepository.findById(purchaseDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Purchase purchase = PurchaseMapper.toEntity(purchaseDto, client);
        Purchase savedPurchase = purchaseRepository.save(purchase);
        return PurchaseMapper.toDto(savedPurchase);
    }

    // Get Purchase by ID
    public PurchaseDto getPurchaseById(Long purchaseId) {
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
        return PurchaseMapper.toDto(purchase);
    }

    // Get all Purchases
    public List<PurchaseDto> getAllPurchases() {
        return purchaseRepository.findAll()
                .stream()
                .map(PurchaseMapper::toDto)
                .collect(Collectors.toList());
    }

    // Update Purchase
    public PurchaseDto updatePurchase(Long purchaseId, PurchaseDto purchaseDto) {
        Purchase existingPurchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        Clients client = clientRepository.findById(purchaseDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        existingPurchase.setBillAmount(purchaseDto.getBillAmount());
        existingPurchase.setInvoiceNumber(purchaseDto.getInvoiceNumber());
        existingPurchase.setDate(purchaseDto.getDate());
        existingPurchase.setClient(client);

        Purchase updatedPurchase = purchaseRepository.save(existingPurchase);
        return PurchaseMapper.toDto(updatedPurchase);
    }

    // Delete Purchase
    public void deletePurchase(Long purchaseId) {
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
        purchaseRepository.delete(purchase);
    }
}
