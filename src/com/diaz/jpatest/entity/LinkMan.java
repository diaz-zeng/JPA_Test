package com.diaz.jpatest.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Diaz
 * @since 2019/1/7 9:30
 */
@Entity
@Table(name = "linkman")
public class LinkMan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private int id;
    @Column(name = "lkm_name")
    private String name;
    @Column(name = "lkm_phone")
    private String phone;
    @ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", customer=" + customer.getName() +
                '}';
    }
}
