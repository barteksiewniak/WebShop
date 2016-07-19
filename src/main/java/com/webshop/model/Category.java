package com.webshop.model;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
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

        Category category = (Category) o;

        if (id != category.id)
        {
            return false;
        }
        return categoryName != null ? categoryName.equals(category.categoryName) : category.categoryName == null;

    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}