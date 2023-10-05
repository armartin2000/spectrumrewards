package com.charter.tonym.spectrumrewards.service;

import com.charter.tonym.spectrumrewards.model.Product;
import com.charter.tonym.spectrumrewards.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(productRepository.findAll());
    }
}
