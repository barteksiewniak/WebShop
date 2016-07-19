package com.webshop.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public BigDecimal getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Product product = (Product) o;

        if (id != product.id)
        {
            return false;
        }
        if (productName != null ? !productName.equals(product.productName) : product.productName != null)
        {
            return false;
        }
        if (unitPrice != null ? !unitPrice.equals(product.unitPrice) : product.unitPrice != null)
        {
            return false;
        }
        return category != null ? category.equals(product.category) : product.category == null;

    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
