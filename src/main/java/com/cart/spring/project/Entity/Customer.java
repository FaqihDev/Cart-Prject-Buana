package com.cart.spring.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends ModelBase{

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;


}
