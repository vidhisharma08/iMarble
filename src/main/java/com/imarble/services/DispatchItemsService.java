package com.imarble.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarble.dto.DispatchItemsDto;
import com.imarble.entities.DispatchItems;
import com.imarble.entities.SalesDispatch;
import com.imarble.entities.SalesItems;
import com.imarble.mapper.DispatchItemsMapper;
import com.imarble.repos.DispatchItemsRepository;
import com.imarble.repos.SalesDispatchRepository;
import com.imarble.repos.SalesItemsRepository;

@Service
public class DispatchItemsService {
    @Autowired
    private DispatchItemsRepository dispatchItemsRepository;

    @Autowired
    private SalesDispatchRepository dispatchRepository;

    @Autowired
    private SalesItemsRepository salesItemsRepository;

    public DispatchItems createDispatchItem(DispatchItemsDto dto) {
        SalesDispatch dispatch = dispatchRepository.findById(dto.getDispatchId())
                .orElseThrow(() -> new RuntimeException("Dispatch not found with id " + dto.getDispatchId()));

        SalesItems salesItem = salesItemsRepository.findById(dto.getSalesItemId())
                .orElseThrow(() -> new RuntimeException("Sales item not found with id " + dto.getSalesItemId()));

        DispatchItems entity = DispatchItemsMapper.toEntity(dto, dispatch, salesItem);
        return dispatchItemsRepository.save(entity);
    }

    public List<DispatchItems> getAllDispatchItems() {
        return dispatchItemsRepository.findAll();
    }

    public List<DispatchItems> getDispatchItemsByDispatch(Long dispatchId) {
        SalesDispatch dispatch = dispatchRepository.findById(dispatchId)
                .orElseThrow(() -> new RuntimeException("Dispatch not found with id " + dispatchId));
        return dispatchItemsRepository.findByDispatch(dispatch);
    }

    public DispatchItems updateDispatchItem(Long id, DispatchItemsDto dto) {
        DispatchItems existing = dispatchItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispatch item not found with id " + id));

        SalesDispatch dispatch = dispatchRepository.findById(dto.getDispatchId())
                .orElseThrow(() -> new RuntimeException("Dispatch not found with id " + dto.getDispatchId()));

        SalesItems salesItem = salesItemsRepository.findById(dto.getSalesItemId())
                .orElseThrow(() -> new RuntimeException("Sales item not found with id " + dto.getSalesItemId()));

        existing.setDispatch(dispatch);
        existing.setSalesItem(salesItem);
        existing.setQuantity(dto.getQuantity());

        return dispatchItemsRepository.save(existing);
    }

    public void deleteDispatchItem(Long id) {
        if (!dispatchItemsRepository.existsById(id)) {
            throw new RuntimeException("Dispatch item not found with id " + id);
        }
        dispatchItemsRepository.deleteById(id);
    }
}
