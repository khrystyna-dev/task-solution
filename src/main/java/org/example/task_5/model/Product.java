package org.example.task_5.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @JoinColumn(name = "supplier_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;
    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    private BigDecimal price;

    public Product() {
    }

    public Product(Long productId, String productName, Supplier supplier, Category category, BigDecimal price) {
        this.id = productId;
        this.productName = productName;
        this.supplier = supplier;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", productName='" + productName + '\''
                + ", supplier=" + supplier
                + ", category=" + category
                + ", price=" + price
                + '}';
    }
}
