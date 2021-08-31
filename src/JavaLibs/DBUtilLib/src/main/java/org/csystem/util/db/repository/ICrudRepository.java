package org.csystem.util.db.repository;


import org.csystem.util.Optional;

public interface ICrudRepository<T, ID> {
    <S extends T> S save(S s);
    <S extends T> Iterable<S> saveAll(Iterable<S> ss);
    Optional<T> findById(ID id);
    boolean existsById(ID var1);
    Iterable<T> findAll();
    Iterable<T> findAllById(Iterable<ID> ids);
    long count();
    void deleteById(ID id);
    void delete(T t);
    void deleteAll(Iterable<? extends T> ts);
    void deleteAll();
}
