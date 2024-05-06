package com.pierogarnia.viulinu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.websocket.Encoder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.math.BigDecimal;
import java.sql.Clob;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal price;
    private String imgUrl;
    private String desc;
    private String ingredients;
    private String taste;
    private String category;

    public Item(String name, BigDecimal price, String imgUrl,String desc,String ingredients,String taste,String category) {
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.desc = desc;
        this.ingredients = ingredients;
        this.taste = taste;
        this.category = category;
    }
}