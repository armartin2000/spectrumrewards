package com.charter.tonym.spectrumrewards.repository;

import com.charter.tonym.spectrumrewards.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
