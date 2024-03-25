package com.wit.burgerapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// Bu bir veritabanı tablosudur:
@Entity
@Table(name="burger",schema="fsweb")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Double price;
    @Column(name="isVegan")
    private Boolean isVegan;
    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    @Column(name="contents")
    private String contents;  // class olabilirdi, olsaydı daha kolay olurdu işimiz.
}
