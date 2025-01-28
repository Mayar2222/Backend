package com.example.RegisterLogin.Repository;

import com.example.RegisterLogin.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Recherche des produits par ID de catégorie
    List<Produit> findByCategoryId(Long categoryId);
}
