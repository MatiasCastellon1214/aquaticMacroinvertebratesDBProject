package com.mjc.macroinvertebratesCommunity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organisms")
@Entity
public class Organism {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sampling_campaign")
    private String campaign;

    @Column(name = "class_taxa")
    private String classTaxa;

    @Column(name = "order_taxa")
    private String orderTaxa;

    @Column(name = "family")
    private String family;

    @Column(name = "number")
    private int n;
}
