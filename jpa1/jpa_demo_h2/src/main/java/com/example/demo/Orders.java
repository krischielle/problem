package com.example.demo;

import jakarta.annotation.Generated;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "Orders")
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;

    // @ManyToOne
    // @JoinColumn(name = "customer_id", nullable = false)
    // private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    private String shipped_location;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String purchased_total;

    public Orders() {

    };

    public Orders(String shipped_location, String purchased_total) {
        this.shipped_location = shipped_location;
        this.purchased_total = purchased_total;
    }

}
