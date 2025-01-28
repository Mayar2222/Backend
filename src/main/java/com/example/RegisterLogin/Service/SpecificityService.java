package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Entity.Specificity;
import com.example.RegisterLogin.Repository.SpecificityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificityService {
    private final SpecificityRepository specificityRepository;

    public SpecificityService(SpecificityRepository specificityRepository) {
        this.specificityRepository = specificityRepository;
    }

    public List<Specificity> getAllSpecificities() {
        return specificityRepository.findAll();
    }

    public Specificity addSpecificity(Specificity specificity) {
        return specificityRepository.save(specificity);
    }
}
