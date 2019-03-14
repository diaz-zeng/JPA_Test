package com.diaz.jpatest.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long id;
    @Column(name = "cust_name")
    private String name;
    @Column(name = "cust_source")
    private String source;
    @Column(name = "cust_industry")
    private String industry;
    @Column(name = "cust_level")
    private String level;
    @Column(name = "cust_address")
    private String address;
    @Column(name = "cust_phone")
    private String phone;
    @OneToMany(targetEntity = LinkMan.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<LinkMan> linkMans = new HashSet<LinkMan>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public Set<LinkMan> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<LinkMan> linkMans) {
        this.linkMans = linkMans;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", industry='" + industry + '\'' +
                ", level='" + level + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone +
                '}';
    }
}
