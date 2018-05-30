package com.diplomna.traders.dtos;

public class StorageDTO {
    
    private int quantity;
    private double priceMultiplier;
    private String QRHash;
    private Long dealer;
    private Long item;
    private byte[] image;
    
    public StorageDTO(int quantity, double priceMultiplier, String QRHash, Long dealer, Long item, byte[] image) {
        this.quantity = quantity;
        this.priceMultiplier = priceMultiplier;
        this.QRHash = QRHash;
        this.dealer = dealer;
        this.item = item;
        this.image = image;
    }
    
    public StorageDTO() {}
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getPriceMultiplier() {
        return priceMultiplier;
    }
    
    public String getQRHash() {
        return QRHash;
    }
    
    public Long getDealer() {
        return dealer;
    }
    
    public Long getItem() {
        return item;
    }
    
    public byte[] getImage() {
        return image;
    }
}
