package org.example.task_5.dao.impl;

import org.example.task_5.dao.ProductDao;
import org.example.task_5.exception.DataProcessingException;
import org.example.task_5.model.Product;
import org.example.task_5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> findProductWithNameBeginsWithC() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("from Product p "
                    + "join fetch p.supplier s "
                    + "join fetch p.category c "
                    + "where p.productName LIKE 'C%'", Product.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't find products with product name that begins with ‘C’", e);
        }
    }

    @Override
    public Optional<Product> findProductWithSmallestPrice() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("from Product p "
                    + "join fetch p.supplier s "
                    + "join fetch p.category c "
                    + "order by p.price", Product.class);
            return query.setMaxResults(1).uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't find product with the smallest price", e);
        }
    }

    @Override
    public List<Product> findAllProductsPriceFromUSA() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("from Product p "
                    + " join fetch p.supplier s "
                    + " join fetch p.category c "
                    + "where p.supplier.country = 'USA'", Product.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't find cost of all products from the USA", e);
        }
    }

    @Override
    public Product add(Product product) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            return product;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Couldn't insert product " + product, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void addAll(List<Product> products) {
        products.forEach(this::add);
    }
}
