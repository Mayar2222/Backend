package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Entity.Produit;
import com.example.RegisterLogin.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Ajouter un nouveau produit
    @PostMapping("/add")
    public ResponseEntity<Produit> addProduit(@RequestBody Produit produit) {
        Produit newProduit = produitService.addProduit(produit);
        return ResponseEntity.ok(newProduit);
    }

    // Modifier un produit existant
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        Produit updatedProduit = produitService.updateProduit(id, produitDetails);
        return ResponseEntity.ok(updatedProduit);
    }
    @GetMapping("/specificities/category/{categoryId}")
    public ResponseEntity<List<Map<String, String>>> getSpecificitiesByCategory(@PathVariable Long categoryId) {
        List<Map<String, String>> specificities = produitService.getSpecificitiesByCategory(categoryId);
        if (specificities.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(specificities);
    }
    // Supprimer un produit par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }

    // Récupérer tous les produits
    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> products = produitService.getAllProduits();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    // Récupérer les produits d'une catégorie spécifique
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Produit>> getProductsByCategory(@PathVariable Long categoryId) {
        List<Produit> products = produitService.getProductsByCategory(categoryId);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }
}