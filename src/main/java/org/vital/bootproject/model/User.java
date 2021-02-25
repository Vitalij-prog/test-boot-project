package org.vital.bootproject.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*@Data*/
@Entity(name = "users")
public class User {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(name = "user_name")
    private String name;

    @Setter
    @Getter
    @Column(name = "user_password")
    private String password;

    @Setter
    @Getter
    @Column(name = "user_mail")
    private String mail;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orders;


    /*public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/

    public User() {

    }

    public void addOrder(Order order) {
        if(orders == null) {
            orders = new ArrayList<>();
        }

        orders.add(order);
        order.setUser(this);
    }



   /* public int getId() {
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
    }*/

    /*@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", orders=" + orders +
                '}';
    }*/
}
