package edu.school21.sockets.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    Optional<T> findById(Long id) throws SQLException;
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(Long id);


}
