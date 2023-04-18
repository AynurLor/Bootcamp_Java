package school21.spring.service.repositories;

import java.util.Optional;

public interface UsersRepository<T> extends CrudRepository{
    Optional<T> findByEmail(String email);
}
