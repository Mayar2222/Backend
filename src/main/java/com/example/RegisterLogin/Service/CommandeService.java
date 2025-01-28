package com.example.RegisterLogin.Service;

import java.util.List;

import com.example.RegisterLogin.Exception.CommandeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.Entity.Commande;
import com.example.RegisterLogin.Entity.Location;
import com.example.RegisterLogin.Entity.Produit;
import com.example.RegisterLogin.Repository.CommandeRepository;
import com.example.RegisterLogin.Repository.LocationRepository;
import com.example.RegisterLogin.Repository.ProduitRepository;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private LocationRepository locationRepository;

    // Retrieve all commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Retrieve a commande by its ID
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new CommandeNotFoundException("Commande not found with id: " + id));
    }

    // Add a new commande
    public Commande addCommande(Commande commande) {
        // You might want to validate the product and location here before saving
        return commandeRepository.save(commande);
    }

    // Update an existing commande
    public Commande updateCommande(Long id, Commande commandeDetails) {
        Commande commande = getCommandeById(id); // Fetches the commande or throws exception
        // Update the fields
        commande.setClientName(commandeDetails.getClientName());
        commande.setPhoneNumber(commandeDetails.getPhoneNumber());
        commande.setGender(commandeDetails.getGender());
        commande.setAddress(commandeDetails.getAddress());
        commande.setQuantity(commandeDetails.getQuantity());
        commande.setPromotion(commandeDetails.getPromotion());
        commande.setStatus(commandeDetails.getStatus());
        return commandeRepository.save(commande);
    }

    // Delete a commande by its ID
    public void deleteCommande(Long id) {
        if (!commandeRepository.existsById(id)) {
            throw new CommandeNotFoundException("Commande not found with id: " + id);
        }
        commandeRepository.deleteById(id);
    }

    // Retrieve all produits
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    // Retrieve all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}