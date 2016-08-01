package com.webshop.configuration;

import com.webshop.model.product.Category;
import com.webshop.model.product.Product;
import com.webshop.model.user.User;
import com.webshop.model.user.UserProfile;
import com.webshop.service.product.CategoryService;
import com.webshop.service.product.ProductService;
import com.webshop.service.user.UserProfileService;
import com.webshop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class StartupLoader
{

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserProfileService userProfileService;

    @PostConstruct
    void checkDefault()
    {
        if (userProfileService.list().isEmpty())
        {
            populateUserProfile().forEach(s -> userProfileService.addUserProfile(s));
        }

        User user = userService.findBySso("admin");
        if (user == null)
        {
            user = new User();
            user.setFirstName("Default");
            user.setEmail("admin@webshop.com");
            user.setLastName("Default");
            user.setPassword("password");
            user.setSsoId("admin");
            userService.saveUser(user, "ADMIN");
        }

        if (categoryService.listOfCategories().size() < 4)
        {
            populateCategory().forEach(s -> categoryService.saveCategory(s));
        }

        if (productService.listOfProducts().size() < 5)
        {
            populateProduct().forEach(s -> productService.addProduct(s));
        }

    }

    private List<Category> populateCategory()
    {
        List<Category> list = new ArrayList<>(5);
        list.add(new Category("Food"));
        list.add(new Category("Electronics"));
        list.add(new Category("Furniture"));
        list.add(new Category("Clothes"));
        list.add(new Category("Books"));
        return list;
    }

    private List<Product> populateProduct()
    {
        List<Product> list = new ArrayList<>(5);
        list.add(new Product("Milk", new BigDecimal(2.50), categoryService.findByName("Food")));
        list.add(new Product("Phone", new BigDecimal(699.99), categoryService.findByName("Electronics")));
        list.add(new Product("Tomato", new BigDecimal(1.30), categoryService.findByName("Food")));
        list.add(new Product("Laptop", new BigDecimal(3800), categoryService.findByName("Electronics")));
        list.add(new Product("Bed 200x220", new BigDecimal(1200), categoryService.findByName("Furniture")));
        list.add(new Product("Table 150x200", new BigDecimal(300), categoryService.findByName("Furniture")));
        list.add(new Product("SSD 256GB", new BigDecimal(478), categoryService.findByName("Electronics")));
        list.add(new Product("Skirt", new BigDecimal(50), categoryService.findByName("Clothes")));
        list.add(new Product("Nineteen Eighty-Four G. Orwell", new BigDecimal(10), categoryService.findByName("Books")));
        return list;
    }

    private List<UserProfile> populateUserProfile()
    {
        List<UserProfile> list = new ArrayList<>(3);
        list.add(new UserProfile("ADMIN"));
        list.add(new UserProfile("DB"));
        list.add(new UserProfile("USER"));
        return list;
    }


}
