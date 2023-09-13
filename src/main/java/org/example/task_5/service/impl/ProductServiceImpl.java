package org.example.task_5.service.impl;

import org.example.task_5.dao.ProductDao;
import org.example.task_5.model.Product;
import org.example.task_5.service.ProductService;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findProductWithNameBeginsWithC() {
        return productDao.findProductWithNameBeginsWithC();
    }

    @Override
    public Product findProductWithSmallestPrice() {
        return productDao.findProductWithSmallestPrice().orElseThrow(() ->
                new NoSuchElementException("Couldn't find product with the smallest price"));
    }

    @Override
    public List<Product> findAllProductsPriceFromUSA() {
        return productDao.findAllProductsPriceFromUSA();
    }

    @Override
    public Product add(Product product) {
        return productDao.add(product);
    }

    @Override
    public void addAll(List<Product> products) {
        productDao.addAll(products);
    }
}
