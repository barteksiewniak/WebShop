package com.webshop.model;

import javax.persistence.*;

@Entity
@Table(name = "PURCHASE")
public class Purchase
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
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

        Purchase purchase = (Purchase) o;

        if (id != purchase.id)
        {
            return false;
        }
        return user != null ? user.equals(purchase.user) : purchase.user == null;

    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Purchase{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
