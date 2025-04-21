package com.app.stream.producer.controller;

import com.app.stream.producer.model.Product;
import com.app.stream.producer.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.slf4j.Logger;

@RestController
@RequestMapping(value="/api/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value="/greeting")
    public String greeting(){
        return "All Good";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        Product product1 = this.productService.createProduct(product);
        return new ResponseEntity(product1, HttpStatus.NO_CONTENT);
    }
}
