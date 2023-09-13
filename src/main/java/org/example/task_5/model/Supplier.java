package org.example.task_5.model;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "supplier_name")
    private String supplierName;
    private String city;
    private String country;

    public Supplier() {
    }

    public Supplier(Long id, String supplierName, String city, String country) {
        this.id = id;
        this.supplierName = supplierName;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Supplier{"
                + "id=" + id
                + ", supplierName='" + supplierName + '\''
                + ", city='" + city + '\''
                + ", country='" + country + '\''
                + '}';
    }
}
