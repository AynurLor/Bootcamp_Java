package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoryJdbcImplTest {
    ProductsRepository productsRepository;
    EmbeddedDatabase database;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "potato", 100L),
            new Product(2L, "milk", 50L),
            new Product(3L, "cheese", 300L),
            new Product(4L, "tomato", 200L),
            new Product(5L, "courage", 999L)
    );
//    insert into product(name, price) values ('potato', 100);
//    insert into product(name, price) values ('milk', 50);
//    insert into product(name, price) values ('cheese', 300);
//    insert into product(name, price) values ('tomato', 200);
//    insert into product(name, price) values ('courage', 999);
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(2L, "milk", 50L);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(3L, "TEA", 150L);
    final Product EXPECTED_SAVED_PRODUCT = new Product(6L, "CHEESE", 250L);
    final Product EXPECTED_DELETE_PRODUCT = new Product(6L, "CHEESE", 250L);

    @BeforeEach
    void init() {
        database = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(database);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(5, productsRepository.findAll().size());
    }
    @Test
    void testFindById() throws SQLException {
//        Assertions.assertEquals();
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, productsRepository.findById(2L).get());
    }
    @Test
    void testUpdate() throws SQLException {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT.getName(), productsRepository.findById(3L).get().getName());
    }
    @Test
    void testSave() throws SQLException {
        productsRepository.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(EXPECTED_SAVED_PRODUCT.getName(), productsRepository.findById(6L).get().getName());
    }
    @Test
    void testDelete() throws SQLException {
        productsRepository.delete(5L);
        Assertions.assertTrue(productsRepository.findById(4L).isPresent());
    }

}
