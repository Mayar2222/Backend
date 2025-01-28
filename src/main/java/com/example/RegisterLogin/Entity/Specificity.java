package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;

@Entity
public class Specificity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String specificiteName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private boolean isColor;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecificiteName() {
        return specificiteName;
    }

    public void setSpecificiteName(String specificiteName) {
        this.specificiteName = specificiteName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isColor() {
        return isColor;
    }

    public void setColor(boolean isColor) {
        this.isColor = isColor;
    }
}
