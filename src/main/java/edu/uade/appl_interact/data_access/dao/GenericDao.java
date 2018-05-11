package edu.uade.appl_interact.data_access.dao;

import java.util.List;

public interface GenericDao<T> {

    public T findById(Integer id) throws Exception;

    public T findBy(String field, String value) throws Exception;

    public void create(T t) throws Exception;

    public void update(T t) throws Exception;

    public void delete(Integer id) throws Exception;

    public List<T> findManyBy(String field, String value) throws Exception;

    public List<T> findManyLike(String field, String value) throws Exception;
}
