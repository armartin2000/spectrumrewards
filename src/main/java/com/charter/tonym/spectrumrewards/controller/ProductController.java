package com.charter.tonym.spectrumrewards.controller;

import com.charter.tonym.spectrumrewards.model.Product;
import com.charter.tonym.spectrumrewards.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
