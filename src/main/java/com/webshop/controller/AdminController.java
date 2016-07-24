package com.webshop.controller;


import com.webshop.model.product.Category;
import com.webshop.model.product.Product;
import com.webshop.service.product.CategoryService;
import com.webshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String adminPage(ModelMap model)
    {
        return "admin/admin";
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listOfProducts(@ModelAttribute("product") Product product, Model model)
    {
        model.addAttribute("categoryList", categoryService.list());
        model.addAttribute("listOfProducts", productService.listOfProducts());
        return "/admin/products";
    }

    @RequestMapping(value = "products", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result, SessionStatus status)
    {
        product.setCategory(categoryService.findByName(product.getCategory().getCategoryName()));
        productService.addProduct(product);
        status.setComplete();
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "products/{id}/remove", method = RequestMethod.GET)
    public String removeProduct(@PathVariable int id, Model model)
    {
        productService.removeProduct(id);
        return "redirect:/admin/products";
    }

    /*@RequestMapping(value = "products/{id}/edit", method = RequestMethod.GET)
    public String editProduct(@PathVariable int id, Model model)
    {

    }

    @RequestMapping(value = "products/create", method = RequestMethod.GET)
    public String createProduct(Model model)
    {

    }

    @RequestMapping(value = "products/create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") Product product,Model model)
    {

    }*/
}
