package org.vital.bootproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/*@Data*/
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" /*referencedColumnName = "id"*/)
    private User user;

    @JsonBackReference
    public User getUser() {
        return user;
    }

    /*@JsonBackReference*/
    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "amount")
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "order_date")
    private Date date;

    @Column(name = "order_description")
    private String description;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Order() {}


    /*public void setOrderStatus(String status) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.getStatus().equalsIgnoreCase(status)) {
                this.orderStatus = orderStatus;
                return;
            }
        }
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
