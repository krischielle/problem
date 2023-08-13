package com.example.demo;

import java.util.List;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

// This represents customer table in Java. Refer to example before.
@Data
@Entity(name = "Customer")
@Table(name = "Customer") // db: "customer"
public class Customer {
    @Id // Specifies the Table ID
    @GeneratedValue // We can also use specified sequences but we wont get into this. For now we
                    // will just generate this automatically.
    @Column(nullable = false) // We can use this property to specify column attributes, such
                              // as, Nullable. This means the column cannot be empty
    private long id;

    @OneToMany(mappedBy =  "orders")
    private List<Orders> orders;
    
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    private String first_name; // alt: firstName -> db: first_name

    @Column(nullable = false, columnDefinition = "TEXT")
    private String last_name; // alt: lastName -> db: last_name

    @Column(nullable = false, columnDefinition = "TEXT")
    private String date_joined;

    public Customer() {
        // This is the default constructor. It is necessary for SpringBoot.
    };

    public Customer(String first_name, String last_name, String date_joined) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_joined = date_joined;
    }
}