package com.example.demo.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @NotBlank(message = "Name field can't be blank or missing")
    @Column(name = "name")
    String name;

    @NotBlank(message = "Mobile no field can't be blank or missing")
    @Column(name = "mobile_no")
    String mobile_no;

    @NotBlank(message = "Address field can't be blank or missing")
    @Column(name = "address")
    String address;

    @OneToOne(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private CustomerSale sale;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        for(Order order : orderList){
            order.setCustomer(this);
        }
        this.orderList = orderList;
    }

    public Customer() {
        super();
    }

    public CustomerSale getSale() {
        return sale;
    }

    public void setSale(CustomerSale sale) {

        if(sale == null){
            if(this.sale != null){
                this.sale.setCustomer(null);
            }
        }else {
            sale.setCustomer(this);
        }
        this.sale = sale;
    }

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

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
