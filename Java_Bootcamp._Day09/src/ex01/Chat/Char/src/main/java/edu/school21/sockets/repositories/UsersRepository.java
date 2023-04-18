package edu.school21.sockets.repositories;

import java.util.Optional;

public interface UsersRepository<T> extends CrudRepository{
    Optional<T> findByName(String name);
}

