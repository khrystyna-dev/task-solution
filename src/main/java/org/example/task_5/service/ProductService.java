package org.example.task_5.service;

import org.example.task_5.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findProductWithNameBeginsWithC();

    Product findProductWithSmallestPrice();

    List<Product> findAllProductsPriceFromUSA();

    Product add(Product product);

    void addAll(List<Product> products);
}
