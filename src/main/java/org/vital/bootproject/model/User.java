package org.vital.bootproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "user_name")
    private String name;


    @Column(name = "user_password")
    private String password;


    @Column(name = "user_mail")
    private String mail;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orders;

    @JsonManagedReference
    public List<Order> getOrders() {
        return orders;
    }

    /*@JsonManagedReference*/
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public User() {

    }

    public void addOrder(Order order) {
        if(orders == null) {
            orders = new ArrayList<>();
        }

        orders.add(order);
        order.setUser(this);
    }

}
