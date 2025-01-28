package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Entity.Category;
import com.example.RegisterLogin.Repository.CategoryRepository;
import com.example.RegisterLogin.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Ajouter une catégorie
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Récupérer toutes les catégories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Récupérer une catégorie par son ID
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById((long) id);
    }

    // Mettre à jour une catégorie
    public Category updateCategory(int id, Category categoryDetails) {
        Category category = categoryRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Catégorie non trouvée"));

        category.setName(categoryDetails.getName()); // Mettez à jour les champs nécessaires
        return categoryRepository.save(category);  // Enregistrez les modifications dans la base
    }

    // Supprimer une catégorie
    public void deleteCategory(int id) {
        Category category = categoryRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Catégorie non trouvée"));

        categoryRepository.delete(category);
    }
}
