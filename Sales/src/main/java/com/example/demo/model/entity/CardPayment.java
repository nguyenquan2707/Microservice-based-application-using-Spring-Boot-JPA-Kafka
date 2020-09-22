package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "card_payment")
public class CardPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "order_id")
    long orderId;

    @Column(name = "issuing_bank")
    String issuingBank;

    @Column(name = "card_type")
    String cardType;

    @Column(name = "card_expiry_date")
    String cardExpityDate;

    @Column(name = "amount")
    int amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
