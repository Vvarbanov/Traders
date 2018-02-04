package com.diplomna.traders.Models;

import javax.persistence.*;

@Entity
public class Storage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int quantity;
    
    @Column
    private double priceMultiplier;
    
    @Column
    private String QRHash;
    
    @OneToOne
    private User dealer;
    
    @OneToOne
    private Item item;
    
    @Column(length=100000)
    private byte[] image;
    
    public Storage(int quantity, double priceMultiplier, String QRHash, User dealer, Item item, byte[] image) {
        this.quantity = quantity;
        this.priceMultiplier = priceMultiplier;
        this.QRHash = QRHash;
        this.dealer = dealer;
        this.item = item;
        this.image = image;
    }
    
    public Storage() {}
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPriceMultiplier() {
        return priceMultiplier;
    }
    
    public void setPriceMultiplier(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }
    
    public String getQRHash() {
        return QRHash;
    }
    
    public void setQRHash(String QRHash) {
        this.QRHash = QRHash;
    }
    
    public User getDealer() {
        return dealer;
    }
    
    public void setDealer(User dealer) {
        this.dealer = dealer;
    }
    
    public Item getItem() {
        return item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
    
    public byte[] getImage() {
        return image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
}
