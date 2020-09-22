package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderLine")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "amount")
    int amount;

    @Column(name = "itemId")
    long itemId;

    @Column(name = "line_total")
    int lineTotal;

    @Column(name = "orderId")
    long orderId;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "tax_amount")
    int taxAmount;

    @Column(name = "unit")
    String unit;

    @Column(name = "unit_cost")
    int unitCost;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(int lineTotal) {
        this.lineTotal = lineTotal;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(int taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }
}
