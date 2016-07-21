package com.webshop.model.product;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "PURCHASE_ITEM")
class PurchaseItem implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    private Purchase purchase;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    private Product product;

    @Column(name = "NUMBER_OF_ITEMS")
    private int numberOfItems;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    public Purchase getPurchase()
    {
        return purchase;
    }

    public void setPurchase(Purchase purchase)
    {
        this.purchase = purchase;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public int getNumberOfItems()
    {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems)
    {
        this.numberOfItems = numberOfItems;
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
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

        PurchaseItem that = (PurchaseItem) o;

        if (numberOfItems != that.numberOfItems)
        {
            return false;
        }
        if (purchase != null ? !purchase.equals(that.purchase) : that.purchase != null)
        {
            return false;
        }
        if (product != null ? !product.equals(that.product) : that.product != null)
        {
            return false;
        }
        return totalPrice != null ? totalPrice.equals(that.totalPrice) : that.totalPrice == null;

    }

    @Override
    public int hashCode()
    {
        int result = purchase != null ? purchase.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + numberOfItems;
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "PurchaseItem{" +
                "purchase=" + purchase +
                ", product=" + product +
                ", numberOfItems=" + numberOfItems +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
