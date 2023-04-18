package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component("usersRepository")
public class UsersRepositoryImpl implements UsersRepository{
    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findById(Long id) {
        return  Optional.of(jdbcTemplate.query("Select * from User1 where id = ?",
                        new Object[]{id}, (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2) ))
                .stream().findAny().orElse(null));
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from User1", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2)));
    }

    @Override
    public void save(Object entity) {
        User user = (User)entity;
        jdbcTemplate.update("insert into User1 (name, password) value (?), (?)", user.getUserName(), user.getPassword());
    }

    @Override
    public void update(Object entity) {
        User user = (User)entity;
        jdbcTemplate.update("update User1 set name = ?, password=? where id = ?", user.getUserName(), user.getPassword(), user.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from User1 where id=?", id);
    }

    @Override
    public Optional findByName(String email) {
        return Optional.of(jdbcTemplate.query("Select * from User1 where name = ?",
                        new Object[]{email}, (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2) ))
                .stream().findAny().orElse(null));
    }

}
