package com.example.start1.Controllers;

import com.example.start1.DTO.ProductRequestDTO;
import com.example.start1.Entities.ProductEntity;
import com.example.start1.Exceptions.ProductNotFound;
import com.example.start1.Repositories.ProductRepository;
import com.example.start1.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@Validated @RequestBody ProductRequestDTO productRequestDTO){
        productService.addProducts(productRequestDTO);
        return ResponseEntity.ok().body("Nigger u added it....");
    }

    @GetMapping("/products")
    public List<ProductRequestDTO> getProduct(){
        return productService.getProducts();
    }

    @PutMapping("/products/{id}/reduce")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id){
            productService.updateProduct(id);
            return ResponseEntity.ok().body("You updated it fuck ass");

    }
}
