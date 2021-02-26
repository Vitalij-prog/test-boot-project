package org.vital.bootproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*@Data*/
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "users")
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



    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orders;

    public void addOrder(Order order) {
        if(orders == null) {
            orders = new ArrayList<>();
        }

        orders.add(order);
        order.setUser(this);
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
