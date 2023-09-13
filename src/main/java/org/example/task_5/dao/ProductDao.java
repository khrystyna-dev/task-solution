package org.example.task_5.dao;

import org.example.task_5.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<Product> findProductWithNameBeginsWithC();

    Optional<Product> findProductWithSmallestPrice();

    List<Product> findAllProductsPriceFromUSA();

    Product add(Product product);

    void addAll(List<Product> products);
}
