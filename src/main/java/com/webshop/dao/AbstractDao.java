package com.webshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

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

    public void delete(PK id)
    {
        getEntityManager().remove(getByKey(id));
    }

    public void update(T entity)
    {
        getEntityManager().merge(entity);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll()
    {
        return getEntityManager().createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
    }

    protected CriteriaQuery<T> createEntityCriteria()
    {
        return getCriteriaBuilder().createQuery(persistentClass);
    }

    protected CriteriaBuilder getCriteriaBuilder()
    {
        return getEntityManager().getCriteriaBuilder();
    }
}
