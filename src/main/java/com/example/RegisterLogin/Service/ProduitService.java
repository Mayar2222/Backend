package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Entity.Produit;
import com.example.RegisterLogin.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    // Ajouter un produit
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    // Mettre à jour un produit
    public Produit updateProduit(Long id, Produit produit) {
        Optional<Produit> existingProduit = produitRepository.findById(id);
        if (existingProduit.isPresent()) {
            Produit p = existingProduit.get();
            p.setProductName(produit.getProductName());
            p.setDescription(produit.getDescription());
            p.setSku(produit.getSku());
            p.setPurchasePrice(produit.getPurchasePrice());
            p.setSalePrice(produit.getSalePrice());
            p.setMinStockAlert(produit.getMinStockAlert());
            p.setCategory(produit.getCategory());
            p.setImages(produit.getImages());
            p.setSpecificities(produit.getSpecificities());
            return produitRepository.save(p);
        }
        throw new RuntimeException("Produit not found");
    }

    // Supprimer un produit
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    // Récupérer tous les produits
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    // Récupérer les produits d'une catégorie
    public List<Produit> getProductsByCategory(Long categoryId) {
        return produitRepository.findByCategoryId(categoryId);
    }
    public List<Map<String, String>> getSpecificitiesByCategory(Long categoryId) {
        // Récupérer les produits de la catégorie par ID
        List<Produit> products = produitRepository.findByCategoryId(categoryId);
        // Extraire les spécificités des produits
        List<Map<String, String>> specificitiesList = new ArrayList<>();
        for (Produit product : products) {
            specificitiesList.add(product.getSpecificities());
        }
        return specificitiesList;
    }



}