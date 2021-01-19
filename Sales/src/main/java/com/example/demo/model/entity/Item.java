package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "unit")
    String unit;

    @Column(name = "stock_quantity")
    int stockQuantity;

    @Column(name = "unit_price")
    int unitPrice;

    @Column(name = "tax_percentage")
    int taxPercentage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}
