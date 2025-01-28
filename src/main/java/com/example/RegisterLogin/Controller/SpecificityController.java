package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Entity.Specificity;
import com.example.RegisterLogin.Service.SpecificityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specificites")
@CrossOrigin(origins = "http://localhost:3000") // Pour autoriser React
public class SpecificityController {
    private final SpecificityService specificityService;

    public SpecificityController(SpecificityService specificityService) {
        this.specificityService = specificityService;
    }

    @GetMapping
    public List<Specificity> getAllSpecificities() {
        return specificityService.getAllSpecificities();
    }

    @PostMapping("/add")
    public Specificity addSpecificity(@RequestBody Specificity specificity) {
        return specificityService.addSpecificity(specificity);
    }
}
