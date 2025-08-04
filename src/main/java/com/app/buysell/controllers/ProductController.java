package com.app.buysell.controllers;


import com.app.buysell.models.Product;
import com.app.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.PublicKey;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    } - решается с помощью аннотации requieredArgsConstructor (Lombok)
    @GetMapping("/")
    public String products(Model model){
        model.addAttribute("products", productService.listProducts());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable long id, Model model){
        model.addAttribute("product", productService.GetProductById(id));

        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
