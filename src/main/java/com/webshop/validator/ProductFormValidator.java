package com.webshop.validator;

import com.webshop.model.product.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ProductFormValidator implements Validator
{
    private Pattern pattern;
    private Matcher matcher;

    private String PRICE_PATTERN = "[0-9]+([,\\.][0-9]{1,2})?";

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        ValidationUtils.rejectIfEmpty(errors, "productName", "error.productProductNameEmpty");
        ValidationUtils.rejectIfEmpty(errors, "unitPrice", "error.productUnitPriceEmpty");
        ValidationUtils.rejectIfEmpty(errors, "category", "error.productCategoryEmpty");

        Product product = (Product) target;

        if (product.getUnitPrice() != null)
        {
            pattern = Pattern.compile(PRICE_PATTERN);
            matcher = pattern.matcher(product.getUnitPrice().toString());
            if (!matcher.matches())
            {
                errors.rejectValue("unitPrice", "error.productUnitPriceWrong");
            }
        }
    }
}
