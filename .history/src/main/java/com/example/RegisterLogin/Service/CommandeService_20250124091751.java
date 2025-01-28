package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Entity.Commande;
import com.example.RegisterLogin.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande addCommande(Commande commande) {
        commande.setCode("CMD-" + Math.floor(Math.random() * 10000));
        commande.setStatus("commande");
        return commandeRepository.save(commande);
    }

    public Commande updateCommande(Long id, Commande commande) {
        commande.setId(id);
        return commandeRepository.save(commande);
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
    public Commande convertToPackage(Long id) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable avec l'ID : " + id));
        commande.setStatus("colis");
        return commandeRepository.save(commande);
    }

}