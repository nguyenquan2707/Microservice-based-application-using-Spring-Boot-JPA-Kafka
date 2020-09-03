package com.example.demo.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @NotBlank(message = "Name field can't be blank or missing")
    @Column(name = "name")
    String name;

    @NotBlank(message = "Unit field can't be blank or missing")
    @Column(name = "unit")
    String unit;

    @Min(value = 1, message = "Minimum stock field can't be missing or 0 or blank ")
    @Column(name = "stock_quantity")
    int stock_quantity;

    @Min(value = 1, message = "Reorder level field can't be missing or 0 or blank")
    @Column(name = "reorder_level")
    int reorder_level;

    @Min(value = 1, message = "Unit price field can't be missing or 0 or blank")
    @Column(name = "unit_price")
    int unit_price;

    @Min(value = 1, message = "Tax percentage field can't be missing or 0 or blank")
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
