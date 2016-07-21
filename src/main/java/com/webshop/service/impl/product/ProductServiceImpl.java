package com.webshop.service.impl.product;

import com.webshop.dao.ProductDao;
import com.webshop.model.product.Product;
import com.webshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void addProduct(Product product)
    {
        productDao.addProduct(product);
    }

    @Override
    public void updateProduct(Product product)
    {
        productDao.updateProduct(product);
    }

    @Override
    public List<Product> listOfProducts()
    {
        return productDao.listOfProducts();
    }

    @Override
    public void removeProduct(int id)
    {
        productDao.removeProduct(id);
    }
}
