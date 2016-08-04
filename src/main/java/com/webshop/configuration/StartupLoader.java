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

        if (categoryService.listOfCategories().size() < 1)
        {
            populateCategory().forEach(s -> categoryService.saveCategory(s));
        }

        if (productService.listOfProducts().size() < 1)
        {
            populateProduct().forEach(s -> productService.addProduct(s));
        }

    }

    private List<Category> populateCategory()
    {
        List<Category> list = new ArrayList<>();
        list.add(new Category("GPU"));
        list.add(new Category("Monitor"));
        list.add(new Category("CPU"));
        return list;
    }

    private List<Product> populateProduct()
    {
        List<Product> list = new ArrayList<>();
        list.add(new Product("MSI GF GTX 970 4GB DDR5 256bit PCI-e GAMING", new BigDecimal(1359), categoryService.findByName("GPU")));
        list.add(new Product("MSI GF GTX 1070 Gaming X 8GB GDDR5 256bit PCI-e", new BigDecimal(2299), categoryService.findByName("GPU")));
        list.add(new Product("Gigabyte GF GTX 750Ti 2048MB 128bit PCI-E OC", new BigDecimal(549), categoryService.findByName("GPU")));
        list.add(new Product("MONITOR AOC LED 23\" I2369VM", new BigDecimal(585), categoryService.findByName("Monitor")));
        list.add(new Product("LG 21,5 22MP58VQ-P LED IPS HDMI DVI wide", new BigDecimal(499), categoryService.findByName("Monitor")));
        list.add(new Product("EIZO 24 CS240-BK Black", new BigDecimal(2945), categoryService.findByName("Monitor")));
        list.add(new Product("AMD X6 FX-6300 s.AM3+ BOX.", new BigDecimal(459), categoryService.findByName("CPU")));
        list.add(new Product("Intel Core i5-4460 3,2 GHz 6MB cache s. 1150 Box", new BigDecimal(755), categoryService.findByName("CPU")));
        list.add(new Product("Intel Core i7-4790 3,6 GHz 8MB cache s. 1150 Box", new BigDecimal(1399), categoryService.findByName("CPU")));
        return list;
    }

    private List<UserProfile> populateUserProfile()
    {
        List<UserProfile> list = new ArrayList<>();
        list.add(new UserProfile("ADMIN"));
        list.add(new UserProfile("DB"));
        list.add(new UserProfile("USER"));
        return list;
    }


}
