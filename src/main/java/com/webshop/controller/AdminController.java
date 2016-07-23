package com.webshop.controller;

import com.webshop.model.product.Product;
import com.webshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String adminPage(ModelMap model)
    {
        return "admin";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listOfProducts(Model model)
    {
        model.addAttribute("listOfProducts", productService.listOfProducts());
        return "admin/products";
    }

    //todo nie dziala
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String editProduct(@RequestParam String productID)
    {
        return "redirect:/admin/products/" + productID;
    }
    //todo nie dziala
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public String listOfProducts(@PathVariable int id, Model model)
    {
        model.addAttribute("product", productService.findById(id));
        return "admin/editProduct";
    }

}
