package com.pdaniel.pizza.persistence.entity;

import com.pdaniel.pizza.persistence.audit.AuditPizzaListener;
import com.pdaniel.pizza.persistence.audit.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Table(name= "pizza")
@EntityListeners({AuditingEntityListener.class, AuditPizzaListener.class})
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pizza extends Auditable implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, length = 30,unique = true)
    private String  name;

    @Column(nullable = false, length = 150,unique = false)
    private String  description;

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double  price;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;

}
