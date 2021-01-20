package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "card_payment")
public class CardPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "issuing_bank")
    String issuingBank;

    @Column(name = "card_type")
    String cardType;

    @Column(name = "card_expiry_date")
    String cardExpityDate;

    @Column(name = "amount")
    int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    Order order;

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

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardExpityDate() {
        return cardExpityDate;
    }

    public void setCardExpityDate(String cardExpityDate) {
        this.cardExpityDate = cardExpityDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
