package org.example.task_5.dao.impl;

import org.example.task_5.dao.CategoryDao;
import org.example.task_5.exception.DataProcessingException;
import org.example.task_5.model.Category;
import org.example.task_5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public Category add(Category category) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
            return category;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Couldn't insert category " + category, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void addAll(List<Category> categories) {
        categories.forEach(this::add);
    }

    @Override
    public Optional<Category> get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Category> query =  session.createQuery("from Category where id = :id", Category.class)
                    .setParameter("id", id);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get category by id: " + id, e);
        }
    }
}
