package com.example.RegisterLogin.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande updateCommande(Long id, Commande commandeDetails) {
        Commande commande = commandeRepository.findById(id).orElseThrow();
        commande.setClientName(commandeDetails.getClientName());
        commande.setPhoneNumber(commandeDetails.getPhoneNumber());
        commande.setGender(commandeDetails.getGender());
        commande.setAddress(commandeDetails.getAddress());
        commande.setQuantity(commandeDetails.getQuantity());
        commande.setProduct(commandeDetails.getProduct());
        commande.setPickupAddress(commandeDetails.getPickupAddress());
        commande.setPromotion(commandeDetails.getPromotion());
        commande.setStatus(commandeDetails.getStatus());
        return commandeRepository.save(commande);
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
