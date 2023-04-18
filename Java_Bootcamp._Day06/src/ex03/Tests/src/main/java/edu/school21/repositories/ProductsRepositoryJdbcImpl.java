package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository{
    private final DataSource ds;

    public ProductsRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        Optional<Product> optionalProduct;

        Connection connection = ds.getConnection();

        Statement statement = connection.createStatement();

        String query = "Select * from product";

        ResultSet resultSet = statement.executeQuery(query);
//        resultSet.next();
        while (resultSet.next()) {
            productList.add(new Product(resultSet.getLong("id"), resultSet.getString("name"),
                    resultSet.getLong("price")));
        }

        return productList;
    }

    @Override
    public Optional<Product> findById(Long id) throws SQLException {
        Optional<Product> optionalProduct;

        Connection connection = ds.getConnection();

        Statement statement = connection.createStatement();

        String query = "Select * from product where id= " + id;

        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet == null) return null;
        resultSet.next();


        optionalProduct = Optional.ofNullable(new Product(resultSet.getLong("id"),
                resultSet.getString("name"), resultSet.getLong("price")));

        return optionalProduct;

    }

    @Override
    public void update(Product product) {
        String querySave = "update product " +
                "set name = " + "'" + product.getName() + "', " +
                "price = " + product.getPrice() +
                "where id= " + product.getId() + ";";
        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(querySave))
        {
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(Product product) {
        String querySave = "insert into product(name, price) values ('" +
                product.getName() + "', " + product.getPrice() + ");";

        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(querySave, Statement.RETURN_GENERATED_KEYS))
        {
            statement.execute();

            ResultSet key = statement.getGeneratedKeys();
            key.next();
            product.setId(key.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public void delete(Long id) throws SQLException {
        String querySave = "DELETE from product where id = " + id;

        if (findById(id).isPresent()) {
            try (Connection connection = ds.getConnection();
                 PreparedStatement statement = connection.prepareStatement(querySave)) {
                statement.execute();

            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
    }
}
