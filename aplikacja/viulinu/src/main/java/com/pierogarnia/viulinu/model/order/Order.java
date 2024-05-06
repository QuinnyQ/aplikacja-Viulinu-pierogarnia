package com.pierogarnia.viulinu.model.order;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private String firstName;
    private String lastName;
    private String address;
    private String postCode;
    private String city;
    private String sum;
    private LocalDateTime created;
    private String nameuser;

    @OneToMany
    @JoinColumn(name = "orderId")
    private List<OrderItem> orderItems;

    public Order(String firstName, String lastName, LocalDateTime created, String address, String postCode, String city, String sum, String nameuser)
    {
        this.address=address;
        this.created=created;
        this.city=city;
        this.firstName=firstName;
        this.lastName=lastName;
        this.postCode=postCode;
        this.sum=sum;
        this.nameuser=nameuser;
    }
}
