/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gune.latihan.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class JpaDAO<T, ID extends Serializable> implements DbGenericDAO<T, ID> {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(JpaDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(T entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }

    public void merge(T entity) throws Exception {
        entityManager.merge(entity);
    }

    public T findById(Class<T> entityClass, ID id) throws Exception {
        T o = null;
        try {
            o = (T) entityManager.find(entityClass, id);
        } catch (NoResultException e) {
            o=null;
        }
        return o;

    }

    public void delete(T entity) throws Exception {
        entityManager.remove(entity);
    }

    public void deleteById(Class<T> entityClass, ID id) throws Exception {
        entityManager.remove(findById(entityClass, id));
    }

    public List<T> findByNamedQuery(String queryName, Object... params) {
        Query query = getEntityManager().createNamedQuery(queryName);
        for(int i=0;i<params.length;i++){
            query.setParameter(i+1, params[i]);
        }
        final List<T> result = (List<T>) query.getResultList();
        return result;
    }

    public List<T> findByNamedQueryAndParams(String queryName, Map<String, ? extends Object> params) {
        Query query = getEntityManager().createNamedQuery(queryName);
        for(final Map.Entry<String,? extends Object>param:params.entrySet()){
            query.setParameter(param.getKey(), param.getValue());
        }
        final List<T> result = (List<T>) query.getResultList();
        return result;
    }

    public List<T> findByNamedQuery(String queryName) 
    {
        Query query = getEntityManager().createNamedQuery(queryName);

        final List<T> result = (List<T>) query.getResultList();
        
        return result;
    }
    
    public T findByNamedQueryUniqueResult(String queryName, Object... params) {
        Query query = getEntityManager().createNamedQuery(queryName);
        for(int i=0;i<params.length;i++){
            query.setParameter(i, params[i]);
        }
        final T result = (T) query.getSingleResult();
        return result;
    }

    public T findByNamedQueryAndParamsUniqueResult(String queryName, Map<String, ? extends Object> params) {
        Query query = getEntityManager().createNamedQuery(queryName);
        for(final Map.Entry<String,? extends Object>param:params.entrySet()){
            query.setParameter(param.getKey(), param.getValue());
        }
        T result = null;
        try {
        	result = (T) query.getSingleResult();			
		} catch (Exception e) {
			LOG.debug(e.getMessage());
		}
        return result;
    }
    
    public void mergePerTransaction(T entity) throws Exception {
    	entityManager.merge(entity);
    	entityManager.flush();
    }

	@Override
	public void batchInsert(final List<T> entities) throws Exception {
		for(int i = 0;i < entities.size();i++) {
			T entity = entities.get(i);
			entityManager.persist(entity);
			if (i % 20 == 0) { // 20 disamakan dengan property JDBC batch size
				entityManager.flush();
				entityManager.clear();
			}
		}
	}    
   
}