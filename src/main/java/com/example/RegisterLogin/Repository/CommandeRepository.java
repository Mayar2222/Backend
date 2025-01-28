package com.example.RegisterLogin.Repository;

import com.example.RegisterLogin.Entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}