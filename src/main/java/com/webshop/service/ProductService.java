package com.webshop.service;

import com.webshop.model.Product;

public interface ProductService
{
    Product findById(int id);
    void saveProduct(Product product);
}
