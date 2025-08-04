package com.app.buysell.services;

import com.app.buysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "iphone", "sell", 1000, "NN", "Ksuny"));
        products.add(new Product(++ID, "iphone2", "sell", 12000, "NN2", "Ksuny2"));

    }

    public List<Product> listProducts() {
        return products;
    }
    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }
    public void deleteProduct(Long id) {
        products.removeIf(product-> product.getId().equals(id));
    }

    public Product GetProductById(Long id) {
        for (Product product: products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
