package com.webshop.service;

import com.webshop.model.Product;

import java.util.List;

public interface ProductService
{
    Product findById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    List<Product> listOfProducts();
    void removeProduct(int id);
}
