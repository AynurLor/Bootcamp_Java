package school21.spring.service.repositories;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UsersRepositoryJdbcImpl implements UsersRepository{
    private DataSource ds;

    public UsersRepositoryJdbcImpl(hikariDS dataSource) {
        this.ds = new HikariDataSource(dataSource.dataSource);
    }

    @Override
    public Optional findById(Long id) {
        Optional<User> optionalUser = null;
        try {

        Connection connection = ds.getConnection();

        Statement statement = connection.createStatement();

        String query = "Select * from User where id = " + id;

        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        optionalUser = Optional.of(new User(resultSet.getLong(1), resultSet.getString(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return optionalUser;

    }

    @Override
    public List<User> findAll() {
        List<User> users = null;
        try (Connection connection = ds.getConnection()) {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM User1");
            users = new ArrayList<>();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String email = rs.getString("email");
                User user = new User(id, email);
                users.add(user);
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    @Override
    public void save(Object object) {
        User user = (User)object;
        String querySave = "insert into User1(identifier, email) values ('" +
                user.getIdentifier() + "', " +user.getEmail() + ");";

        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(querySave, Statement.RETURN_GENERATED_KEYS))
        {
            statement.execute();

            ResultSet key = statement.getGeneratedKeys();
            key.next();
            user.setIdentifier(key.getLong(1));
            user.setEmail(key.getString(2));
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public void update(Object entity) {
        User user = (User)entity;
        String querySave = "update User1 " +
                "set Email = " + "'" + user.getEmail() + "' " +
                "where id= " + user.getIdentifier() + ";";
        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(querySave))
        {
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long id) {
        String querySave = "DELETE from User1 where identifier = " + id;

        if (findById(id).isPresent()) {
            try (Connection connection = ds.getConnection();
                 PreparedStatement statement = connection.prepareStatement(querySave)) {
                statement.execute();

            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }

    }
    //    Identifier = identifier;
    //    Email = email;
    @Override
    public Optional findByEmail(String email) {
        Optional<User> optionalUser = null;
        try {

            Connection connection = ds.getConnection();

            Statement statement = connection.createStatement();

            String query = "Select * from User1 where email = '" + email + "'";

            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            optionalUser = Optional.of(new User(resultSet.getLong(1), resultSet.getString(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return optionalUser;
    }
    public static class hikariDS {
        public HikariDataSource dataSource = null;
        public hikariDS() {
            dataSource = new HikariDataSource();
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5433/postgres");
            dataSource.setUsername("postgres");
            dataSource.setPassword("");
        }

    }
}
