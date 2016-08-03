package com.webshop.controller;

import com.webshop.model.product.Category;
import com.webshop.model.product.Product;
import com.webshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController
{
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listOfProducts(Model model)
    {
        model.addAttribute("product", new Product());
        model.addAttribute("listOfProducts", productService.listOfProducts());
        return "products";
    }

    @RequestMapping(value = "product/{id}", method=RequestMethod.GET)
    public String getProductById(Model model, @PathVariable int id){
        model.addAttribute("product", productService.findById(id));
        return "product";
    }

    @RequestMapping(value = "products/{category}", method=RequestMethod.GET)
    public String getProductByCategory(Model model, @PathVariable Category category)
    {
        model.addAttribute("product", new Product());
        model.addAttribute("listOfProducts", productService.findByCategory(category));
        return "products";
    }
}
