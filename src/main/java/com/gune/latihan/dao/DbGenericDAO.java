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
/**
 *
 * @author Bni
 */
public interface DbGenericDAO<T, ID extends Serializable> {

    public EntityManager getEntityManager();

    public void persist(T entity) throws Exception;

    public void merge(T entity) throws Exception;

    public T findById(Class<T> entityClass,ID id) throws Exception;

    public void delete(T entity) throws Exception;

    public void deleteById(Class<T> entityClass, ID id) throws Exception;

    List<T> findByNamedQuery(final String queryName,Object...params);

    List<T> findByNamedQueryAndParams(final String queryName,final Map<String,? extends Object> params);
    
    List<T> findByNamedQuery(final String queryName);

    T findByNamedQueryUniqueResult(final String queryName,Object...params);

    T findByNamedQueryAndParamsUniqueResult(final String queryName,final Map<String,? extends Object> params); 
    
    void mergePerTransaction(T entity) throws Exception;
    
    public void batchInsert(final List<T> entities) throws Exception;
}
