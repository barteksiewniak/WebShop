package com.webshop.controller;

import com.webshop.model.product.Category;
import com.webshop.model.product.Product;
import com.webshop.service.product.CategoryService;
import com.webshop.service.product.ProductService;
import com.webshop.validator.ProductFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductFormValidator productValidator;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String adminPage(ModelMap model)
    {
        return "admin/admin";
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listOfProducts(@ModelAttribute("product") Product product, Model model)
    {
        model.addAttribute("showAddNewProductModule", true);
        model.addAttribute("listOfCategories", categoryService.listOfCategories());
        model.addAttribute("listOfProducts", productService.listOfProducts());
        return "/admin/products";
    }

    @RequestMapping(value = "products", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") @Validated Product product, BindingResult result, SessionStatus status, Model model)
    {
        productValidator.validate(product, result);
        if (result.hasErrors())
        {
            model.addAttribute("showAddNewProductModule", true);
            model.addAttribute("listOfCategories", categoryService.listOfCategories());
            model.addAttribute("listOfProducts", productService.listOfProducts());
            return "/admin/products";
        }

        product.setCategory(categoryService.findByName(product.getCategory().getCategoryName()));
        productService.addProduct(product);
        status.setComplete();
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "products/remove/{id}", method = RequestMethod.GET)
    public String removeProduct(@PathVariable int id)
    {
        productService.removeProduct(id);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "products/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@ModelAttribute("product") Product product,
                              @PathVariable int id, Model model)
    {
        model.addAttribute("IdOfProductToEdit", id);
        model.addAttribute("listOfCategories", categoryService.listOfCategories());
        model.addAttribute("listOfProducts", productService.listOfProducts());
        return "/admin/products";
    }

    @RequestMapping(value = "products/edit/{id}", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product,
                              @PathVariable int id, BindingResult result, SessionStatus status, Model model)
    {
        productValidator.validate(product, result);
        if (result.hasErrors())
        {   //Do I really need to use model again? Maybe there is a way to use GET method which does exactly the same?
            //Tried to 'return "redirect:/admin/products/edit" + id', but then errors won't show up
            model.addAttribute("IdOfProductToEdit", id);
            model.addAttribute("listOfCategories", categoryService.listOfCategories());
            model.addAttribute("listOfProducts", productService.listOfProducts());
            return "/admin/products";
        }
        Product productToEdit = productService.findById(id);
        productToEdit.setProductName(product.getProductName());
        productToEdit.setUnitPrice(product.getUnitPrice());
        productToEdit.setCategory(categoryService.findByName(product.getCategory().getCategoryName()));
        productService.updateProduct(productToEdit);
        status.setComplete();
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "categories/add", method = RequestMethod.POST)
    @ResponseBody
    public void addCategory(@ModelAttribute("category") Category category)
    {
        if (!category.getCategoryName().isEmpty())
            categoryService.saveCategory(category);
    }

    @RequestMapping(value = "categories/remove/{categoryName}", method = RequestMethod.POST)
    @ResponseBody
    public List<Product> removeCategory(@PathVariable String categoryName, @RequestParam String remove)
    {
        List<Product> relatedProducts = productService.findByCategory(categoryName);
        if (Integer.parseInt(remove) == 1)
        {
            productService.removeProducts(relatedProducts);
            categoryService.removeCategory(categoryService.findByName(categoryName));
        }
        return relatedProducts;
    }

}
