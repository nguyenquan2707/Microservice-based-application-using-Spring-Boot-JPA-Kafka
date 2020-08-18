package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "unit")
    String unit;

    @Column(name = "stock_quantity")
    int stock_quantity;

    @Column(name = "reorder_level")
    int reorder_level;

    @Column(name = "unit_price")
    int unit_price;

    @Column(name = "tax_percentage")
    int tax_percentage;

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

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public int getReorder_level() {
        return reorder_level;
    }

    public void setReorder_level(int reorder_level) {
        this.reorder_level = reorder_level;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public int getTax_percentage() {
        return tax_percentage;
    }

    public void setTax_percentage(int tax_percentage) {
        this.tax_percentage = tax_percentage;
    }
}
