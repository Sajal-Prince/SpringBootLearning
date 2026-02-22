package com.example.start1.Services;

import com.example.start1.DTO.ProductRequestDTO;
import com.example.start1.Entities.ProductEntity;
import com.example.start1.Exceptions.ProductNotFound;
import com.example.start1.Repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service

public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    private ProductEntity convertToEntity(ProductRequestDTO productRequestDTO){
        return modelMapper.map(productRequestDTO, ProductEntity.class);
    }

    private ProductRequestDTO convertToDto(ProductEntity productEntity){
        return modelMapper.map(productEntity, ProductRequestDTO.class);
    }


    public void addProducts(ProductRequestDTO prod){
        productRepository.save(convertToEntity(prod));
        System.out.println("The product was added lmaoooooo.....");
    }

    public List<ProductRequestDTO> getProducts(){
        return productRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Transactional
    public void updateProduct(Integer id) {
            ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ProductNotFound("The product with such id is not found"));
            productEntity.setQuantity(productEntity.getQuantity()-1);
            System.out.println("product updated my nigga wigga");
    }

}
