package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.PurchaseDao;
import com.webshop.model.Purchase;
import org.springframework.stereotype.Repository;

@Repository("purchaseDao")
public class PurchaseDaoImpl extends AbstractDao<Integer, Purchase> implements PurchaseDao
{
    @Override
    public void savePurchase(Purchase purchase)
    {
        persist(purchase);
    }
}
