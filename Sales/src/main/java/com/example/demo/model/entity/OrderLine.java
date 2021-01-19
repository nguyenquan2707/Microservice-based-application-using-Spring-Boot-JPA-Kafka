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

    @Column(name = "line_total")
    int lineTotal;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "tax_amount")
    int taxAmount;

    @Column(name = "unit")
    String unit;

    @Column(name = "unit_cost")
    int unitCost;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="itemId")
    Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    Order order;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

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

    public int getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(int lineTotal) {
        this.lineTotal = lineTotal;
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
