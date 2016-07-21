package com.webshop.controller;

import com.webshop.model.product.Product;
import com.webshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController
{
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listPersons(Model model)
    {
        model.addAttribute("product", new Product());
        model.addAttribute("listOfProducts", productService.listOfProducts());
        return "products";
    }
}
