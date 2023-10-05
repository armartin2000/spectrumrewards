package com.charter.tonym.spectrumrewards.service;

import com.charter.tonym.spectrumrewards.model.Product;
import reactor.core.publisher.Flux;

public interface ProductService {

    Flux<Product> getAllProducts();
}
