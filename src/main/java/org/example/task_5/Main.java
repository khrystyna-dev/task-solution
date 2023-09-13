package org.example.task_5;

import org.example.task_5.dao.CategoryDao;
import org.example.task_5.dao.ProductDao;
import org.example.task_5.dao.SupplierDao;
import org.example.task_5.dao.impl.CategoryDaoImpl;
import org.example.task_5.dao.impl.ProductDaoImpl;
import org.example.task_5.dao.impl.SupplierDaoImpl;
import org.example.task_5.service.CategoryService;
import org.example.task_5.service.ProductService;
import org.example.task_5.service.SupplierService;
import org.example.task_5.service.impl.CategoryServiceImpl;
import org.example.task_5.service.impl.ProductServiceImpl;
import org.example.task_5.service.impl.SupplierServiceImpl;
import org.example.task_5.util.DataInitializer;

public class Main {
    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDaoImpl();
        SupplierDao supplierDao = new SupplierDaoImpl();
        ProductDao productDao = new ProductDaoImpl();

        CategoryService categoryService = new CategoryServiceImpl(categoryDao);
        SupplierService supplierService = new SupplierServiceImpl(supplierDao);
        ProductService productService = new ProductServiceImpl(productDao);

        DataInitializer dataInitializer = new DataInitializer(categoryService, supplierService, productService);
        dataInitializer.inject();

        System.out.println(supplierService.findSuppliersThatSupplyCondiments());
        System.out.println(supplierService.addNewSupplier());

        System.out.println(productService.findProductWithSmallestPrice());
        System.out.println(productService.findProductWithNameBeginsWithC());
        System.out.println(productService.findAllProductsPriceFromUSA());

    }
}