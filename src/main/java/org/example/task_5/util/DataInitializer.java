package org.example.task_5.util;

import org.example.task_5.model.Category;
import org.example.task_5.model.Product;
import org.example.task_5.model.Supplier;
import org.example.task_5.service.CategoryService;
import org.example.task_5.service.ProductService;
import org.example.task_5.service.SupplierService;
import java.math.BigDecimal;
import java.util.List;

public class DataInitializer {
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    private final ProductService productService;

    public DataInitializer(CategoryService categoryService, SupplierService supplierService, ProductService productService) {
        this.categoryService = categoryService;
        this.supplierService = supplierService;
        this.productService = productService;
    }

    public void inject() {
        // Insert data into Suppliers table
        List<Supplier> suppliers = List.of(new Supplier(1L, "Exotic Liquid", "London", "UK"),
                new Supplier(2L, "New Orleans Cajun Delights", "New Orleans", "USA"),
                new Supplier(3L, "Grandma Kelly’s Homestead", "Ann Arbor", "USA"),
                new Supplier(4L, "Tokyo Traders", "Tokyo", "Japan"),
                new Supplier(5L, "Cooperativa de Quesos ‘Las Cabras’", "Oviedo", "Spain"));
        supplierService.addAll(suppliers);

        // Insert data into Categories table
        List<Category> categories = List.of(new Category(1L, "Beverages", "Soft drinks, coffees, teas, beers, and ales"),
                new Category(2L, "Condiments", "Sweet and savory sauces, relishes, spreads, and seasonings"),
                new Category(3L, "Confections", "Desserts, candies, and sweet breads"),
                new Category(4L, "Dairy Products", "Cheeses"),
                new Category(5L, "Grains/Cereals", "Breads, crackers, pasta, and cereal"));
        categoryService.addAll(categories);

        // Insert data into Products table
        List<Product> products = List.of(new Product(1L, "Chais", supplierService.get(1L), categoryService.get(1L), BigDecimal.valueOf(18.00)),
                new Product(2L, "Chang", supplierService.get(1L), categoryService.get(1L), BigDecimal.valueOf(19.00)),
                new Product(3L, "Aniseed Syrup", supplierService.get(1L), categoryService.get(2L), BigDecimal.valueOf(10.00)),
                new Product(4L, "Chef Anton’s Cajun Seasoning", supplierService.get(2L), categoryService.get(2L), BigDecimal.valueOf(22.00)),
                new Product(5L, "Chef Anton’s Gumbo Mix", supplierService.get(2L), categoryService.get(2L), BigDecimal.valueOf(21.35)));
        productService.addAll(products);
    }
}