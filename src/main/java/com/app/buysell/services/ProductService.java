package com.app.buysell.services;

import com.app.buysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private int id = 0;

    {
        products.add(new Product(++id, "iphone", "sell", 1000, "NN", "Ksuny"));
        products.add(new Product(++id, "iphone2", "sell", 12000, "NN2", "Ksuny2"));

    }

    public List<Product> listProducts() {
        return products;
    }
    public void saveProduct(Product product) {
        product.setId(++id);
        products.add(product);
    }
    public void deleteProduct(long id) {
        products.removeIf(product-> product.getId() == id);
    }

    public Product GetProductById(long id) {
        for (Product product: products) {
            if (product.getId() == id) return product;
        }
        return null;
    }
}
