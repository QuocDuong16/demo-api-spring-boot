package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        // Tìm kiếm sản phẩm theo id trong danh sách products
        return products.stream()
                       .filter(product -> product.getId().equals(id))
                       .findFirst()
                       .orElse(null);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        // Thêm sản phẩm mới vào danh sách products
        products.add(product);
        return product;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        // Cập nhật sản phẩm trong danh sách products
        products.replaceAll(product -> {
            if (product.getId().equals(id)) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
            }
            return product;
        });
        return updatedProduct;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        // Xóa sản phẩm khỏi danh sách products
        products.removeIf(product -> product.getId().equals(id));
    }
}
