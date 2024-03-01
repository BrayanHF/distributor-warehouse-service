package unit.distributor.warehouse.service;

import com.distributor.warehouse.entity.Category;
import com.distributor.warehouse.entity.Status;
import com.distributor.warehouse.repository.CategoryRepository;
import com.distributor.warehouse.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceUnitTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private List<Category> categories;

    @BeforeEach
    void setUp() {
        openMocks(this);
        categories = new ArrayList<>();
        categories.add(new Category(1, "Category 1", Status.ADDED));
        categories.add(new Category(2, "Category 2", Status.ADDED));
    }

    @Test
    void allCategories() {
        when(categoryRepository.findAll()).thenReturn(categories);

        List<Category> categories = categoryService.getAllCategories();
        assertEquals(2, categories.size());
    }

    @Test
    void categoryById() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(categories.getFirst()));

        Category category = categoryService.getCategoryById(1L);
        assertEquals("Category 1", category.getName());
    }

    @Test
    void addCategory() {
        Category newCategory = new Category(3, "Category 3", Status.ADDED);

        when(categoryRepository.save(newCategory)).thenReturn(newCategory);

        Category savedCategory = categoryService.addCategory(newCategory);
        assertEquals("Category 3", savedCategory.getName());
    }

    @Test
    void deleteCategoryById() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(categories.getFirst()));when(categoryRepository.findById(1L)).thenReturn(Optional.of(categories.getFirst()));

        boolean deleted = categoryService.deleteCategoryById(1L);
        assertTrue(deleted);
    }

}