package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository{
    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(JDBCGenerator dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource.managerDataSource);
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
        jdbcTemplate.update("insert into User1 (email) value (?)", user.getEmail());
    }

    @Override
    public void update(Object entity) {
        User user = (User)entity;
        jdbcTemplate.update("update User1 set email = ? where id = ?", user.getEmail(), user.getIdentifier());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from User1 where id=?", id);
    }

    @Override
    public Optional findByEmail(String email) {
        return Optional.of(jdbcTemplate.query("Select * from User1 where email = ?",
                        new Object[]{email}, (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2) ))
                .stream().findAny().orElse(null));
    }
    public static class JDBCGenerator {
        public DriverManagerDataSource managerDataSource;

        public JDBCGenerator() {
            managerDataSource = new DriverManagerDataSource();
            Properties properties = new Properties();
            try {
                properties.load(UsersRepositoryJdbcTemplateImpl.class.getClassLoader().getResourceAsStream("db.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            managerDataSource.setDriverClassName(properties.getProperty("db.driver.name"));
            managerDataSource.setUrl(properties.getProperty("db.url"));
            managerDataSource.setUsername(properties.getProperty("db.user"));
            managerDataSource.setPassword(properties.getProperty("db.password"));
        }
    }
}
