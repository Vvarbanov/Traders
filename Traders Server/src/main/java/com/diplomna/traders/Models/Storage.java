package com.diplomna.traders.models;

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
    private String qrHash;
    
    @OneToOne
    private User dealer;
    
    @OneToOne
    private Item item;
    
    @Column(length=100000)
    private byte[] image;   
    
    public Storage(int quantity, double priceMultiplier, String qrHash, User dealer, Item item, byte[] image) {
        this.quantity = quantity;
        this.priceMultiplier = priceMultiplier;
        this.qrHash = qrHash;
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
    
    public String getQrHash() {
        return qrHash;
    }
    
    public void setQrHash(String qrHash) {
        this.qrHash = qrHash;
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
    
    public long getId() {
        return id;
    }
}
