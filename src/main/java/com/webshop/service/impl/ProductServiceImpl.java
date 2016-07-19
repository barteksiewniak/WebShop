package com.webshop.service.impl;

import com.webshop.dao.ProductDao;
import com.webshop.model.Product;
import com.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(int id)
    {
        return productDao.findById(id);
    }

    @Override
    public void saveProduct(Product product)
    {
        productDao.saveProduct(product);
    }
}
