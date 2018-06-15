package edu.uade.appl_interact.data_access.dao;

import java.util.List;

public interface GenericDao<T> {

    T findById(Integer id) throws Exception;

    T findBy(String field, String value) throws Exception;

    int create(T t) throws Exception;

    int update(T t) throws Exception;

    void delete(Integer id) throws Exception;

    List<T> findManyBy(String field, String value) throws Exception;

    List<T> findManyLike(String field, String value) throws Exception;
}
