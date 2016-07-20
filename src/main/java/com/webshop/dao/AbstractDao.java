package com.webshop.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao<PK extends Serializable, T>
{
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao()
    {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager()
    {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key)
    {
        return getEntityManager().find(persistentClass, key);
    }

    public void persist(T entity)
    {
        getEntityManager().persist(entity);
    }

    public void delete(T entity)
    {
        getEntityManager().remove(entity);
    }

    protected CriteriaQuery<T> createEntityCriteria()
    {
        return getCriteriaBuilder().createQuery(persistentClass);
    }

    protected CriteriaBuilder getCriteriaBuilder() {
        return entityManager.getCriteriaBuilder();
    }
}
