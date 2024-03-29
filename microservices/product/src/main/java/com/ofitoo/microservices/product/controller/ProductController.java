package com.ofitoo.microservices.product.controller;


import com.ofitoo.microservices.product.model.dto.CreateProductDto;
import com.ofitoo.microservices.product.model.dto.ProductDto;
import com.ofitoo.microservices.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody final CreateProductDto createProductDto, @RequestHeader("userId") final Long userId) {
        final ProductDto product = productService.createProduct(createProductDto, userId);

        return ResponseEntity.ok().body(product);
    }
}
