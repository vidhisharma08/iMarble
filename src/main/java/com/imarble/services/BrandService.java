package com.imarble.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.imarble.dto.BrandDto;
import com.imarble.entities.Brand;
import com.imarble.mapper.BrandMapper;
import com.imarble.repos.BrandRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandDto createBrand(BrandDto dto) {
        if (brandRepository.existsByTitle(dto.getTitle())) {
            throw new RuntimeException("Brand with this title already exists");
        }
        Brand brand = BrandMapper.toEntity(dto);
        return BrandMapper.toDto(brandRepository.save(brand));
    }

    public BrandDto getBrandById(Long id) {
        return brandRepository.findById(id)
                .map(BrandMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(BrandMapper::toDto)
                .collect(Collectors.toList());
    }

    public BrandDto updateBrand(Long id, BrandDto dto) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        brand.setTitle(dto.getTitle());
        brand.setImage(dto.getImage());
        brand.setStatus(dto.getStatus());

        return BrandMapper.toDto(brandRepository.save(brand));
    }

    public void deleteBrand(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new RuntimeException("Brand not found");
        }
        brandRepository.deleteById(id);
    }
}
