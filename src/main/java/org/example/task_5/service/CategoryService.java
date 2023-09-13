package org.example.task_5.service;

import org.example.task_5.model.Category;
import java.util.List;

public interface CategoryService {

    Category add(Category category);

    void addAll(List<Category> categories);

    Category get(Long id);
}
