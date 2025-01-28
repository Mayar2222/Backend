package com.example.RegisterLogin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    
    @NotEmpty(message = "Le nom du client ne peut pas être vide")
    private String clientName;
    private String phoneNumber;
    private String gender;
    private String address;
    private int quantity;
    private String promotion;
    private String status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Produit product;

    @ManyToOne
    @JoinColumn(name = "pickup_address_id")
    private Location pickupAddress;

    // Constructeur par défaut
    public Commande() {}

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getPromotion() { return promotion; }
    public void setPromotion(String promotion) { this.promotion = promotion; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Produit getProduct() { return product; }
    public void setProduct(Produit product) { this.product = product; }
    public Location getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(Location pickupAddress) { this.pickupAddress = pickupAddress; }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", clientName='" + clientName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", quantity=" + quantity +
                ", promotion='" + promotion + '\'' +
                ", status='" + status + '\'' +
                ", product=" + (product != null ? product.getId() : null) +
                ", pickupAddress=" + (pickupAddress != null ? pickupAddress.getId() : null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commande)) return false;
        Commande commande = (Commande) o;
        return id != null && id.equals(commande.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}