package com.cart.spring.project.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
public class ModelBase extends AuditableBase{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column(name = "is_deleted", length = 1)
    private Integer isDeleted;

}
