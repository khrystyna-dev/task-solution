package org.example.task_5.dao;

import org.example.task_5.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    Category add(Category category);

    void addAll(List<Category> categories);

    Optional<Category> get(Long id);
}
