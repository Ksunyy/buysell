package com.app.buysell.services;

import com.app.buysell.models.Product;
import com.app.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        else return productRepository.findAll();
    }
    public void saveProduct(Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product GetProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
