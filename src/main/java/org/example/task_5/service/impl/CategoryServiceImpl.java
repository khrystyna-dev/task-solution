package org.example.task_5.service.impl;

import org.example.task_5.dao.CategoryDao;
import org.example.task_5.model.Category;
import org.example.task_5.service.CategoryService;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public void addAll(List<Category> categories) {
        categoryDao.addAll(categories);
    }

    @Override
    public Category get(Long id) {
        return categoryDao.get(id).orElseThrow(() ->
                new RuntimeException("Couldn't get category by id " + id));
    }
}
