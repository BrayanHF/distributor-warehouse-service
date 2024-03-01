package com.distributor.warehouse.service;

import com.distributor.warehouse.entity.Category;
import com.distributor.warehouse.entity.Status;
import com.distributor.warehouse.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    //! ERROR: Categories with the same name are being saved
    public Category addCategory(Category category) {
        try {
            return categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Ya existe una categoría con el mismo nombre.");
        }
    }

    public boolean deleteCategoryById(long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            optionalCategory.get().setStatus(Status.DELETED);
            try {
                categoryRepository.save(optionalCategory.get());
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            throw new RuntimeException("No se puede eliminar la categoría porque no existe.");
        }
    }

}