package com.webshop.dao;

import com.webshop.model.Product;
import org.springframework.stereotype.Repository;

public interface ProductDao
{
    Product findById(int id);
    void saveProduct(Product user);
}
