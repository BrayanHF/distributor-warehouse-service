package com.distributor.warehouse.controller;

import com.distributor.warehouse.entity.Category;
import com.distributor.warehouse.entity.Status;
import com.distributor.warehouse.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> allCategories() {
        List<Category> categories = categoryService.getAllCategories();

        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/")
    public ResponseEntity<Category> categoryById(@RequestParam("id") long id) {
        Category category = categoryService.getCategoryById(id);

        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping("add-update")
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category category, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            return ResponseEntity.badRequest().body(errors);
        } else {
            try {
                category.setStatus(Status.ADDED);
                Category addedCategory = categoryService.addCategory(category);
                return ResponseEntity.ok(addedCategory);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCategoryById(@RequestParam(name = "id") long id) {
        try {
            boolean deleted = categoryService.deleteCategoryById(id);
            if (deleted) {
                return ResponseEntity.ok("Categoría eliminada correctamente.");
            }
            return ResponseEntity.internalServerError().body("No se pudo eliminar la categoría");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}