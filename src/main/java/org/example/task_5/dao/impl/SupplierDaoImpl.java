package org.example.task_5.dao.impl;

import org.example.task_5.dao.SupplierDao;
import org.example.task_5.exception.DataProcessingException;
import org.example.task_5.model.Category;
import org.example.task_5.model.Product;
import org.example.task_5.model.Supplier;
import org.example.task_5.util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class SupplierDaoImpl implements SupplierDao {

    @Override
    public List<Supplier> findSuppliersThatSupplyCondiments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Supplier> query = session.createQuery("from Supplier s "
                            + "where s.id in( "
                            + "select distinct p.supplier.id "
                            + "from Product p "
                            + "join p.category c "
                            + "where c.categoryName = 'Condiments')", Supplier.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't find suppliers that supply Condiments", e);
        }
    }

    @Override
    public Supplier addNewSupplier() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Supplier newSupplier = new Supplier();
            newSupplier.setSupplierName("Norske Meierier");
            newSupplier.setCity("Lviv");
            newSupplier.setCountry("Ukraine");

            session.save(newSupplier);

            // Fetch the 'Beverages' category from the database
            Category category = session.createQuery("from Category "
                            + "where categoryName = :categoryName", Category.class)
                    .setParameter("categoryName", "Beverages")
                    .getSingleResult();

            // Create a new product 'Green tea' related to 'Beverages' category and 'Norske Meierier' supplier
            Product newProduct = new Product();
            newProduct.setProductName("Green tea");
            newProduct.setPrice(BigDecimal.valueOf(10.0));
            newProduct.setCategory(category);
            newProduct.setSupplier(newSupplier);

            session.save(newProduct);
            transaction.commit();
            return newSupplier;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Couldn't add new supplier", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Supplier add(Supplier supplier) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(supplier);
            transaction.commit();
            return supplier;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Couldn't insert supplier " + supplier, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void addAll(List<Supplier> suppliers) {
        suppliers.forEach(this::add);
    }

    @Override
    public Optional<Supplier> get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Supplier where id = :id", Supplier.class)
                    .setParameter("id", id)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get supplier by id: " + id, e);
        }
    }
}